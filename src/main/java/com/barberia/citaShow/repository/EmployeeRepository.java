package com.barberia.citaShow.repository;

import com.barberia.citaShow.dto.AppointmentDto;
import com.barberia.citaShow.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository  extends ListCrudRepository<EmployeeEntity, Long> {


    @Query(value = "Select e.id as idEmployee, MAX(aps.turn) as turn , MAX(aps.appointment_date) as appointmentDate " +
            "             from  employee as e inner join  employee_providers epv on e.id = epv.id_employee " +
            "             inner join providers provid on epv.id_providers = provid.id " +
            "             left join  appointment aps on aps.id_employee = e.id  " +
            "             where   aps.deleted_at  IS NULL and e.available = 1 and  provid.id = :idProviders " +
            "             GROUP BY  e.id " , nativeQuery = true)
    List<AppointmentDto> consultationAvailable(@Param("idProviders") Long idProviders);

}
