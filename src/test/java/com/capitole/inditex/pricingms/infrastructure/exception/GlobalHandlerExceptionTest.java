package com.capitole.inditex.pricingms.infrastructure.exception;

import jakarta.validation.ConstraintViolation;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.sql.SQLException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GlobalHandlerExceptionTest {

    private final GlobalHandlerException handler = new GlobalHandlerException();

    @Test
    void testHandlePriceNotFound() {
        PriceNotFoundException ex = new PriceNotFoundException("Price not found");
        ResponseEntity<ErrorResponse> response = handler.handlePriceNotFound(ex);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("PRICE_NOT_FOUND", response.getBody().code());
        assertEquals("Price not found", response.getBody().message());
    }

    @Test
    void testHandleValidationErrors() {
        var bindingResult = new BeanPropertyBindingResult(new Object(), "objectName");
        bindingResult.addError(new FieldError("objectName", "field", "must not be blank"));

        MethodArgumentNotValidException ex = new MethodArgumentNotValidException(null, bindingResult);
        ResponseEntity<ErrorResponse> response = handler.handleValidationErrors(ex);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("VALIDATION_ERROR", response.getBody().code());
        assertTrue(response.getBody().message().contains("field: must not be blank"));
    }

    @Test
    void testHandleConstraintViolation() {
        ConstraintViolation<?> violation = mock(ConstraintViolation.class);
        when(violation.getMessage()).thenReturn("value must be valid");

        ConstraintViolationException ex = new ConstraintViolationException("value must be valid",new SQLException(), Set.of(violation).toString());
        ResponseEntity<ErrorResponse> response = handler.handleConstraintViolation(ex);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("CONSTRAINT_VIOLATION", response.getBody().code());
        assertEquals("value must be valid", response.getBody().message());
    }

    @Test
    void testHandleIllegalArgument() {
        IllegalArgumentException ex = new IllegalArgumentException("Invalid input");
        ResponseEntity<ErrorResponse> response = handler.handleIllegalArgument(ex);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("BAD_REQUEST", response.getBody().code());
        assertEquals("Invalid input", response.getBody().message());
    }

    @Test
    void testHandleGeneralException() {
        Exception ex = new Exception("Unexpected failure");
        ResponseEntity<ErrorResponse> response = handler.handleGeneralException(ex);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("INTERNAL_ERROR", response.getBody().code());
        assertEquals("An unexpected error occurred", response.getBody().message());
    }
}