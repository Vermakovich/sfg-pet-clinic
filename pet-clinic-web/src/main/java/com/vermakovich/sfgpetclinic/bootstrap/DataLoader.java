package com.vermakovich.sfgpetclinic.bootstrap;

import com.vermakovich.sfgpetclinic.model.Owner;
import com.vermakovich.sfgpetclinic.model.Pet;
import com.vermakovich.sfgpetclinic.model.PetType;
import com.vermakovich.sfgpetclinic.model.Vet;
import com.vermakovich.sfgpetclinic.services.PetTypeService;
import com.vermakovich.sfgpetclinic.services.map.OwnerServiceMap;
import com.vermakovich.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerServiceMap ownerServiceMap;
    private final VetServiceMap vetServiceMap;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerServiceMap ownerServiceMap, VetServiceMap vetServiceMap, PetTypeService petTypeService) {
        this.ownerServiceMap = ownerServiceMap;
        this.vetServiceMap = vetServiceMap;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner matt = new Owner();
        matt.setFirstName("Matt");
        matt.setLastName("Rives");
        Pet matsDog = new Pet();
        matsDog.setName("Rex");
        matsDog.setBirthDate(LocalDate.now());
        matsDog.setPetType(savedDogPetType);
        matsDog.setOwner(matt);
        matt.getPets().add(matsDog);

        ownerServiceMap.save(matt);

        Owner rob = new Owner();
        rob.setFirstName("Rob");
        rob.setLastName("Pattins");
        Pet robsCat = new Pet();
        robsCat.setName("Cat");
        robsCat.setPetType(savedCatPetType);
        robsCat.setBirthDate(LocalDate.now());
        robsCat.setOwner(rob);
        rob.getPets().add(robsCat);
        ownerServiceMap.save(rob);

        System.out.println("Owners loaded....");

        Vet colin = new Vet();
        colin.setFirstName("Colin");
        colin.setLastName("Farrel");
        vetServiceMap.save(colin);

        Vet tom = new Vet();
        tom.setFirstName("Tom");
        tom.setLastName("Hanks");
        vetServiceMap.save(tom);

        System.out.println("Vets loaded....");
    }
}
