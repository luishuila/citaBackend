package com.barberia.citaShow.services;


import com.barberia.citaShow.entity.UsersEntity;
import com.barberia.citaShow.request.CreateUsersRequest;
import com.barberia.citaShow.response.UsersResponse;

public interface UserServices {

    UsersResponse save(CreateUsersRequest request);
    UsersResponse getById( Long id);
}
