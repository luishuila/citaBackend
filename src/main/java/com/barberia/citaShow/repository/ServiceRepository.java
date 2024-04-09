package com.barberia.citaShow.repository;

import com.barberia.citaShow.entity.ServiceEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface ServiceRepository extends ListCrudRepository<ServiceEntity, Long> {
}
