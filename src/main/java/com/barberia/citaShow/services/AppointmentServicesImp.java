package com.barberia.citaShow.services;

import com.barberia.citaShow.dao.AppointmentDao;
import com.barberia.citaShow.dto.AppointmentDto;
import com.barberia.citaShow.dto.EmployeeDto;
import com.barberia.citaShow.entity.AppointmentEntity;
import com.barberia.citaShow.entity.EmployeeEntity;
import com.barberia.citaShow.mapper.AppointmentMapper;
import com.barberia.citaShow.request.CreateAppointmentRequest;
import com.barberia.citaShow.response.AppointmentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServicesImp implements  AppointmentServices{

    @Autowired
    private AppointmentDao appointmentDao;

    @Autowired(required=true)
    private AppointmentMapper appointmentMapper;

    @Override
    public AppointmentResponse save(CreateAppointmentRequest request) {

        int minuto = 60;

        AppointmentEntity appointmentEntity  = appointmentMapper.toAppointmentEntityRequest(request);

        Integer  appointmentDto = appointmentDao.exists(appointmentEntity);
        if (appointmentDto == 1){
            System.out.println("Ya se encuentra este registro");
        }

        List<AppointmentDto> appointmentDaoList =   appointmentDao.consultationAvailable(appointmentEntity);
        Collections.sort(appointmentDaoList, new Comparator<AppointmentDto>(){
            @Override
            public int compare(AppointmentDto o1, AppointmentDto o2) {
                return o1.getTurn().compareTo(o2.getTurn());
            }
        });
        EmployeeEntity employeeDto = new EmployeeEntity();

        AppointmentDto appointmentDtoMin = appointmentDaoList.stream().reduce((p1, p2) -> p1.getTurn() < p2.getTurn() ? p1 : p2).get();

            if (appointmentDtoMin.getTurn() == 0 || appointmentDtoMin.getTurn() == null){
                employeeDto.setId(appointmentDtoMin.getEmployee().getId());
                appointmentEntity.setEmployee(employeeDto);
                appointmentEntity.setTurn(1);
                appointmentEntity.setAppointmentDate(currentDateMinutes(minuto));
            }

         if (appointmentDtoMin.getTurn() > 0 ){
                employeeDto.setId(appointmentDtoMin.getEmployee().getId());
                appointmentEntity.setEmployee(employeeDto);
                appointmentEntity.setTurn((int) (appointmentDtoMin.getTurn()+1));
                Timestamp timestamp = currentDateMinutesAgre(minuto,appointmentDtoMin.getAppointmentDate().toString());
                appointmentEntity.setAppointmentDate(timestamp);
            }
        AppointmentEntity result =  appointmentDao.save(appointmentEntity);

       Optional<AppointmentEntity> optionalData = appointmentDao.findById(result.getId());

        System.out.println(optionalData.get().getUsers().getEmail());

        return appointmentMapper.toAppointmentResponse(appointmentMapper.toAppointmentDto(optionalData.get()));
    }

    private Timestamp currentDateMinutes(int minutes){
        long currentTimeMillis = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(currentTimeMillis);
        Instant instant = timestamp.toInstant();
        Instant instantModificado = instant.plusSeconds(minutes * 60);
        Timestamp timestampModificado = Timestamp.from(instantModificado);
        return  timestampModificado;
    }

    private Timestamp currentDateMinutesAgre(int minutes,String timestamps){
        Timestamp timestamp = Timestamp.valueOf(timestamps);
        Instant instant = timestamp.toInstant();
        Instant instantModificado = instant.plusSeconds(minutes * 60);

        Timestamp timestampModificado = Timestamp.from(instantModificado);

        return  timestampModificado;
    }
}
