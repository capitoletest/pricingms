package com.capitole.inditex.pricingms.infrastructure.adapter.out.jpa;

import com.capitole.inditex.pricingms.infrastructure.entitty.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Spring Data JPA repository for managing PriceEntity instances.
 * Provides methods to query prices based on brand ID, product ID, and application date.
 */
public interface SpringDataPriceRepository extends JpaRepository<PriceEntity, Integer> {

    /**
     * Finds a list of PriceEntity instances based on the given brand ID, product ID, and application date.
     *
     * @param brandId          the ID of the brand
     * @param productId        the ID of the product
     * @param applicationDate  the date when the price is applicable
     * @return a list of PriceEntity instances that match the criteria
     */
    @Query(value =
            """
            SELECT p FROM PriceEntity p
            WHERE p.brandId = :brandId AND p.productId = :productId
            AND :applicationDate BETWEEN p.startDate AND p.endDate
            """)
    List<PriceEntity> findByBrandIdAndProductIdAndDate(Integer brandId, Integer productId, LocalDateTime applicationDate);
}