package com.cuencalerma.kosmosdemo.appointments;

import com.cuencalerma.kosmosdemo.appointments.bd.Appointment;
import com.cuencalerma.kosmosdemo.appointments.bd.repositories.AppointmentRepository;
import com.cuencalerma.kosmosdemo.appointments.errros.AppointmentException;
import com.cuencalerma.kosmosdemo.appointments.rest_models.AddAppointment;
import com.cuencalerma.kosmosdemo.doctors.bd.Doctor;
import com.cuencalerma.kosmosdemo.doctors.bd.DoctorOffice;
import com.cuencalerma.kosmosdemo.doctors.bd.repositories.DoctorOfficeRepository;
import com.cuencalerma.kosmosdemo.doctors.bd.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

public class AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    DoctorOfficeRepository doctorOfficeRepository;

    @Autowired
    DoctorRepository doctorRepository;

    List<Appointment> getAppointments(){
        return StreamSupport.stream(appointmentRepository.findAll().spliterator(), false)
                .toList();
    }

    Appointment addAppointment(AddAppointment info) throws AppointmentException {
        Optional<DoctorOffice> doctorOffice = doctorOfficeRepository.findById(info.getDoctorOfficeId());
        Optional<Doctor> doctor = doctorRepository.findById(info.getDoctorId());

        if(doctorOffice.isEmpty() || doctor.isEmpty()){
            throw new AppointmentException("La Oficina o doctor no existen");
        }

        List<Appointment> appointments = StreamSupport.stream(appointmentRepository.findAll().spliterator(), false)
                .toList();

        if(isSameOfficeHour(appointments, info)){
            throw new AppointmentException("No se puede agendar cita en un mismo consultorio a la misma hora");
        }

        if(isSameDoctor(appointments, info)){
            throw new AppointmentException("No se puede agendar cita para un mismo Dr. a la misma hora.");
        }

        return appointmentRepository.save(
                new Appointment(doctorOffice.get(), doctor.get(), info.getSchedule(), info.getPatient())
        );
    }


    private boolean isSameOfficeHour(List<Appointment> appointments, AddAppointment info){
        return appointments.stream().anyMatch( appointment ->
                appointment.getDoctorOffice().getDoctorOfficeId() == info.getDoctorOfficeId()
        && appointment.getSchedule().getHour() == info.getSchedule().getHour());
    }

    private boolean isSameDoctor(List<Appointment> appointments, AddAppointment info){
        return appointments.stream().anyMatch( appointment ->
                appointment.getDoctor().getDoctorId() == info.getDoctorId());
    }

    private boolean isPatientScheduleOverlap(List<Appointment> appointments, AddAppointment info){
        List<Appointment> patientAppointments = appointments.stream().filter(appointment -> appointment.getPatient() == info.getPatient()).toList();

    }

}
