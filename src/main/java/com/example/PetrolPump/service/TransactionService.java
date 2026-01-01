package com.example.PetrolPump.service;

import com.example.PetrolPump.DTO.TransactionRequest;
import com.example.PetrolPump.entity.Transaction;

public interface TransactionService {
    Transaction createTransaction(TransactionRequest request);
}
