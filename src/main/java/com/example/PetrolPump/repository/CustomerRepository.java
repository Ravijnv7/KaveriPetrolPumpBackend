package com.example.PetrolPump.repository;

import com.example.PetrolPump.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // You can add custom query methods if needed
    // Example: find by phone number
    Customer findByPhoneNumber(String phoneNumber);
}
