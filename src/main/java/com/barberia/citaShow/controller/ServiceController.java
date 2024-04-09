package com.barberia.citaShow.controller;

import com.barberia.citaShow.dto.ServiceDto;
import com.barberia.citaShow.request.CreateProvidersRequest;
import com.barberia.citaShow.request.CreateServiceRequest;
import com.barberia.citaShow.response.ServiceResponse;
import com.barberia.citaShow.services.ServiceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/service")
public class ServiceController {

    @Autowired
    private ServiceServices serviceServices;

    @PostMapping()

    public ServiceResponse save(@RequestBody CreateServiceRequest request) {

        return new ResponseEntity<>(serviceServices.save(request), HttpStatus.CREATED).getBody();
    }
}
