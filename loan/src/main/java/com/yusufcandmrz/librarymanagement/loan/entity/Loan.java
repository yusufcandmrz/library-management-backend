package com.yusufcandmrz.librarymanagement.loan.entity;

import java.sql.Timestamp;
import java.util.UUID;

public class Loan {
    private UUID id;
    private Book book;
    private Account account;
    private String status; //(Enum: 'LOANED', 'RETURNED', 'OVERDUE');
    private Timestamp loanDate;
    private Timestamp dueDate;
    private Timestamp returnDate;
}
