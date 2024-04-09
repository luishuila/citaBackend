package com.barberia.citaShow.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@RequiredArgsConstructor
public class CreateEmployeeRequest {

    private Long id;
    private Long numberIdentification;
    private String typeIdentification;
    private Boolean available;
    private Boolean checkpoint;
    private List<CreateProvidersRequest> providers ;
    private CreateUsersRequest users;
    private List<CreateAppointmentRequest> appointment;
}
