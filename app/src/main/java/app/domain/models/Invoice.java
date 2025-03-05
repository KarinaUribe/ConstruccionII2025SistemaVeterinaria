package app.domain.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "invoices")
public class Invoice implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "pet_id", nullable = false)
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ElementCollection
    private List<String> items;

    private double amount;
    private LocalDate date;

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", pet=" + (pet != null ? pet.getName() : "No Pet") +
                ", owner=" + (owner != null ? owner.getPerson().getName() : "No Owner") +
                ", order=" + (order != null ? order.getOrderId() : "No Order") +
                ", items=" + items +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}


