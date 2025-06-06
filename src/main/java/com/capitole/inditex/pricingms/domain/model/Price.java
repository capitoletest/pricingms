package com.capitole.inditex.pricingms.domain.model;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Represents a price in the pricing system.
 * Contains details about the price, including brand, product, and applicable dates.
 *
 * @param id        Unique identifier for the price.
 * @param brandId   Identifier for the brand associated with the price.
 * @param startDate Start date when the price becomes applicable.
 * @param endDate   End date when the price is no longer applicable.
 * @param priceList Identifier for the price list this price belongs to.
 * @param productId Identifier for the product associated with the price.
 * @param priority  Priority of the price in case multiple prices apply at the same time.
 * @param price     The price amount.
 * @param currency  Currency in which the price is expressed.
 */

@Builder
public record Price(Integer id, Integer brandId, LocalDateTime startDate, LocalDateTime endDate, Integer priceList,
                    Integer productId, Integer priority, BigDecimal price, String currency) {
}
