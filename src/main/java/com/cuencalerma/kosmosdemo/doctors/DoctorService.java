package com.cuencalerma.kosmosdemo.doctors;

import com.cuencalerma.kosmosdemo.doctors.bd.Doctor;
import com.cuencalerma.kosmosdemo.doctors.bd.DoctorOffice;
import com.cuencalerma.kosmosdemo.doctors.bd.repositories.DoctorOfficeRepository;
import com.cuencalerma.kosmosdemo.doctors.bd.repositories.DoctorRepository;
import com.cuencalerma.kosmosdemo.doctors.rest_models.AddDoctor;
import com.cuencalerma.kosmosdemo.doctors.rest_models.AddDoctorOffice;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.StreamSupport;

public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DoctorOfficeRepository doctorOfficeRepository;

    Doctor addDoctor(AddDoctor info){
        return doctorRepository.save(
            new Doctor(info.getName(), info.getFatherSurname(), info.getMotherSurname(),
                    info.getSpecialization())
        );
    }

    List<Doctor> getDoctors(){
       return StreamSupport.stream(doctorRepository.findAll().spliterator(), false)
               .toList();
    }

    DoctorOffice addDoctorOffice(AddDoctorOffice info){
        return doctorOfficeRepository.save(
                new DoctorOffice(info.getDoctorOfficeNumber(), info.getFloorNumber())
        );
    }

    List<DoctorOffice> getDoctorOffices(){
        return StreamSupport.stream(doctorOfficeRepository.findAll().spliterator(), false)
                .toList();
    }

}
