package com.barberia.citaShow.services;

import com.barberia.citaShow.request.CreateAppointmentRequest;
import com.barberia.citaShow.request.CreateEmployeeRequest;
import com.barberia.citaShow.response.AppointmentResponse;

public interface AppointmentServices {
    AppointmentResponse save(CreateAppointmentRequest request);
}
