package app.interact.manages;

import app.manages.AdminManages;
import app.domain.models.User;
import app.domain.models.Person;
import java.util.List;

public class UserInteract {
    private final AdminManages adminManages;

    public UserInteract(AdminManages adminManages) {
        this.adminManages = adminManages;
    }

    public void registerUser(long id, Person person, String username, String password, String role) {
        List<User> users = adminManages.getUsers();
        for (User u : users) {
            if (u.getId() == id) {
                System.out.println("Usuario con ID " + id + " ya existe");
                return;
            }
        }

        User newUser = new User(id, person, username, password, role);
        adminManages.addUser(newUser);
        System.out.println("Usuario registrado: " + username + " (" + role + ")");
    }

    public List<User> getAllUsers() {
        return adminManages.getUsers();
    }

    public void printAllUsers() {
        List<User> users = getAllUsers();
        if (users.isEmpty()) {
            System.out.println("No hay usuarios registrados");
            return;
        }
        System.out.println("Lista de usuarios:");
        for (User user : users) {
            System.out.println("- " + user.getUsername() + " | role: " + user.getRole());
        }
    }
}