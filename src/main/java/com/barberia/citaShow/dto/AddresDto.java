package com.barberia.citaShow.dto;

import org.apache.catalina.authenticator.jaspic.PersistentProviderRegistrations.Providers;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * Code generated by The Carpenter from softcaribbean
 * Date:<CURRENT_DATE>
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@RequiredArgsConstructor

public class AddresDto {
	private Long id;
	private String latitude;
	private String length;
	private String street;
	private String race;
	private String neighborhood;
	private String address;
	private String description;
	private ProvidersDto providers;

}
