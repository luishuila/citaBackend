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

public class CreateServiceRequest {

	private Long id;
	private Long serviceTime;
	private String name;
	private String img;
	private String description;
	private Long price;
	private CreateProvidersRequest providers;
	private CreateTypeOfServiceRequest typeOfService;
}

