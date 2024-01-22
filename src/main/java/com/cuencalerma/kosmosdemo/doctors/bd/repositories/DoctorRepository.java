package com.cuencalerma.kosmosdemo.doctors.bd.repositories;

import com.cuencalerma.kosmosdemo.doctors.bd.Doctor;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface DoctorRepository extends CrudRepository<Doctor, String> {
}
