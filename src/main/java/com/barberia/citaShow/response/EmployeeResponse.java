
package com.barberia.citaShow.response;

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

public class EmployeeResponse {

    private Long id;
    private Long numberIdentification;
    private String typeIdentification;
    private Boolean available;
    private Boolean checkpoint;
    private List<ProvidersResponse> providers;
    private UsersResponse users;
    private List<AppointmentResponse> appointment;
}
