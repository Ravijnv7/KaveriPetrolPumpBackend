package com.example.PetrolPump.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ======================
    // Relationships
    // ======================

    // Shift is mandatory
    @ManyToOne(optional = false)
    @JoinColumn(name = "shift_id", nullable = false)
    private Shift shift;

    // Employee who did the sale
    @ManyToOne(optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    // Customer ONLY for CREDIT (validated in service)
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // CASH / UPI / CREDIT
    @ManyToOne(optional = false)
    @JoinColumn(name = "payment_mode_id", nullable = false)
    private PaymentMode paymentMode;

    // MS or HSD
    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    // ======================
    // Transaction data
    // ======================

    @Column(nullable = false, precision = 10, scale = 3)
    private BigDecimal liters;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal ratePerLiter;

    @Column(nullable = false, updatable = false, precision = 12, scale = 2)
    private BigDecimal amount;

    @Column(nullable = false, updatable = false)
    private LocalDateTime transactionDate;

    // ======================
    // Lifecycle
    // ======================

    @PrePersist
    protected void onCreate() {
        this.transactionDate = LocalDateTime.now();
        this.amount = liters.multiply(ratePerLiter);
    }

    // ======================
    // Getters & Setters
    // ======================

    public Long getId() {
        return id;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getLiters() {
        return liters;
    }

    public void setLiters(BigDecimal liters) {
        this.liters = liters;
    }

    public BigDecimal getRatePerLiter() {
        return ratePerLiter;
    }

    public void setRatePerLiter(BigDecimal ratePerLiter) {
        this.ratePerLiter = ratePerLiter;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }
}
