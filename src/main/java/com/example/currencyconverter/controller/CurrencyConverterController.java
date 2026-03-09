package com.example.currencyconverter.controller;

import com.example.currencyconverter.model.ConversionRequest;
import com.example.currencyconverter.model.ConversionResponse;
import com.example.currencyconverter.service.CurrencyConversionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/currency")
public class CurrencyConverterController {

    private final CurrencyConversionService conversionService;

    public CurrencyConverterController(CurrencyConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @PostMapping("/convert")
    public ConversionResponse convert(@Valid @RequestBody ConversionRequest request) {
        BigDecimal rate = conversionService.getRate(request.getFrom(), request.getTo());
        BigDecimal converted = conversionService.convert(request.getFrom(), request.getTo(), request.getAmount());

        return new ConversionResponse(
                request.getFrom().toUpperCase(),
                request.getTo().toUpperCase(),
                request.getAmount(),
                converted,
                rate
        );
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}
