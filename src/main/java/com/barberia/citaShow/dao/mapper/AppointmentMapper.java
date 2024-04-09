package com.barberia.citaShow.dao.mapper;

import com.barberia.citaShow.dto.AppointmentDto;

import com.barberia.citaShow.dto.EmployeeDto;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AppointmentMapper implements RowMapper<AppointmentDto> {


    @Override
    public AppointmentDto mapRow(ResultSet rs, int rowNum) throws SQLException {

        AppointmentDto resul = new AppointmentDto();
        EmployeeDto resulEm = new EmployeeDto();
        resulEm.setId(rs.getLong("idEmployee"));
        resul.setAppointmentDate(rs.getTimestamp("appointmentDate"));
        resul.setEmployee(resulEm);
        resul.setTurn(rs.getLong("turn"));

        return resul;
    }
}
