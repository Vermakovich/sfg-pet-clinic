package com.vermakovich.sfgpetclinic.bootstrap;

import com.vermakovich.sfgpetclinic.model.Owner;
import com.vermakovich.sfgpetclinic.model.Vet;
import com.vermakovich.sfgpetclinic.services.map.OwnerServiceMap;
import com.vermakovich.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerServiceMap ownerServiceMap;
    private final VetServiceMap vetServiceMap;

    public DataLoader(OwnerServiceMap ownerServiceMap, VetServiceMap vetServiceMap) {
        this.ownerServiceMap = ownerServiceMap;
        this.vetServiceMap = vetServiceMap;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Mat");
        owner1.setLastName("Rives");
        ownerServiceMap.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Rob");
        owner2.setLastName("Pattins");
        ownerServiceMap.save(owner2);

        System.out.println("Owners loaded....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Colin");
        vet1.setLastName("Farrel");
        vetServiceMap.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Tom");
        vet2.setLastName("Hanks");
        vetServiceMap.save(vet2);

        System.out.println("Vets loaded....");
    }
}
