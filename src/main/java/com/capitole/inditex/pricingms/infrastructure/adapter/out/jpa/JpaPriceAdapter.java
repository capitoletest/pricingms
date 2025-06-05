package com.capitole.inditex.pricingms.infrastructure.adapter.out.jpa;

import com.capitole.inditex.pricingms.domain.model.Price;
import com.capitole.inditex.pricingms.domain.port.PriceRepositoryPort;
import com.capitole.inditex.pricingms.infrastructure.mapper.PriceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * JpaPriceAdapter is an implementation of the PriceRepositoryPort interface.
 * It uses Spring Data JPA to interact with the database and retrieve price information.
 */
@Repository
@RequiredArgsConstructor
public class JpaPriceAdapter implements PriceRepositoryPort {

    /**
     * The repository used to perform database operations.
     */
    private final SpringDataPriceRepository repository;

    /**
     * The mapper used to convert between PriceEntity and Price domain model.
     */
    private final PriceMapper mapper;

    /**
     * Finds a list of prices based on the given brand ID, product ID, and application date.
     *
     * @param brandId          the ID of the brand
     * @param productId        the ID of the product
     * @param applicationDate  the date when the price is applicable
     * @return a list of prices that match the criteria
     */
    @Override
    public List<Price> findByBrandIdAndProductIdAndApplicationDate(Integer brandId, Integer productId, LocalDateTime applicationDate) {

        return repository.findByBrandIdAndProductIdAndDate(brandId, productId, applicationDate)
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}
