package com.example.PetrolPump.entity;


import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

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
