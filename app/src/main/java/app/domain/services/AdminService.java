package app.domain.service;

import app.manages.AdminManages;
import app.domain.models.*;

import java.util.List;
import java.util.Optional;

public class AdminService {
    private final AdminManages adminManages;

    public AdminService(AdminManages adminManages) {
        this.adminManages = adminManages;
    }

    public void registerUser(long id, String name, String document, int age, String username, String password, String role, User admin) {
        if (!admin.getRole().equalsIgnoreCase("Admin")) {
            System.out.println("Solo las administradores pueden registrar veterinarios y vendedores.");
            return;
        }

        if (findUserById(id).isPresent()) {
            System.out.println("Usuario con ID" + id + " ya existe");
            return;
        }

        Person person = new Person(id, name, document, age);
        User newUser = new User(id, person, username, password, role);
        adminManages.addUser(newUser);
        System.out.println("User registrado: " + username + " (" + role + ")");
    }

    public void registerPet(long id, String name, int age, String breed, String species, double weight, String features, long ownerId) {
        Optional<User> owner = findUserById(ownerId);

        if (owner.isEmpty() || !owner.get().getRole().equalsIgnoreCase("Owner")) {
            System.out.println("El dueño especificado no existe o no es un propietario.");
            return;
        }

        Pet newPet = new Pet(id, owner.get().getPerson(), name, age, breed, species, weight, features);
        adminManages.addPet(newPet);
        System.out.println("Mascota resgistrada: " + name);
    }

    public Optional<User> findUserById(long id) {
        return adminManages.getUsers().stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }

    public Optional<Pet> findPetById(long id) {
        return adminManages.getPets().stream()
                .filter(pet -> pet.getId() == id)
                .findFirst();
    }

    public void showAllUsers() {
        List<User> users = adminManages.getUsers();
        if (users.isEmpty()) {
            System.out.println("Usuario no registrado");
            return;
        }
        System.out.println("Lista de usuarios");
        users.forEach(user -> System.out.println("- " + user.getUsername() + " | Role: " + user.getRole()));
    }

    public void showAllPets() {
        List<Pet> pets = adminManages.getPets();
        if (pets.isEmpty()) {
            System.out.println("Mascota no registrada");
            return;
        }
        System.out.println("Lista de mascotas");
        pets.forEach(pet -> System.out.println("- " + pet.getName() + " | Owner: " + pet.getOwner().getName()));
    }
}