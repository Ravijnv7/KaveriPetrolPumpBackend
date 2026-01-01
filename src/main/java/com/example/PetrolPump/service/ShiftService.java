package com.example.PetrolPump.service;

import com.example.PetrolPump.DTO.StartShiftRequest;
import com.example.PetrolPump.entity.Shift;

import java.math.BigDecimal;

public interface ShiftService {
    Shift startShift(StartShiftRequest request);
    Shift closeShift(Long ShiftId, BigDecimal closingReading);

}
