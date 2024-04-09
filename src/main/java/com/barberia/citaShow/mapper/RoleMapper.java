package com.barberia.citaShow.mapper;

import com.barberia.citaShow.dto.RoleDto;
import com.barberia.citaShow.entity.RoleEntity;

import com.barberia.citaShow.request.CreateRoleRequest;
import com.barberia.citaShow.response.ProvidersResponse;
import org.mapstruct.Mapper;

import javax.management.relation.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleDto toRolesDto(RoleEntity RoleEntity);


    ProvidersResponse toRolesResponse(RoleDto RoleDto);
    RoleEntity toRoleEntityRequest(CreateRoleRequest createRoleRequest);
}
