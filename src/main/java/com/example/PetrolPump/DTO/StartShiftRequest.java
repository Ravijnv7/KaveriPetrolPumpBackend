package com.example.PetrolPump.DTO;


import com.example.PetrolPump.entity.ShiftType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class StartShiftRequest {
    private ShiftType shiftType;
    private BigDecimal openingReading;
}
