package com.barberia.citaShow.services;

import com.barberia.citaShow.dao.ProvidersDao;
import com.barberia.citaShow.dao.ServiceDao;
import com.barberia.citaShow.dto.ServiceDto;
import com.barberia.citaShow.mapper.ProvidersMapper;
import com.barberia.citaShow.mapper.ServicesMapper;
import com.barberia.citaShow.request.CreateServiceRequest;
import com.barberia.citaShow.response.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceServicesImp implements  ServiceServices{
    @Autowired
    private ServiceDao serviceDao;


    @Autowired()
    private ServicesMapper servicesMapper;

    @Override
    public ServiceResponse save(CreateServiceRequest request) {
        return servicesMapper.toServiceResponse(servicesMapper.toServiceDto(serviceDao.save(servicesMapper.toServiceEntityRequest(request))));
    }
}
