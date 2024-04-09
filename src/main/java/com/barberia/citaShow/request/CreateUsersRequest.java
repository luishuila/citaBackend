package com.barberia.citaShow.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@RequiredArgsConstructor

public class CreateUsersRequest {

	private Long id;
	private String name;
	private String email;
	private String password;
	private String username;

	private String nickname;
	private String lastname;
	private LocalDate birth;
	private String gender;
	private boolean   typespolitics;
	private boolean   locked;
	private boolean   politics;

	private List<CreateRoleRequest> role;
	private CreateEmployeeRequest employee;
	private List<CreateProvidersRequest> providers;
	private List<CreateAppointmentRequest> appointment;

}
