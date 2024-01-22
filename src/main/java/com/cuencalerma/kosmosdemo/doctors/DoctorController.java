package com.cuencalerma.kosmosdemo.doctors;

import com.cuencalerma.kosmosdemo.doctors.bd.Doctor;
import com.cuencalerma.kosmosdemo.doctors.bd.DoctorOffice;
import com.cuencalerma.kosmosdemo.doctors.rest_models.AddDoctor;
import com.cuencalerma.kosmosdemo.doctors.rest_models.AddDoctorOffice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("DoctorController")
@RequestMapping("doctors/")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PutMapping("")
    ResponseEntity<Doctor> addDoctor(@RequestBody AddDoctor info){
        Doctor doctor = doctorService.addDoctor(info);
        return new ResponseEntity<>(doctor, HttpStatus.OK);
    }

    @GetMapping("")
    ResponseEntity<List<Doctor>> getDoctors(){
        return new ResponseEntity<>(doctorService.getDoctors(), HttpStatus.OK);
    }

    @PutMapping("office")
    ResponseEntity<DoctorOffice> addOffice(@RequestBody AddDoctorOffice info){
        DoctorOffice office = doctorService.addDoctorOffice(info);
        return new ResponseEntity<>(office, HttpStatus.OK);
    }

    @GetMapping("/offices")
    ResponseEntity<List<DoctorOffice>> getOffices(){
        System.out.println(doctorService.getDoctorOffices().get(0));
        return new ResponseEntity<>(doctorService.getDoctorOffices(), HttpStatus.OK);
    }


}
