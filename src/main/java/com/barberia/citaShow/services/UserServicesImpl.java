package com.barberia.citaShow.services;

import com.barberia.citaShow.dao.UserDaoImpl;


import com.barberia.citaShow.mapper.UsersMapper;
import com.barberia.citaShow.request.CreateUsersRequest;
import com.barberia.citaShow.response.UsersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImpl implements  UserServices{
    @Autowired(required=true)
    private UsersMapper mapper;
    @Autowired
    private UserDaoImpl  userDao;

    @Override
    public UsersResponse save(CreateUsersRequest request) {

        return mapper.toUsersResponse(  userDao.save(request));
    }

    @Override
    public UsersResponse getById(Long id) {
        return mapper.toUsersResponse(mapper.toUsersDto( userDao.getById(id)));
    }


}
