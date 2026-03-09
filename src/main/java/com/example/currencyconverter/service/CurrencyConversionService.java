package com.example.currencyconverter.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

@Service
public class CurrencyConversionService {

    private static final Map<String, BigDecimal> RATE_TO_USD = Map.of(
            "USD", BigDecimal.ONE,
            "EUR", new BigDecimal("1.08"),
            "INR", new BigDecimal("0.012"),
            "GBP", new BigDecimal("1.27"),
            "JPY", new BigDecimal("0.0068")
    );

    public BigDecimal getRate(String from, String to) {
        String source = normalize(from);
        String target = normalize(to);

        if (!RATE_TO_USD.containsKey(source) || !RATE_TO_USD.containsKey(target)) {
            throw new IllegalArgumentException("Unsupported currency. Supported: " + RATE_TO_USD.keySet());
        }

        BigDecimal fromToUsd = RATE_TO_USD.get(source);
        BigDecimal toToUsd = RATE_TO_USD.get(target);

        return fromToUsd.divide(toToUsd, 8, RoundingMode.HALF_UP);
    }

    public BigDecimal convert(String from, String to, BigDecimal amount) {
        BigDecimal rate = getRate(from, to);
        return amount.multiply(rate).setScale(2, RoundingMode.HALF_UP);
    }

    private String normalize(String code) {
        return code == null ? null : code.trim().toUpperCase();
    }
}
