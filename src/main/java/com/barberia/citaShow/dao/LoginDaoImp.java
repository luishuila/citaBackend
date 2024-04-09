package com.barberia.citaShow.dao;

import com.barberia.citaShow.entity.UsersEntity;
import com.barberia.citaShow.repository.UserCrudRepository;
import com.barberia.citaShow.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDaoImp  implements LoginDao{

    @Autowired
    private UserCrudRepository userCrudRepository;
    @Override
    public UsersEntity login(String request) {
        return this.userCrudRepository.findByEmail(request);
    }
}
