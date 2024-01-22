package com.cuencalerma.kosmosdemo.appointments.errros;

public class AppointmentException extends Exception {

    public AppointmentException(String message) {
        super(message);
    }

    public AppointmentException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppointmentException(Throwable cause) {
        super(cause);
    }

}
