package com.cuencalerma.kosmosdemo.appointments.bd;

import com.cuencalerma.kosmosdemo.doctors.bd.Doctor;
import com.cuencalerma.kosmosdemo.doctors.bd.DoctorOffice;
import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
public class Appointment {
    @Id
    String appointmentId;

    @OneToOne
    DoctorOffice doctorOffice;

    @OneToOne
    Doctor doctor;

    LocalDateTime schedule;

    String patient;

    public Appointment(){}
    public Appointment(DoctorOffice doctorOffice, Doctor doctor, LocalDateTime schedule, String patient){
        this.appointmentId = UUID.randomUUID().toString();
        this.doctorOffice = doctorOffice;
        this.doctor = doctor;
        this.schedule = schedule;
        this.patient = patient;
    }

}
