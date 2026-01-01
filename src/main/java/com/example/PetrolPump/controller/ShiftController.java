package com.example.PetrolPump.controller;

import com.example.PetrolPump.DTO.CloseShiftRequest;
import com.example.PetrolPump.DTO.StartShiftRequest;
import com.example.PetrolPump.entity.Shift;
import com.example.PetrolPump.service.ShiftService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/shifts")
public class ShiftController {
    private final ShiftService shiftService;
    public ShiftController(ShiftService shiftService) {
        this.shiftService = shiftService;
    }
    @PostMapping("/start")
    public Shift startShift(@RequestBody StartShiftRequest request) {
        return shiftService.startShift(request);
    }
    @PostMapping("/{shiftId}/close")
    public Shift closeShift(
            @PathVariable Long shiftId,
            @RequestBody CloseShiftRequest request) {

        return shiftService.closeShift(shiftId, request.getClosingReading());
    }

}
