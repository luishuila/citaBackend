package com.barberia.citaShow.controller;

import com.barberia.citaShow.request.CreateEmployeeRequest;
import com.barberia.citaShow.response.EmployeeResponse;
import com.barberia.citaShow.services.EmployeesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class EmployeesController {

    @Autowired
    private EmployeesServices employeesServices;

    @PostMapping()

    public EmployeeResponse save(@RequestBody CreateEmployeeRequest request) {

        return new ResponseEntity<>(employeesServices.save(request), HttpStatus.CREATED).getBody();
    }


}
