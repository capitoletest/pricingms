package com.capitole.inditex.pricingms.application.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDateTime;


/**
 * Response object containing the details of a price.
 *
 * @param brandId    The unique identifier of the brand.
 * @param productId  The unique identifier of the product.
 * @param priceList  The identifier of the price list.
 * @param price      The final price to apply.
 * @param startDate  Start date and time when the price is valid.
 * @param endDate    End date and time when the price is no longer valid.
 */
@Schema(name = "PriceResponse", description = "Response containing the applicable price details.")
public record PriceResponse(

        @Schema(description = "The unique identifier of the brand",
                example = "1")
        Integer brandId,

        @Schema(description = "The unique identifier of the product",
                example = "35455")
        Integer productId,

        @Schema(description = "The identifier of the price list",
                example = "2")
        Integer priceList,

        @Schema(description = "The final price to apply",
                example = "25.45")
        BigDecimal price,

        @Schema(description = "Start date and time when the price is valid",
                example = "2020-06-14T15:00:00")
        LocalDateTime startDate,

        @Schema(description = "End date and time when the price is no longer valid",
                example = "2020-06-14T18:30:00")
        LocalDateTime endDate
) {
}