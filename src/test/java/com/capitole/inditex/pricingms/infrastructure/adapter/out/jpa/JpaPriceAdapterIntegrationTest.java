package com.capitole.inditex.pricingms.infrastructure.adapter.out.jpa;

import com.capitole.inditex.pricingms.domain.model.Price;
import com.capitole.inditex.pricingms.domain.port.PriceRepositoryPort;
import com.capitole.inditex.pricingms.infrastructure.config.IntegrationTestBase;
import com.capitole.inditex.pricingms.infrastructure.mapper.PriceMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JpaPriceAdapterIntegrationTest extends IntegrationTestBase {

    @Autowired
    private SpringDataPriceRepository springDataPriceRepository;

    @Autowired
    private PriceMapper priceMapper;

    private PriceRepositoryPort priceRepository;

    @Test
    void shouldReturnMatchingPrices() {
        priceRepository = new JpaPriceAdapter(springDataPriceRepository, priceMapper);

        Integer brandId = 1;
        Integer productId = 35455;
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 16, 0);

        List<Price> prices = priceRepository.findByBrandIdAndProductIdAndApplicationDate(brandId, productId, applicationDate);

        Price price = prices.get(0);

        assertFalse(prices.isEmpty(), "Expected to find prices");

        assertEquals(1, price.brandId());
        assertEquals(35455, price.productId());
        assertEquals("EUR", price.currency());
        assertEquals(35.50, price.price().doubleValue(), 0.01, "Expected price to be 35.50");
    }

    @Test
    void shouldReturnEmptyListIfNoMatch() {
        priceRepository = new JpaPriceAdapter(springDataPriceRepository, priceMapper);

        Integer brandId = 1;
        Integer productId = 99999;
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 10, 0);

        List<Price> prices = priceRepository.findByBrandIdAndProductIdAndApplicationDate(brandId, productId, applicationDate);

        assertTrue(prices.isEmpty(), "Expected no matching prices");
    }
}