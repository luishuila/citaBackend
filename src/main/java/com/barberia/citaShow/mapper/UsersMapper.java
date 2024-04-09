package com.barberia.citaShow.mapper;

import com.barberia.citaShow.dto.ServiceDto;
import com.barberia.citaShow.dto.UsersDto;
import com.barberia.citaShow.entity.UsersEntity;
import com.barberia.citaShow.request.CreateUsersRequest;
import com.barberia.citaShow.response.ServiceResponse;
import com.barberia.citaShow.response.UsersResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = { RoleMapper.class })
public interface UsersMapper {


    UsersEntity toUserEntity(UsersDto usersDto);
    UsersEntity usersRequestToUsers(CreateUsersRequest request);

    UsersDto toUsersDto(UsersEntity UserEntity);

    UsersResponse toUsersResponse(UsersDto UsersDto);

}
