package com.example.PetrolPump.entity;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;
@Entity
@Table(name = "employees")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String employeeName;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    // Many employees → One shift
    @ManyToOne
    @JoinColumn(name = "shift_id", nullable = false)
    private Shift shift;

    // One employee → Many transactions
    @OneToMany(mappedBy = "employee")
    private List<Transaction> transactions;
}
