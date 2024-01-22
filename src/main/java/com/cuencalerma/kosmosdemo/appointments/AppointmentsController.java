package com.cuencalerma.kosmosdemo.appointments;

import com.cuencalerma.kosmosdemo.appointments.bd.Appointment;
import com.cuencalerma.kosmosdemo.appointments.errros.AppointmentException;
import com.cuencalerma.kosmosdemo.appointments.rest_models.AddAppointment;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("AppointmentsController")
@RequestMapping("appointments/")
public class AppointmentsController {

    @Autowired
    AppointmentService appointmentService;

    @GetMapping("")
    ResponseEntity<List<Appointment>> getAppointments(){
        return new ResponseEntity<>(appointmentService.getAppointments(), HttpStatus.OK);
    }


    @Operation(description = "Doctors Id: <br><br> 0fc9bb40-ff61-4c96-b633-22444f83c15b <br> 8c2e9101-24e9-4484-973f-7dd6f2f20fdb <br> ec5287a6-1e4a-4c6c-b577-e54a2bc584da" +
            "<br><br> Office Id: <br><br>962ab7fc-10d0-4ed9-ae86-e7ddfa7164f9<br>9b570f09-8f19-4b60-b9e9-1dba62f4b09d<br>a0742a48-055a-43d8-88e4-c6fb3c9b3127<br>b4676330-72e7-402f-ab7a-d18136ff03e9")
    @PutMapping("")
    ResponseEntity<Appointment> addAppointment(@RequestBody AddAppointment info){
        try{
            return new ResponseEntity<>(appointmentService.addAppointment(info),
                    HttpStatus.OK);
        }catch(AppointmentException ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
