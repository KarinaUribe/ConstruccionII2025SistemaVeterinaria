
package app.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class Invoice {
    private long id;
    private Pet pet;           
    private Person owner;
    private Order order;
    private List<String> items;
    private double amount;
    private LocalDate date;


    public Invoice(long id, Pet pet, Person owner, Order order, List<String> items, double amount, LocalDate date) {
        this.id = id;
        this.pet = pet;
        this.owner = owner;
        this.order = order;
        this.items = items;
        this.amount = amount;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", pet=" + pet.getName() +
                ", owner=" + owner.getName() +
                ", order=" + (order != null ? order.getOrderId() : "No order") +
                ", items=" + items +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}

