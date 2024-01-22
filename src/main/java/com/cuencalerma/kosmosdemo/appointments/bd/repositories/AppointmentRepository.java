package com.cuencalerma.kosmosdemo.appointments.bd.repositories;

import com.cuencalerma.kosmosdemo.appointments.bd.Appointment;
import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepository extends CrudRepository<Appointment, String> {
}
