package com.example.currencyconverter.model;

import java.math.BigDecimal;

public class ConversionResponse {

    private String from;
    private String to;
    private BigDecimal originalAmount;
    private BigDecimal convertedAmount;
    private BigDecimal exchangeRate;

    public ConversionResponse(String from, String to, BigDecimal originalAmount, BigDecimal convertedAmount, BigDecimal exchangeRate) {
        this.from = from;
        this.to = to;
        this.originalAmount = originalAmount;
        this.convertedAmount = convertedAmount;
        this.exchangeRate = exchangeRate;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public BigDecimal getOriginalAmount() {
        return originalAmount;
    }

    public BigDecimal getConvertedAmount() {
        return convertedAmount;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }
}
