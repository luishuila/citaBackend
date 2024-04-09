package com.barberia.citaShow.dao;

import com.barberia.citaShow.entity.EmployeeEntity;
import com.barberia.citaShow.repository.EmployeeRepository;
import com.barberia.citaShow.repository.ProvidersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImp implements  EmployeeDao{

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public EmployeeEntity save(EmployeeEntity providers) {
        return employeeRepository.save(providers);
    }
}
