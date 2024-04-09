package com.barberia.citaShow.services;

import com.barberia.citaShow.request.CreateEmployeeRequest;
import com.barberia.citaShow.response.EmployeeResponse;

public interface EmployeesServices {
    EmployeeResponse save(CreateEmployeeRequest request);
}
