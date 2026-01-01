package com.example.PetrolPump.service.Impl;

import com.example.PetrolPump.DTO.StartShiftRequest;
import com.example.PetrolPump.entity.Shift;
import com.example.PetrolPump.repository.ShiftRepository;
import com.example.PetrolPump.service.ShiftService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Service
public class ShiftServiceImpl implements ShiftService {
    private final ShiftRepository shiftRepository;
    public ShiftServiceImpl(ShiftRepository shiftRepository) {
        this.shiftRepository = shiftRepository;
    }
    @Override
    public Shift startShift(StartShiftRequest request) {

        // Prevent duplicate active shift
        shiftRepository.findByShiftTypeAndClosingReadingIsNull(request.getShiftType())
                .ifPresent(s -> {
                    throw new RuntimeException("Shift already active");
                });

        Shift shift = new Shift();
        shift.setShiftType(request.getShiftType());
        shift.setOpeningReading(request.getOpeningReading());
        shift.setStartTime(LocalDateTime.now());

        return shiftRepository.save(shift);
    }

    @Override
    public Shift closeShift(Long shiftId, BigDecimal closingReading) {

        Shift shift = shiftRepository.findById(shiftId)
                .orElseThrow(() -> new RuntimeException("Shift not found"));

        if (shift.getClosingReading() != null) {
            throw new RuntimeException("Shift already closed");
        }
        shift.setClosingReading(closingReading);
        shift.setEndTime(LocalDateTime.now());
        return shiftRepository.save(shift);

    }

}
