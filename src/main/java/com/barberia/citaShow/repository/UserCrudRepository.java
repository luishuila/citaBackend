package com.barberia.citaShow.repository;


import com.barberia.citaShow.entity.UsersEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface UserCrudRepository extends ListCrudRepository<UsersEntity, Long> {

    UsersEntity findByEmail(String email);
}
