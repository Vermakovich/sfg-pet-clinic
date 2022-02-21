package com.vermakovich.sfgpetclinic.services.map;

import com.vermakovich.sfgpetclinic.model.Owner;
import com.vermakovich.sfgpetclinic.services.OwnerService;

import java.util.Map;
import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        Map.Entry<Long, Owner> entry = map.entrySet().stream().filter(e -> e.getValue().getLastName()
                .equals(lastName)).findFirst().orElse(null);
        return entry != null ? entry.getValue() : null;
    }
}
