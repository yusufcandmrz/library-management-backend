package com.yusufcandmrz.librarymanagement.account.exception;

import java.time.LocalDateTime;

public record ErrorResponse(int statusCode, String message, String path, LocalDateTime timestamp) {
}