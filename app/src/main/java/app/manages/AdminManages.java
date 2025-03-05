
package app.manages;

import app.domian.models.Pet;
import app.domain.models.User;
import app.domain.models.ClinicalHistory;
import app.domain.models.Order;
import java.util.Vector;

public class AdminManages {
    private static Vector<Pet> pets = new Vector<>();
    private static Vector<User> users = new Vector<>();
    private static Vector<ClinicalHistory> clinicalHistories = new Vector<>();
    private static Vector<Order> orders = new Vector<>();

    public static void addPet(Pet pet) {
        pets.add(pet);
    }

    public static Vector<Pet> getPets() {
        return pets;
    }

    public static void addUser(User user) {
        users.add(user);
    }

    public static Vector<User> getUsers() {
        return users;
    }

    public static void addClinicalHistory(ClinicalHistory history) {
        clinicalHistories.add(history);
    }

    public static Vector<ClinicalHistory> getClinicalHistories() {
        return clinicalHistories;
    }
    
    public static void addOrder(Order order) {
        orders.add(order);
    }

    public static Vector<Order> getOrders() {
        return orders;
    }
}

