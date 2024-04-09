package com.barberia.citaShow.mapper;

import com.barberia.citaShow.dto.EmployeeDto;
import com.barberia.citaShow.dto.ProvidersDto;
import com.barberia.citaShow.entity.ProvidersEntity;
import com.barberia.citaShow.request.CreateProvidersRequest;
import com.barberia.citaShow.request.CreateUsersRequest;
import com.barberia.citaShow.response.EmployeeResponse;
import com.barberia.citaShow.response.ProvidersResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProvidersMapper {
    ProvidersDto toProvidersDto(ProvidersEntity providersEntity);

    ProvidersResponse toProvidersResponse(ProvidersDto providersDto);
    ProvidersEntity toProvidersEntityRequest(CreateProvidersRequest createProvidersRequest);
}
