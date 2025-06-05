package com.capitole.inditex.pricingms.application.command;

import java.time.LocalDateTime;
import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Command to retrieve the price for a specific product and brand at a given application date.
 */
@Schema(name = "GetPriceCommand", description = "Request object containing the necessary data to retrieve a price.")
public record GetPriceCommand(

        @Schema(
                description = "The unique identifier of the brand",
                example = "50accdf5-b58a-4878-9254-aa86c1e9ef8b"
        )
        UUID brandId,

        @Schema(
                description = "The unique identifier of the product",
                example = "ca782e22-8210-4bdc-9e19-f6af08efd0d5"
        )
        UUID productId,

        @Schema(
                description = "The date and time when the price is requested",
                example = "2020-06-14T10:00:00"
        )
        LocalDateTime applicationDate
) {
}
