package com.barberia.citaShow.util;

import com.barberia.citaShow.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UtilEntity {
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String encryptPassword(String password) {

        return passwordEncoder.encode(password);
    }
}
