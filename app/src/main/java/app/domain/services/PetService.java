package app.domain.services;

import app.domain.models.Pet;
import app.ports.PetPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    @Autowired
    private PetPort petPort;

    public Pet registerPet(Pet pet) {
        return petPort.save(pet);
    }

    public List<Pet> getAllPets() {
        return petPort.findAll();
    }
}
