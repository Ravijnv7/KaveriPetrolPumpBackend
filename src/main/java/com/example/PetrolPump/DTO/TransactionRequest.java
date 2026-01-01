package com.example.PetrolPump.DTO;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TransactionRequest {
    private Long shiftId;
    private Long employeeId;
    private Long productId;
    private Long paymentModeId;
    private Long customerId; // only for CREDIT
    private BigDecimal liters;
}
