package com.example.currencyconverter.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Schema(description = "Currency conversion response payload")
public class ConversionResponse {

    @Schema(example = "USD")
    private String from;

    @Schema(example = "INR")
    private String to;

    @Schema(example = "100.50")
    private BigDecimal originalAmount;

    @Schema(example = "8375.00")
    private BigDecimal convertedAmount;

    @Schema(example = "83.33333333")
    private BigDecimal exchangeRate;
}
