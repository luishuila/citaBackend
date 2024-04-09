package com.barberia.citaShow.mapper;

import com.barberia.citaShow.dto.RoleDto;
import com.barberia.citaShow.dto.ServiceDto;
import com.barberia.citaShow.entity.ServiceEntity;
import com.barberia.citaShow.request.CreateServiceRequest;
import com.barberia.citaShow.response.ProvidersResponse;
import com.barberia.citaShow.response.ServiceResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { ProvidersMapper.class })
public interface ServicesMapper {
    ServiceDto toServiceDto(ServiceEntity serviceEntity);

    ServiceResponse toServiceResponse(ServiceDto ServiceDto);

    ServiceEntity toServiceEntityRequest(CreateServiceRequest createServiceRequest);
}
