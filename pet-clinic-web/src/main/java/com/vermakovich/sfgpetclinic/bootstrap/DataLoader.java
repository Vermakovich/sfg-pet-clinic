package com.vermakovich.sfgpetclinic.bootstrap;

import com.vermakovich.sfgpetclinic.model.*;
import com.vermakovich.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Owner matt = new Owner();
        matt.setFirstName("Matt");
        matt.setLastName("Rives");
        Pet matsDog = new Pet();
        matsDog.setName("Rex");
        matsDog.setBirthDate(LocalDate.now());
        matsDog.setPetType(savedDogPetType);
        matsDog.setOwner(matt);
        matt.getPets().add(matsDog);

        ownerService.save(matt);

        Owner rob = new Owner();
        rob.setFirstName("Rob");
        rob.setLastName("Pattins");
        Pet robsCat = new Pet();
        robsCat.setName("Cat");
        robsCat.setPetType(savedCatPetType);
        robsCat.setBirthDate(LocalDate.now());
        robsCat.setOwner(rob);
        rob.getPets().add(robsCat);
        ownerService.save(rob);

        Visit visit = new Visit();
        visit.setDate(LocalDate.now());
        visit.setDescription("Cat disease");
        visit.setPet(robsCat);
        visitService.save(visit);
        
        System.out.println("Owners loaded....");

        Vet colin = new Vet();
        colin.setFirstName("Colin");
        colin.setLastName("Farrel");
        colin.getSpecialties().add(savedRadiology);
        vetService.save(colin);

        Vet tom = new Vet();
        tom.setFirstName("Tom");
        tom.setLastName("Hanks");
        tom.getSpecialties().add(savedSurgery);
        vetService.save(tom);

        System.out.println("Vets loaded....");
    }
}
