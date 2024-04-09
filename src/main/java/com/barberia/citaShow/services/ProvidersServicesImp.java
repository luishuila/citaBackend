package com.barberia.citaShow.services;

import com.barberia.citaShow.dao.ProvidersDao;
import com.barberia.citaShow.mapper.ProvidersMapper;
import com.barberia.citaShow.request.CreateProvidersRequest;
import com.barberia.citaShow.response.ProvidersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvidersServicesImp implements  ProvidersServices{
    @Autowired
    private ProvidersDao providersDao;

    @Autowired(required=true)
    private ProvidersMapper providersMapper;

    @Override
    public ProvidersResponse save(CreateProvidersRequest request) {


        return providersMapper.toProvidersResponse(providersMapper.toProvidersDto(providersDao.save(providersMapper.toProvidersEntityRequest(request))));
    }
}
