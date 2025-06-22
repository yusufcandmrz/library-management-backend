package com.yusufcandmrz.librarymanagement.loan.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "loan")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "account_id", nullable = false)
    private UUID accountId;

    @ElementCollection
    @CollectionTable(name = "loan_book", joinColumns = @JoinColumn(name = "loan_id"))
    @Column(name = "book_id", nullable = false)
    private List<UUID> bookIds;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private LoanStatus status;

    @CreationTimestamp
    @Column(name = "loan_date", updatable = false, nullable = false)
    private Timestamp loanDate;

    @Column(name = "due_date")
    private Timestamp dueDate;

    @Column(name = "return_date")
    private Timestamp returnDate;
}
