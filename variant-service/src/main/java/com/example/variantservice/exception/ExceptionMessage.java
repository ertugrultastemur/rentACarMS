package com.example.variantservice.exception;

public record ExceptionMessage(String timestamp,
        int status,
        String error,
        String message,
        String path) {}
