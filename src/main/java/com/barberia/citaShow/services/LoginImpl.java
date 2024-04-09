package com.barberia.citaShow.services;

import com.barberia.citaShow.dao.LoginDao;
import com.barberia.citaShow.dao.UserDaoImpl;
import com.barberia.citaShow.mapper.UsersMapper;
import com.barberia.citaShow.repository.UserCrudRepository;
import com.barberia.citaShow.entity.UsersEntity;
import com.barberia.citaShow.request.LoginRequest;
import com.barberia.citaShow.response.UsersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;

@Service
public class LoginImpl implements UserDetailsService {
    private final UserCrudRepository userCrudRepository;
    private UsersMapper usersMapper;
    @Autowired
    private LoginDao loginDao;
    public LoginImpl(UserCrudRepository userCrudRepository) {
        this.userCrudRepository = userCrudRepository;
    }


    public UsersResponse login(String request) throws UsernameNotFoundException {
        UsersEntity users = loginDao.login(request);
        if (users == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return usersMapper.toUsersResponse(usersMapper.toUsersDto(users));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UsersEntity user = loginDao.login(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Collections.emptyList());
    }
}
