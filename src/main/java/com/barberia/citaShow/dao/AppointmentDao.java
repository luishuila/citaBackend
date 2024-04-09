package com.barberia.citaShow.dao;

import com.barberia.citaShow.dto.AppointmentDto;
import com.barberia.citaShow.entity.AppointmentEntity;

import java.util.List;
import java.util.Optional;

public interface AppointmentDao {
    AppointmentEntity save(AppointmentEntity appointment);

    Integer  exists(AppointmentEntity appointment);

    List<AppointmentDto> consultationAvailable(AppointmentEntity appointment);

    Optional<AppointmentEntity> findById(Long id);
}
