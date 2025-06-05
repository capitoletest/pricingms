package com.capitole.inditex.pricingms.application.command;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Command to retrieve the price for a specific product and brand at a given application date.
 *
 * @param brandId         The unique identifier of the brand.
 * @param productId       The unique identifier of the product.
 * @param applicationDate The date and time when the price is requested.
 */
public record GetPriceCommand(
        UUID brandId,
        UUID productId,
        LocalDateTime applicationDate
) {
}