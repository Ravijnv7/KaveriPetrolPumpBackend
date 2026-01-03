package com.example.PetrolPump.service.Impl;

import com.example.PetrolPump.DTO.TransactionRequest;
import com.example.PetrolPump.entity.*;
import com.example.PetrolPump.repository.*;
import com.example.PetrolPump.service.TransactionService;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final ShiftRepository shiftRepository;
    private final EmployeeRepository employeeRepository;
    private final ProductRepository productRepository;
    private final PaymentModeRepository paymentModeRepository;
    private final CustomerRepository customerRepository;

    public TransactionServiceImpl(
            TransactionRepository transactionRepository,
            ShiftRepository shiftRepository,
            EmployeeRepository employeeRepository,
            ProductRepository productRepository,
            PaymentModeRepository paymentModeRepository,
            CustomerRepository customerRepository
    ) {
        this.transactionRepository = transactionRepository;
        this.shiftRepository = shiftRepository;
        this.employeeRepository = employeeRepository;
        this.productRepository = productRepository;
        this.paymentModeRepository = paymentModeRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public Transaction createTransaction(TransactionRequest request) {

        Shift shift = shiftRepository.findById(request.getShiftId())
                .orElseThrow(() -> new RuntimeException("Shift not found"));

        if (shift.getClosingReading() != null) {
            throw new RuntimeException("Shift already closed");
        }

        Employee employee = employeeRepository.findById(request.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        PaymentMode paymentMode = paymentModeRepository.findById(request.getPaymentModeId())
                .orElseThrow(() -> new RuntimeException("Payment mode not found"));

        if (request.getLiters().compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("Liters must be greater than zero");
        }

        Customer customer = null;
        if (paymentMode.getModeName().equalsIgnoreCase("CREDIT")) {
            if (request.getCustomerId() == null) {
                throw new RuntimeException("Customer is required for CREDIT");
            }
            customer = customerRepository.findById(request.getCustomerId())
                    .orElseThrow(() -> new RuntimeException("Customer not found"));
        }

        Transaction transaction = new Transaction();
        transaction.setShift(shift);
        transaction.setEmployee(employee);
        transaction.setProduct(product);
        transaction.setPaymentMode(paymentMode);
        transaction.setCustomer(customer);
        transaction.setLiters(request.getLiters());
        transaction.setRatePerLiter(product.getProductPrice());

        return transactionRepository.save(transaction);
    }
}