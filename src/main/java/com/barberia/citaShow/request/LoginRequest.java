package com.barberia.citaShow.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@RequiredArgsConstructor
public class LoginRequest {
    private String email;
    private String password;
}
