package com.barberia.citaShow.dto;

import com.barberia.citaShow.entity.AppointmentEntity;
import com.barberia.citaShow.request.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

import org.apache.catalina.authenticator.jaspic.PersistentProviderRegistrations.Providers;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@RequiredArgsConstructor

public class EmployeeDto {

    private Long id;
    private Long numberIdentification;
    private String typeIdentification;
    private Boolean available;
    private Boolean checkpoint;
    private List<ProvidersDto> providers;
    private UsersDto users;
    private List<AppointmentDto> appointment;
}
