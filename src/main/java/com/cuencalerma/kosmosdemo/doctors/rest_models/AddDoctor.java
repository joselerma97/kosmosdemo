package com.cuencalerma.kosmosdemo.doctors.rest_models;

import com.cuencalerma.kosmosdemo.doctors.bd.Specialization;
import lombok.Getter;

@Getter
public class AddDoctor {
    String name;
    String fatherSurname;
    String motherSurname;
    Specialization specialization;

    AddDoctor(String name, String fatherSurname, String motherSurname, Specialization specialization){
        this.name = name;
        this.fatherSurname = fatherSurname;
        this.motherSurname = motherSurname;
        this.specialization = specialization;
    }
}
