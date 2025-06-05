package com.capitole.inditex.pricingms.infrastructure.entitty;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Entity representing a price in the pricing system.
 * Maps to the 'prices' table in the 'pricing' schema.
 */
@Entity
@Table(schema = "pricing", name = "prices")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PriceEntity {

    /**
     * Unique identifier for the price.
     */
    @Id
    @Column(name = "prices_id", nullable = false)
    private UUID id;

    /**
     * Identifier for the brand associated with the price.
     */
    @Column(name = "prices_brand_id", nullable = false)
    private UUID brandId;

    /**
     * Start date when the price becomes applicable.
     */
    @Column(name = "prices_start_date", nullable = false)
    private LocalDateTime startDate;

    /**
     * End date when the price is no longer applicable.
     */
    @Column(name = "prices_end_date", nullable = false)
    private LocalDateTime endDate;

    /**
     * Identifier for the price list this price belongs to.
     */
    @Column(name = "prices_price_list", nullable = false)
    private Integer priceList;

    /**
     * Identifier for the product associated with the price.
     */
    @Column(name = "prices_product_id", nullable = false)
    private UUID productId;

    /**
     * Priority of the price in case multiple prices apply at the same time.
     */
    @Column(name = "prices_priority", nullable = false)
    private Integer priority;

    /**
     * The price amount.
     */
    @Column(name = "prices_price", nullable = false)
    private BigDecimal price;

    /**
     * Currency in which the price is expressed.
     */
    @Column(name = "prices_currency", nullable = false, length = 3)
    private String currency;
}
