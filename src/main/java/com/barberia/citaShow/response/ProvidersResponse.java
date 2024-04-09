
package com.barberia.citaShow.response;

import java.sql.Timestamp;

import java.io.Serializable;
import java.util.List;

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

public class ProvidersResponse {
	private Long id;
	private String name;
	private Long nit;
	private String invima;
	private String openDate;
	private String closeDate;
	private String ownerId;
	private UsersResponse users;
	private List<AppointmentResponse> appointment;
	private List<AddresResponse> addres;

	private List<EmployeeResponse> employee;
}
