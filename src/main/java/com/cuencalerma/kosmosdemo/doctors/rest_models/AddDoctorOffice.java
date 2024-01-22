package com.cuencalerma.kosmosdemo.doctors.rest_models;

import lombok.Getter;

import java.math.BigInteger;

@Getter
public class AddDoctorOffice {
    BigInteger doctorOfficeNumber;
    BigInteger floorNumber;

    public AddDoctorOffice(BigInteger doctorOfficeNumber, BigInteger floorNumber){
        this.doctorOfficeNumber = doctorOfficeNumber;
        this.floorNumber = floorNumber;
    }

}
