package com.barberia.citaShow.repository;

import com.barberia.citaShow.dto.AppointmentDto;
import com.barberia.citaShow.entity.AppointmentEntity;
import com.barberia.citaShow.entity.UsersEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AppointmentRepository extends ListCrudRepository<AppointmentEntity, Long> {

    @Query(value = "SELECT CASE WHEN " +
            "(SELECT  (select   COUNT(*) as exite from appointment as aps " +
            "where  DATE_FORMAT(aps.created_at, '%y-%m-%d') =  DATE_FORMAT(CURDATE(), '%y-%m-%d') and " +
            "  aps.id_users = :idUsers and  aps.id_providers = :idProviders and  aps.deleted_at  IS NULL)  as exite  ) >  0 " +
            "  THEN 1 ELSE 0  END AS cout" , nativeQuery = true)
    Integer  findByExist(@Param("idUsers") Long idUsers, @Param("idProviders") Long idProviders);

    @Query(value = "Select e.id as idEmployee, MAX(aps.turn) as turn , MAX(aps.appointment_date) as appointmentDate " +
            "             from  employee as e inner join  employee_providers epv on e.id = epv.id_employee " +
            "             inner join providers provid on epv.id_providers = provid.id " +
            "             left join  appointment aps on aps.id_employee = e.id  " +
            "             where   aps.deleted_at  IS NULL and e.available = 1 and  aps.deleted_at  IS NULL and provid.id = :idProviders  and  ( :idEmployee IS NULL OR e.id = :idEmployee)" +
            "             GROUP BY  e.id " , nativeQuery = true)
   List<Object[]> consultationAvailable(@Param("idProviders") Long idProviders,@Param("idEmployee") Long idEmployee);


}
