package com.barberia.citaShow.mapper;

import com.barberia.citaShow.dto.EmployeeDto;
import com.barberia.citaShow.entity.EmployeeEntity;
import com.barberia.citaShow.request.CreateEmployeeRequest;
import com.barberia.citaShow.response.EmployeeResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeDto toEmployeeDto(EmployeeEntity employeeEntity);

    EmployeeResponse toEmployeeResponse(EmployeeDto employeeDto);
    EmployeeEntity toEmployeeEntityRequest(CreateEmployeeRequest createEmployeeRequest);

}
