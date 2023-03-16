package com.vermakovich.sfgpetclinic.services.map;

import com.vermakovich.sfgpetclinic.model.Owner;
import com.vermakovich.sfgpetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OwnerMapServiceTest {

    OwnerService ownerService;

    final Long ownerId = 1L;
    final String lastName = "Smith";

    @BeforeEach
    void setUp() {
        ownerService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerService.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerService.findAll();
        assertEquals(1, owners.size());
    }

    @Test
    void deleteById() {
        ownerService.deleteById(ownerId);
        assertEquals(0, ownerService.findAll().size());
    }

    @Test
    void delete() {
        ownerService.delete(ownerService.findById(ownerId));
        assertEquals(0, ownerService.findAll().size());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Owner owner = ownerService.save(Owner.builder().id(id).build());
        assertEquals(id, owner.getId());
    }

    @Test
    void saveNoId() {
        Owner owner = ownerService.save(Owner.builder().build());
        assertNotNull(owner);
        assertNotNull(owner.getId());
    }

    @Test
    void findById() {
        Owner owner = ownerService.findById(ownerId);
        assertNotNull(owner);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerService.findByLastName(lastName);
        assertNotNull(owner);
        assertEquals(ownerId, owner.getId());
    }
}