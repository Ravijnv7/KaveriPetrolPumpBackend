package com.example.PetrolPump.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "shifts")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Shift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ShiftType shiftType;

    @Column(nullable = false)
    private BigDecimal openingReading;
    private BigDecimal closingReading;
    @Column(nullable = false, updatable = false)
    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @PrePersist
    public void onStart() {
        this.startTime = LocalDateTime.now();
    }

}
