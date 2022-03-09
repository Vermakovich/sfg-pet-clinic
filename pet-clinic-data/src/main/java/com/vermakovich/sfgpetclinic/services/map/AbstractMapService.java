package com.vermakovich.sfgpetclinic.services.map;

import com.vermakovich.sfgpetclinic.model.BaseEntity;

import java.util.*;

public class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    };
    T findById(ID id) {
        return map.get(id);
    };
    T save(T object) {
        if (object != null) {
            if (object.getId() == null) {
                object.setId(nextId());
            }
            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Object cannot be null");
        }
        return object;
    };
    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    };
    void deleteById(ID id) {
        map.remove(id);
    };

    public Long nextId() {
        return !map.isEmpty() ? Collections.max(map.keySet()) + 1 : 1L;
    }
}
