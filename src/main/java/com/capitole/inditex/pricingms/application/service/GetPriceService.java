package com.capitole.inditex.pricingms.application.service;

import com.capitole.inditex.pricingms.application.command.GetPriceCommand;
import com.capitole.inditex.pricingms.application.response.PriceResponse;
import com.capitole.inditex.pricingms.application.usecase.GetPriceLogic;
import com.capitole.inditex.pricingms.domain.model.Price;
import com.capitole.inditex.pricingms.domain.port.PriceRepositoryPort;
import com.capitole.inditex.pricingms.infrastructure.exception.PriceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;

/**
 * Service implementation for retrieving the applicable price based on brand ID, product ID, and application date.
 * This service uses the PriceRepositoryPort to access the underlying data store.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public final class GetPriceService implements GetPriceLogic {

    /**
     * The repository used to perform database operations related to prices.
     */
    private final PriceRepositoryPort priceRepository;

    /**
     * Executes the logic to retrieve the applicable price based on the provided command.
     *
     * @param command the command containing brand ID, product ID, and application date
     * @return the PriceResponse containing the applicable price details
     */
    @Override
    public PriceResponse execute(final GetPriceCommand command) {
        log.info("Searching price for brandId={}, productId={}, date={}",
                command.brandId(), command.productId(), command.applicationDate());

        var candidates = priceRepository.findByBrandIdAndProductIdAndApplicationDate(
                command.brandId(), command.productId(), command.applicationDate());

        log.info("Found {} applicable price records", candidates.size());

        return candidates.stream()
                .max(Comparator.comparingInt(Price::priority))
                .map(this::mapToResponse)
                .orElseThrow(() -> {
                    log.warn("No applicable price found for the request");
                    return new PriceNotFoundException("No applicable price found");
                });
    }

    /**
     * Maps a Price domain model to a PriceResponse DTO.
     *
     * @param price the Price domain model
     * @return the mapped PriceResponse DTO
     */
    private PriceResponse mapToResponse(Price price) {
        return new PriceResponse(
                price.id(),
                price.brandId(),
                price.productId(),
                price.priceList(),
                price.priority(),
                price.price(),
                price.currency(),
                price.startDate(),
                price.endDate()
        );
    }
}