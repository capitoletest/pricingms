package com.capitole.inditex.pricingms.application.command;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

/**
 * Command to retrieve the price for a specific product and brand at a given application date.
 * @param brandId the unique identifier of the brand
 * @param productId the unique identifier of the product
 * @param applicationDate the date and time when the price is requested
 */
@Schema(name = "GetPriceCommand", description = "Request object containing the necessary data to retrieve a price.")
public record GetPriceCommand(

        @NotNull(message = "brandId must not be null")
        @Schema(
                description = "The unique identifier of the brand",
                example = "1"
        )
        Integer brandId,

        @NotNull(message = "brandId must not be null")
        @Schema(
                description = "The unique identifier of the product",
                example = "35455"
        )
        Integer productId,

        @NotNull(message = "brandId must not be null")
        @Schema(
                description = "The date and time when the price is requested",
                example = "2020-06-14T10:00:00"
        )
        LocalDateTime applicationDate
) {
}
