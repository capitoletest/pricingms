package com.capitole.inditex.pricingms.infrastructure.exception;

/**
 * Exception thrown when a price is not found in the system.
 * This exception is used to indicate that a requested price
 * could not be located, typically when querying for a price
 * based on certain criteria such as product ID, brand ID, and date.
 */
public class PriceNotFoundException extends RuntimeException {

    /**
     * Constructs a new PriceNotFoundException with the specified detail message.
     *
     * @param message the detail message, which is saved for later retrieval by the getMessage() method
     */
    public PriceNotFoundException(final String message) {
        super(message);
    }
}
