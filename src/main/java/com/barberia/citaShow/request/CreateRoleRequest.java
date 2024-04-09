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
public class CreateRoleRequest {


	private Long id;
	private String name;
	private String description;
	private boolean state;

}

