package com.yusufcandmrz.librarymanagement.book.entity;

public enum BookStatus {
    AVAILABLE,
    BORROWED,
    RESERVED, // This value usable when Reservation Service added
    LOST
}
