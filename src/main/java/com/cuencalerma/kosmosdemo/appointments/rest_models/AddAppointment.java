package com.cuencalerma.kosmosdemo.appointments.rest_models;


import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class AddAppointment {
    String doctorOfficeId;

    String doctorId;

    LocalDateTime schedule;

    String patient;
}
