package com.capitole.inditex.pricingms.infrastructure.exception;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.util.stream.Collectors;

/**
 * GlobalHandlerException is a centralized exception handler for the application.
 * It uses the @RestControllerAdvice annotation to provide global exception handling
 * for REST controllers, ensuring consistent error responses across the application.
 *
 * Annotations:
 * - @ControllerAdvice: Indicates that this class provides global exception handling
 *   for REST controllers in a Spring Boot application.
 */
@ControllerAdvice
public class GlobalHandlerException {

    /**
     * Handles PriceNotFoundException and returns a 404 Not Found response.
     *
     * @param ex the exception thrown when a price is not found
     * @return ResponseEntity with error details
     */
    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlePriceNotFound(PriceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse("PRICE_NOT_FOUND", ex.getMessage()));
    }

    /**
     * Handles MethodArgumentNotValidException and returns a 400 Bad Request response with validation errors.
     *
     * @param ex the exception thrown when method arguments are not valid
     * @return ResponseEntity with error details
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationErrors(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining(", "));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse("VALIDATION_ERROR", message));
    }

    /**
     * Handles ConstraintViolationException and returns a 400 Bad Request response with constraint violation details.
     *
     * @param ex the exception thrown when a constraint is violated
     * @return ResponseEntity with error details
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolation(ConstraintViolationException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse("CONSTRAINT_VIOLATION", ex.getMessage()));
    }

    /**
     * Handles IllegalArgumentException and returns a 400 Bad Request response with the error message.
     *
     * @param ex the exception thrown when an illegal argument is provided
     * @return ResponseEntity with error details
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse("BAD_REQUEST", ex.getMessage()));
    }

    /**
     * Handles general exceptions and returns a 500 Internal Server Error response.
     *
     * @param ex the exception thrown
     * @return ResponseEntity with error details
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse("INTERNAL_ERROR", "An unexpected error occurred"));
    }
}