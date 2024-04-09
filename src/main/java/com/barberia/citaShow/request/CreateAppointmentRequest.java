package com.barberia.citaShow.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;
import java.time.LocalDate;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@RequiredArgsConstructor
public class CreateAppointmentRequest{

	private Long id;
	private Timestamp appointmentDate;
	private Boolean postpones;
	private CreateProvidersRequest providers;
	private CreateServiceRequest services;
	private CreateUsersRequest users;
	private CreateEmployeeRequest employee;


}

