package com.vermakovich.sfgpetclinic.services.map;

import com.vermakovich.sfgpetclinic.model.Pet;
import com.vermakovich.sfgpetclinic.services.PetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public Pet save(Pet object) {
        return save(object);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
