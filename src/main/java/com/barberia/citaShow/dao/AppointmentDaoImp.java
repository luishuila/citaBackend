package com.barberia.citaShow.dao;

import com.barberia.citaShow.dto.AppointmentDto;
import com.barberia.citaShow.dto.EmployeeDto;
import com.barberia.citaShow.entity.AppointmentEntity;
import com.barberia.citaShow.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AppointmentDaoImp implements  AppointmentDao{
   private String sqlQuery = "Select e.id as idEmployee, MAX(aps.turn) as turn , MAX(aps.appointment_date) as appointmentDate " +
            "             from  employee as e inner join  employee_providers epv on e.id = epv.id_employee " +
            "             inner join providers provid on epv.id_providers = provid.id " +
            "             left join  appointment aps on aps.id_employee = e.id " +
            "             where   aps.deleted_at  IS NULL and e.available = 1 and  provid.id = ? " +
           "              and ( ? IS NULL OR e.id = ?)  " +
            "             GROUP BY  e.id ";
    JdbcTemplate jdbcTemplate;

    public AppointmentDaoImp(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Autowired
    private AppointmentRepository appointmentRepository;


    @Override
    public AppointmentEntity save(AppointmentEntity appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Integer  exists(AppointmentEntity appointment) {
        return appointmentRepository.findByExist(appointment.getUsers().getId(),appointment.getProviders().getId());
    }

    @Override
    public List<AppointmentDto> consultationAvailable(AppointmentEntity appointment){


        List<Object[]> data = appointmentRepository.consultationAvailable(appointment.getProviders().getId(),appointment.getEmployee().getId());

        List<AppointmentDto> appointmentDto = new ArrayList<>();


        for (Object[] elemet : data){
            AppointmentDto resul = new AppointmentDto();
            EmployeeDto resulEm = new EmployeeDto();
            resulEm.setId((Long) elemet[0]);
            resul.setTurn((Long) Long.valueOf((int) elemet[1]));
            resul.setAppointmentDate((Timestamp) elemet[2]);
            resul.setEmployee(resulEm);
            appointmentDto.add(resul);
        }

       // List<AppointmentDto> appointmentDto =   jdbcTemplate.query(sqlQuery,new AppointmentMapper(),appointment.getProviders().getId(),appointment.getEmployee().getId(),appointment.getEmployee().getId());

        return appointmentDto;
    }


    @Override
    public Optional<AppointmentEntity> findById(Long id) {
        return appointmentRepository.findById(id);
    }
}
