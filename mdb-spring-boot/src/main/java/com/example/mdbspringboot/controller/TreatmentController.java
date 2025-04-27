package com.example.mdbspringboot.controller;

import com.example.mdbspringboot.model.TreatmentEntry;
import com.example.mdbspringboot.repository.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/treatments")
public class TreatmentController {

    @Autowired
    private TreatmentRepository treatmentRepository;

    @GetMapping
    public List<TreatmentEntry> getAll() {
        return treatmentRepository.findAll();
    }

    @GetMapping("/date/{date}")
    public List<TreatmentEntry> getByDate(@PathVariable String date) {
        return treatmentRepository.findByDate(LocalDate.parse(date));
    }

    @GetMapping("/summary/monthly")
    public List<TreatmentEntry> getMonthlySummary(
            @RequestParam int year,
            @RequestParam int month
    ) {
        LocalDate start = LocalDate.of(year, month, 1);
        LocalDate end = start.withDayOfMonth(start.lengthOfMonth());
        return treatmentRepository.findByDateBetween(start, end);
    }

    @PostMapping
    public TreatmentEntry create(@RequestBody TreatmentEntry entry) {
        return treatmentRepository.save(entry);
    }
}
