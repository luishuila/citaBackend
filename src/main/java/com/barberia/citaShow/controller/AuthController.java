package com.barberia.citaShow.controller;

import com.barberia.citaShow.request.LoginRequest;
import com.barberia.citaShow.response.UsersResponse;
import com.barberia.citaShow.util.JwtUtil;
import com.barberia.citaShow.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseMessage<String>> login(@RequestBody LoginRequest request) {
        UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(request.getEmail(),
                request.getPassword());

        Authentication authentication = this.authenticationManager.authenticate(login);

        String jwt = this.jwtUtil.create(request.getEmail());
        return ResponseEntity.ok(new ResponseMessage<>(43, null, jwt));

    }
}
