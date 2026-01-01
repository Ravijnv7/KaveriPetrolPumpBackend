package com.example.PetrolPump.entity;


import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Shift is mandatory
    @ManyToOne(optional = false)
    @JoinColumn(name = "shift_id")
    private Shift shift;

    // Employee who did the sale
    @ManyToOne(optional = false)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    // Customer only for CREDIT
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // CASH / UPI / CREDIT
    @ManyToOne(optional = false)
    @JoinColumn(name = "payment_mode_id")
    private PaymentMode paymentMode;

    // MS or HSD (single product)
    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id")
    private Product product;

    // Meter-based quantity
    @Column(nullable = false)
    private BigDecimal liters;

    // Rate at that moment (IMPORTANT)
    @Column(nullable = false)
    private BigDecimal ratePerLiter;

    // liters × rate
    @Column(nullable = false)
    private BigDecimal amount;

    private LocalDateTime transactionDate;

    @PrePersist
    void onCreate() {
        this.transactionDate = LocalDateTime.now();
        this.amount = liters.multiply(ratePerLiter);
    }
}
