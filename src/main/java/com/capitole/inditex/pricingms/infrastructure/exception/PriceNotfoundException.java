package com.capitole.inditex.pricingms.infrastructure.exception;

public class PriceNotfoundException extends RuntimeException {
    public PriceNotfoundException(String message) {
        super(message);
    }
}
