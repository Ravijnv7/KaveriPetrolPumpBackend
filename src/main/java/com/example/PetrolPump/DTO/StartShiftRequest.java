package com.example.PetrolPump.DTO;

import com.example.PetrolPump.entity.ShiftType;
import java.math.BigDecimal;

public class StartShiftRequest {

    private ShiftType shiftType;
    private BigDecimal openingReading;

    public ShiftType getShiftType() {
        return shiftType;
    }

    public void setShiftType(ShiftType shiftType) {
        this.shiftType = shiftType;
    }

    public BigDecimal getOpeningReading() {
        return openingReading;
    }

    public void setOpeningReading(BigDecimal openingReading) {
        this.openingReading = openingReading;
    }
}
