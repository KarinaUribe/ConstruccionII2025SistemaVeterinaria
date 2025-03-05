package app.interact.manages;

import app.manages.AdminManages;
import app.domain.models.Order;
import app.domain.models.Pet;
import app.domain.models.User;
import app.domain.models.Person;
import java.time.LocalDate;
import java.util.List;

public class OrderInteract {

    private final AdminManages adminManages;

    public OrderController(AdminManages adminManages) {
        this.adminManages = adminManages;
    }

    public void createOrder(long id, Pet pet, User veterinarian, Person owner, String medicine, String dose) {
        Order newOrder = new Order(id, pet, veterinarian, owner, dose, medicine, LocalDate.now());
        adminManages.addOrder(newOrder);
        System.out.println("Orden medica creada:  " + newOrder.getId());
    }

    public List<Order> getAllOrders() {
        return adminManages.getOrders();
    }
}