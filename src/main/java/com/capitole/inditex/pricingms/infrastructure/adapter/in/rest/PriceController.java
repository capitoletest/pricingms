package com.capitole.inditex.pricingms.infrastructure.adapter.in.rest;

import com.capitole.inditex.pricingms.application.command.GetPriceCommand;
import com.capitole.inditex.pricingms.application.response.PriceResponse;
import com.capitole.inditex.pricingms.application.usecase.GetPriceLogic;
import com.capitole.inditex.pricingms.infrastructure.exception.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * PriceController is a REST controller that handles HTTP requests related to product pricing.
 * It provides endpoints for querying the applicable price of a product based on brand ID, product ID, and application date.
 * Annotations:
 * - @RestController: Marks this class as a Spring REST controller.
 * - @RequestMapping("/api/prices"): Maps HTTP requests to the "/api/prices" path.
 * - @RequiredArgsConstructor: Generates a constructor with required arguments (final fields).
 * - @Tag: Adds metadata for OpenAPI documentation, specifying the name and description of the controller.
 */
@RestController
@RequestMapping("/api/prices")
@RequiredArgsConstructor
@Tag(name = "Price Controller", description = "Endpoints for querying product prices")
public class PriceController {

    /**
     * The logic service used to retrieve the applicable price based on brand ID, product ID, and application date.
     */
    private final GetPriceLogic getPriceLogic;

    /**
     * Endpoint to retrieve the applicable price for a given product, brand, and application date.
     *
     * @param command the command containing brand ID, product ID, and application date
     * @return a ResponseEntity containing the PriceResponse with the applicable price details
     */
    @PostMapping
    @Operation(
            summary = "Get applicable price",
            description = "Returns the applicable price for a given product, brand, and application date"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Applicable price successfully retrieved",
                    content = @Content(schema = @Schema(implementation = PriceResponse.class))),
            @ApiResponse(responseCode = "404", description = "No applicable price found",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<PriceResponse> getPrice(@Valid @RequestBody final GetPriceCommand command) {
        PriceResponse response = getPriceLogic.execute(command);
        return ResponseEntity.ok(response);
    }
}