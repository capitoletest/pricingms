package com.capitole.inditex.pricingms.application.service;

import com.capitole.inditex.pricingms.application.command.GetPriceCommand;
import com.capitole.inditex.pricingms.application.response.PriceResponse;
import com.capitole.inditex.pricingms.infrastructure.config.IntegrationTestBase;
import com.capitole.inditex.pricingms.infrastructure.exception.PriceNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class GetPriceServiceIntegrationTest extends IntegrationTestBase {

    
    @Autowired
    private GetPriceService getPriceService;

    @Test
    void shouldReturnCorrectPriceForGivenDate1() {
        GetPriceCommand command = new GetPriceCommand(1, 35455, LocalDateTime.of(2020, 6, 14, 10, 0));
        PriceResponse response = getPriceService.execute(command);

        assertEquals(1, response.priceList());
        assertEquals(35.50, response.price().doubleValue());
    }

    @Test
    void shouldReturnCorrectPriceForGivenDate2() {
        GetPriceCommand command = new GetPriceCommand(1, 35455, LocalDateTime.of(2020, 6, 14, 16, 0));
        PriceResponse response = getPriceService.execute(command);

        assertEquals(2, response.priceList());
        assertEquals(25.45, response.price().doubleValue());
    }

    @Test
    void shouldReturnCorrectPriceForGivenDate3() {
        GetPriceCommand command = new GetPriceCommand(1, 35455, LocalDateTime.of(2020, 6, 14, 21, 0));
        PriceResponse response = getPriceService.execute(command);

        assertEquals(1, response.priceList());
        assertEquals(35.50, response.price().doubleValue());
    }

    @Test
    void shouldReturnCorrectPriceForGivenDate4() {
        GetPriceCommand command = new GetPriceCommand(1, 35455, LocalDateTime.of(2020, 6, 15, 10, 0));
        PriceResponse response = getPriceService.execute(command);

        assertEquals(3, response.priceList());
        assertEquals(30.50, response.price().doubleValue());
    }

    @Test
    void shouldReturnCorrectPriceForGivenDate5() {
        GetPriceCommand command = new GetPriceCommand(1, 35455, LocalDateTime.of(2020, 6, 16, 21, 0));
        PriceResponse response = getPriceService.execute(command);

        assertEquals(4, response.priceList());
        assertEquals(38.95, response.price().doubleValue());
    }

    @Test
    void shouldThrowExceptionWhenNoPriceFound() {
        GetPriceCommand command = new GetPriceCommand(1, 99999, LocalDateTime.of(2020, 6, 14, 10, 0));

        Exception exception = assertThrows(PriceNotFoundException.class, () -> {
            getPriceService.execute(command);
        });

        assertEquals("No applicable price found", exception.getMessage());
    }
}