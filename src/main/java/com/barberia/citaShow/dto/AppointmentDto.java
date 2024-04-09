package com.barberia.citaShow.dto;

import com.barberia.citaShow.request.CreateEmployeeRequest;
import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;
import java.time.LocalDate;

import org.apache.catalina.authenticator.jaspic.PersistentProviderRegistrations.Providers;

/**
 * Code generated by The Carpenter from softcaribbean
 * Date:<CURRENT_DATE>
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@RequiredArgsConstructor

public class AppointmentDto {
	private Long id;
	private Timestamp appointmentDate;
	private Boolean postpones;
	private Long turn;
	private ProvidersDto providers;
	private ServiceDto services;
	private UsersDto users;
	private EmployeeDto employee;
	private boolean exist;

}
