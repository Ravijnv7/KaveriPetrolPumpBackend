package com.example.PetrolPump.service.Impl;
import com.example.PetrolPump.entity.Customer;
import com.example.PetrolPump.entity.Transaction;
import com.example.PetrolPump.repository.CustomerRepository;
import com.example.PetrolPump.repository.TransactionRepository;
import com.example.PetrolPump.service.CustomerService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final TransactionRepository transactionRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository,
                               TransactionRepository transactionRepository) {
        this.customerRepository = customerRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }



    public List<Transaction> getCustomerBill(Long customerId, String from, String to) {
        LocalDateTime fromDate = LocalDateTime.parse(from);
        LocalDateTime toDate = LocalDateTime.parse(to);
        return transactionRepository
                .findByCustomerIdAndDateBetween(customerId, fromDate, toDate);
    }

}

