package com.example.currencyconverter.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Schema(description = "Currency conversion request payload")
public class ConversionRequest {

    @NotBlank(message = "Source currency is required")
    @Schema(example = "USD", description = "Source currency code")
    private String from;

    @NotBlank(message = "Target currency is required")
    @Schema(example = "INR", description = "Target currency code")
    private String to;

    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Amount must be greater than zero")
    @Schema(example = "100.50", description = "Amount to convert")
    private BigDecimal amount;
}
