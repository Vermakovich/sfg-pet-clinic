package com.vermakovich.sfgpetclinic.repositories;

import com.vermakovich.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
