package com.barberia.citaShow.dao;

import com.barberia.citaShow.entity.ProvidersEntity;
import com.barberia.citaShow.repository.ProvidersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProvidersDaoImp implements ProvidersDao{
    @Autowired
    private ProvidersRepository providersRepository;
    @Override
    public ProvidersEntity save(ProvidersEntity providers) {
        return providersRepository.save(providers);
    }
}
