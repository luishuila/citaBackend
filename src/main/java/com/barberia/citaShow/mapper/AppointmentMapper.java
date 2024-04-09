package com.barberia.citaShow.mapper;

import com.barberia.citaShow.dto.AppointmentDto;
import com.barberia.citaShow.entity.AppointmentEntity;
import com.barberia.citaShow.request.CreateAppointmentRequest;
import com.barberia.citaShow.response.AppointmentResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    AppointmentDto toAppointmentDto(AppointmentEntity appointmentEntity);

    AppointmentResponse toAppointmentResponse(AppointmentDto appointmentDto);
    AppointmentEntity toAppointmentEntityRequest(CreateAppointmentRequest createAppointmentRequest);


}
