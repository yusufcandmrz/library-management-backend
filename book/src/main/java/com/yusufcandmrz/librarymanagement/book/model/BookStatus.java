package com.yusufcandmrz.librarymanagement.book.model;

public enum BookStatus {
    AVAILABLE,
    BORROWED,
    RESERVED, // This value usable when Reservation Service added
    LOST
}
