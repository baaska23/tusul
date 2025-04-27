package com.example.mdbspringboot.repository;

import com.example.mdbspringboot.model.TreatmentEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface TreatmentRepository extends MongoRepository<TreatmentEntry, String> {
    List<TreatmentEntry> findByDate(LocalDate date);
    List<TreatmentEntry> findByDateBetween(LocalDate start, LocalDate end);
}
