package com.barberia.citaShow.repository;

import com.barberia.citaShow.entity.RoleEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface RolesCrudRepository extends ListCrudRepository<RoleEntity, Long> {
}
