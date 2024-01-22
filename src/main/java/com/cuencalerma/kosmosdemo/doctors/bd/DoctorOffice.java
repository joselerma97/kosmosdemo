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
public class DoctorOffice {
    @Id
    String doctorOfficeId;
    BigInteger doctorOfficeNumber;
    BigInteger floorNumber;

    public DoctorOffice(){

    }

    public DoctorOffice(BigInteger doctorOfficeNumber, BigInteger floorNumber){
        this.doctorOfficeId = UUID.randomUUID().toString();
        this.doctorOfficeNumber = doctorOfficeNumber;
        this.floorNumber = floorNumber;
    }

}
