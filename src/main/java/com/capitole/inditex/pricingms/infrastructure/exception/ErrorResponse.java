package com.capitole.inditex.pricingms.infrastructure.exception;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Represents an error response that includes a code and a message.
 * This is used to provide structured error information in API responses.
 */
@Schema(name = "ErrorResponse", description = "Error response with code and message")
public record ErrorResponse(

        @Schema(description = "Error code identifier", example = "PRICE_NOT_FOUND")
        String code,

        @Schema(description = "Human-readable error message", example = "No applicable price found for the given criteria")
        String message
) {
}