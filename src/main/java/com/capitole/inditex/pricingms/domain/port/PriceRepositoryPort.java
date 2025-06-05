package com.capitole.inditex.pricingms.domain.port;

import com.capitole.inditex.pricingms.domain.model.Price;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Port interface for Price repository operations.
 * This interface defines the contract for retrieving prices based on brand ID, product ID, and application date.
 */
public interface PriceRepositoryPort {

    /**
     * Finds a list of prices based on the given brand ID, product ID, and application date.
     *
     * @param brandId          the ID of the brand
     * @param productId        the ID of the product
     * @param applicationDate  the date when the price is applicable
     * @return a list of prices that match the criteria
     */
    List<Price> findByBrandIdAndProductIdAndApplicationDate(
            Integer brandId, Integer productId, LocalDateTime applicationDate);

}
