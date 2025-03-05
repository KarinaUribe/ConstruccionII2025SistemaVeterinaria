package app.interact.manages;

import app.manages.AdminManages;
import app.domain.models.Pet;
import app.domain.models.Person;
import java.util.List;

public class PetInteract {
    
    Private final AdminManages adminManages;

    public PetController(AdminManages adminManages) {
        this.adminManages = adminManages;
    }
    
    public void registerPet(long id, String name, int age, String breed, String species, double weight, String features, Person owner) {
        Pet newPet = new Pet(id, owner, name, age, breed, species, weight, features);
        adminManages.addPet(newPet);
        System.out.println("Mascota registrada exitosamente: " + name);
    }

    public List<Pet> getAllPets() {
        return adminManages.getPets();
    }

    public void printAllPets() {
        List<Pet> pets = getAllPets();
        if (pets.isEmpty()) {
            System.out.println("No se ha registrado mascota.");
            return;
        }
        System.out.println("Listado de mascotas registradas:");
        for (Pet pet : pets) {
            System.out.println("- " + pet.getName() + " | Owner: " + pet.getOwner().getName());
        }
    }
}