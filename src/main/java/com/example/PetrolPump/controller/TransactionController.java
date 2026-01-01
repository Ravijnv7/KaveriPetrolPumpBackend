package com.example.PetrolPump.controller;


import com.example.PetrolPump.DTO.TransactionRequest;
import com.example.PetrolPump.entity.Transaction;
import com.example.PetrolPump.service.TransactionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public Transaction createTransaction(@RequestBody TransactionRequest request) {
        return transactionService.createTransaction(request);
    }
}
