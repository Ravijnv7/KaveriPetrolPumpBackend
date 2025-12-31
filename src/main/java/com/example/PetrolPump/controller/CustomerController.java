package com.example.PetrolPump.controller;

import com.example.PetrolPump.entity.Customer;
import com.example.PetrolPump.entity.Transaction;
import com.example.PetrolPump.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public Customer addCustomer( @Valid @RequestBody Customer customer) {
        System.out.println("Received customer: " + customer);
        return customerService.addCustomer(customer);
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping("/{id}/bill")
    public List<Transaction> getCustomerBill(
            @PathVariable Long id,
            @RequestParam String fromDate,
            @RequestParam String toDate) {

        return customerService.getCustomerBill(id, fromDate, toDate);
    }
}

