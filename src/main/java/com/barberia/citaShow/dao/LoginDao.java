package com.barberia.citaShow.dao;

import com.barberia.citaShow.entity.UsersEntity;
import com.barberia.citaShow.request.LoginRequest;

public interface LoginDao {
    UsersEntity login(String request);
}
