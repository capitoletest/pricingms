package com.capitole.inditex.pricingms.application.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response object containing the details of a price.
 *
 * @param priceId    The unique identifier of the price.
 * @param brandId    The unique identifier of the brand.
 * @param productId  The unique identifier of the product.
 * @param priceList  The price list identifier.
 * @param priority   The priority of the price in case of multiple prices.
 * @param price      The actual price value.
 * @param currency   The currency in which the price is expressed.
 * @param startDate  The start date and time when the price is valid.
 * @param endDate    The end date and time when the price is no longer valid.
 */
public record PriceResponse(
        UUID priceId,
        UUID brandId,
        UUID productId,
        Integer priceList,
        Integer priority,
        BigDecimal price,
        String currency,
        LocalDateTime startDate,
        LocalDateTime endDate
) {
}
