package com.vermakovich.sfgpetclinic.services;

import com.vermakovich.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
