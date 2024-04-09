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

public class CreateProvidersRequest {

	private Long id;
	private String name;
	private Long nit;
	private String invima;
	private String openDate;
	private String closeDate;
	private String ownerId;
	private List<CreateAppointmentRequest> appointment;
	private List<CreateAddresRequest> addres;
	private CreateUsersRequest users;
	private List<CreateEmployeeRequest> employee ;
}

