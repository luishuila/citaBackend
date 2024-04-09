package com.barberia.citaShow.controller;

import com.barberia.citaShow.request.CreateAppointmentRequest;
import com.barberia.citaShow.request.CreateEmployeeRequest;
import com.barberia.citaShow.response.AppointmentResponse;
import com.barberia.citaShow.services.AppointmentServices;
import com.barberia.citaShow.services.EmployeesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentServices appointmentServices;

    @PostMapping()

    public AppointmentResponse save(@RequestBody CreateAppointmentRequest request) {

        return new ResponseEntity<>(appointmentServices.save(request), HttpStatus.CREATED).getBody();
    }
}
