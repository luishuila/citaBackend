package com.barberia.citaShow.services;

import com.barberia.citaShow.dao.EmployeeDao;
import com.barberia.citaShow.dao.ProvidersDao;
import com.barberia.citaShow.mapper.EmployeeMapper;
import com.barberia.citaShow.mapper.ProvidersMapper;
import com.barberia.citaShow.request.CreateEmployeeRequest;
import com.barberia.citaShow.response.EmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeesServicesImp  implements  EmployeesServices{


    @Autowired
    private EmployeeDao employeeDao;

    @Autowired(required=true)
    private EmployeeMapper employeeMapper;

    @Override
    public EmployeeResponse save(CreateEmployeeRequest request) {
        return employeeMapper.toEmployeeResponse(employeeMapper.toEmployeeDto(employeeDao.save(employeeMapper.toEmployeeEntityRequest(request))));
    }
}
