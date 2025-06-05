package com.capitole.inditex.pricingms.application.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response object containing the details of a price.
 */
@Schema(name = "PriceResponse", description = "Response containing the applicable price details.")
public record PriceResponse(

        @Schema(description = "The unique identifier of the price",
                example = "c43cde73-9474-4116-ad99-a14d08fb3dc0")
        UUID priceId,

        @Schema(description = "The unique identifier of the brand",
                example = "50accdf5-b58a-4878-9254-aa86c1e9ef8b")
        UUID brandId,

        @Schema(description = "The unique identifier of the product",
                example = "ca782e22-8210-4bdc-9e19-f6af08efd0d5")
        UUID productId,

        @Schema(description = "The identifier of the price list",
                example = "2")
        Integer priceList,

        @Schema(description = "The priority of the price",
                example = "1")
        Integer priority,

        @Schema(description = "The final price to apply",
                example = "25.45")
        BigDecimal price,

        @Schema(description = "The ISO 4217 currency code of the price",
                example = "EUR")
        String currency,

        @Schema(description = "Start date and time when the price is valid",
                example = "2020-06-14T15:00:00")
        LocalDateTime startDate,

        @Schema(description = "End date and time when the price is no longer valid",
                example = "2020-06-14T18:30:00")
        LocalDateTime endDate
) {
}