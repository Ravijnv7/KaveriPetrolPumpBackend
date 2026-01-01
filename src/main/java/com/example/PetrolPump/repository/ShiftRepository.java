package com.example.PetrolPump.repository;

import com.example.PetrolPump.entity.Shift;
import com.example.PetrolPump.entity.ShiftType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShiftRepository extends JpaRepository<Shift, Long> {
    Optional<Shift> findByShiftTypeAndClosingReadingIsNull(ShiftType shiftType);
}
