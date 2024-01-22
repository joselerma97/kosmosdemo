package com.cuencalerma.kosmosdemo.doctors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DoctorConfiguration {

    @Bean
    DoctorService doctorService(){
        return new DoctorService();
    }

}
