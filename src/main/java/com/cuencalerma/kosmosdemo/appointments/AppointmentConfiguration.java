package com.cuencalerma.kosmosdemo.appointments;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppointmentConfiguration {

    @Bean
    AppointmentService appointmentService(){
        return new AppointmentService();
    }

}
