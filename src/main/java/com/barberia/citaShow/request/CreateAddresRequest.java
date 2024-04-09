package com.barberia.citaShow.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
*Code generated by The Carpenter from softcaribbean
*/
@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@RequiredArgsConstructor
public class CreateAddresRequest{
		private Long id;
		private String latitude;
		private String length ;
		private String street;
		private String race;
		private String neighborhood;
		private String address;
		private String description;
		private CreateProvidersRequest providers;

}

