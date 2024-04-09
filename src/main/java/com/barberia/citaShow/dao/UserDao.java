package com.barberia.citaShow.dao;



import com.barberia.citaShow.dto.UsersDto;
import com.barberia.citaShow.entity.UsersEntity;
import com.barberia.citaShow.request.CreateUsersRequest;

public interface UserDao {

    UsersDto save(CreateUsersRequest request);

    UsersEntity getById( Long id);
}
