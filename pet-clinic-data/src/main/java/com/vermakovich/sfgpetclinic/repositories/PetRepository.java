package com.vermakovich.sfgpetclinic.repositories;

import com.vermakovich.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
