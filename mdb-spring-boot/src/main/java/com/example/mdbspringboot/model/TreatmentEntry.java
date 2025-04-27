package com.example.mdbspringboot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Map;

@Document("DailyStructuredTreatment")
public class TreatmentEntry {

    @Id
    private String id;

    private LocalDate date;

    // Nested injection object
    private Injection injection;

    // Direct procedure fields
    private int UHF_machine;
    private int massage_chair;
    private int red_light;
    private int ultrasound;
    private int laser;
    private int biotens;
    private int lymphatic_drainage_massage;
    private int electrophoresis;
    private int micro_cupping;
    private int oxygen;
    private int surgical_bandage;

    // --- Getters & Setters ---

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Injection getInjection() {
        return injection;
    }

    public void setInjection(Injection injection) {
        this.injection = injection;
    }

    public int getUHF_machine() {
        return UHF_machine;
    }

    public void setUHF_machine(int uHF_machine) {
        UHF_machine = uHF_machine;
    }

    public int getMassage_chair() {
        return massage_chair;
    }

    public void setMassage_chair(int massage_chair) {
        this.massage_chair = massage_chair;
    }

    public int getRed_light() {
        return red_light;
    }

    public void setRed_light(int red_light) {
        this.red_light = red_light;
    }

    public int getUltrasound() {
        return ultrasound;
    }

    public void setUltrasound(int ultrasound) {
        this.ultrasound = ultrasound;
    }

    public int getLaser() {
        return laser;
    }

    public void setLaser(int laser) {
        this.laser = laser;
    }

    public int getBiotens() {
        return biotens;
    }

    public void setBiotens(int biotens) {
        this.biotens = biotens;
    }

    public int getLymphatic_drainage_massage() {
        return lymphatic_drainage_massage;
    }

    public void setLymphatic_drainage_massage(int lymphatic_drainage_massage) {
        this.lymphatic_drainage_massage = lymphatic_drainage_massage;
    }

    public int getElectrophoresis() {
        return electrophoresis;
    }

    public void setElectrophoresis(int electrophoresis) {
        this.electrophoresis = electrophoresis;
    }

    public int getMicro_cupping() {
        return micro_cupping;
    }

    public void setMicro_cupping(int micro_cupping) {
        this.micro_cupping = micro_cupping;
    }

    public int getOxygen() {
        return oxygen;
    }

    public void setOxygen(int oxygen) {
        this.oxygen = oxygen;
    }

    public int getSurgical_bandage() {
        return surgical_bandage;
    }

    public void setSurgical_bandage(int surgical_bandage) {
        this.surgical_bandage = surgical_bandage;
    }
}
