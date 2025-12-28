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

    private BigDecimal transactionAmount;

    private LocalDateTime transactionDate;

    // Many transactions → One customer
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // Many transactions → One employee
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    // Many transactions → One payment mode
    @ManyToOne
    @JoinColumn(name = "payment_mode_id")
    private PaymentMode paymentMode;

    // Products (best practice is TransactionItem)
    @ManyToMany
    @JoinTable(
            name = "transaction_products",
            joinColumns = @JoinColumn(name = "transaction_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> products;

    @PrePersist
    void createdAt() {
        this.transactionDate = LocalDateTime.now();
    }
}
