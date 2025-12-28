package com.example.PetrolPump.service;

import com.example.PetrolPump.entity.Customer;
import com.example.PetrolPump.entity.Transaction;

import java.time.LocalDateTime;
import java.util.List;

public interface CustomerService {
    Customer addCustomer(Customer customer);
    Customer getCustomerById(Long id);
    List<Transaction> getCustomerBill(Long customerId, String from, String to);
}

