package com.cuencalerma.kosmosdemo.doctors.bd;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

import java.math.BigInteger;
import java.util.UUID;

@Entity
@Getter
public class Doctor {
    @Id
    String doctorId;
    String name;
    String fatherSurname;
    String motherSurname;
    Specialization specialization;

    public Doctor() {

    }

    public Doctor(String name, String fatherSurname, String motherSurname, Specialization specialization){
        this.doctorId = UUID.randomUUID().toString();
        this.name = name;
        this.fatherSurname = fatherSurname;
        this.motherSurname = motherSurname;
        this.specialization = specialization;
    }

}
