package com.example.currencyconverter.service;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CurrencyConversionServiceTest {

    private final CurrencyConversionService service = new CurrencyConversionService();

    @Test
    void shouldConvertUsdToInr() {
        BigDecimal converted = service.convert("USD", "INR", new BigDecimal("10"));
        assertEquals(new BigDecimal("833.33"), converted);
    }

    @Test
    void shouldReturnRateForSameCurrency() {
        BigDecimal rate = service.getRate("EUR", "EUR");
        assertEquals(BigDecimal.ONE.setScale(8), rate.setScale(8));
    }

    @Test
    void shouldThrowForUnsupportedCurrency() {
        assertThrows(IllegalArgumentException.class, () -> service.convert("USD", "ABC", new BigDecimal("10")));
    }
}
