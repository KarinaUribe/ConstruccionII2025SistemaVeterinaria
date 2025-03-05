
package app.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
ToString
public class Order {
    private long id;
    private Pet pet; 
    private User veterinarian;
    private Person owner;
    private String dose;
    private String medicine;
    private LocalDate date;

    public Order(long id, Pet pet, User veterinarian, Person owner, String dose, String medicine, LocalDate date) {
        this.id = id;
        this.pet = pet;
        this.veterinarian = veterinarian;
        this.owner = owner;
        this.dose = dose;
        this.medicine = medicine;
        this.date = date;
    }

}

