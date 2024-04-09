package com.barberia.citaShow.services;


import com.barberia.citaShow.request.LoginRequest;
import com.barberia.citaShow.response.UsersResponse;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
public interface Login {
     UsersResponse login(String request) throws UsernameNotFoundException;
}
