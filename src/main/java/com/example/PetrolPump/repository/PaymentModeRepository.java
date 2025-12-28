package com.example.PetrolPump.repository;

import com.example.PetrolPump.entity.PaymentMode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentModeRepository extends JpaRepository<PaymentMode, Long> {
}
