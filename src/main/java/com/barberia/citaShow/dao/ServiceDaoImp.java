package com.barberia.citaShow.dao;

import com.barberia.citaShow.entity.ServiceEntity;
import com.barberia.citaShow.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ServiceDaoImp implements  ServiceDao{

    @Autowired
    private ServiceRepository serviceRepository;


    @Override
    public ServiceEntity save(ServiceEntity services) {
        return serviceRepository.save(services);
    }
}
