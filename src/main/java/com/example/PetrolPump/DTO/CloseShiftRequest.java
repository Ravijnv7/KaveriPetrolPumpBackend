package com.example.PetrolPump.DTO;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class CloseShiftRequest {
    private BigDecimal closingReading;
    public BigDecimal getClosingReading() {
        return closingReading;
    }
}
