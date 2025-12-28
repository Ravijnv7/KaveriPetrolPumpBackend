package com.example.PetrolPump.entity;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "shifts")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Shift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private ShiftType shiftType;
}
