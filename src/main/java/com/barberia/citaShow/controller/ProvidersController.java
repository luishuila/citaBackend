package com.barberia.citaShow.controller;

import com.barberia.citaShow.request.CreateProvidersRequest;
import com.barberia.citaShow.request.CreateUsersRequest;
import com.barberia.citaShow.response.ProvidersResponse;
import com.barberia.citaShow.services.ProvidersServices;
import com.barberia.citaShow.services.UserServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/providers")
public class ProvidersController {

    @Autowired
    private ProvidersServices providersServices;

    @PostMapping()

    public ProvidersResponse save(@RequestBody CreateProvidersRequest request) {

        return new ResponseEntity<>(providersServices.save(request), HttpStatus.CREATED).getBody();
    }
}
