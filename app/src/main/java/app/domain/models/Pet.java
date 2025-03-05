
package app.domain.models;

import app.model.Person;
import app.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

/**
 * 
 * @author USUARIO
 */
@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private long id;
    private Person owner;
    private String name;
    private int age;
    private String breed;     
    private String species;   
    private double weight;    
    private String features;
    
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    public Pet(long id, Person owner, String name, int age, String breed, String species, double weight, String features) {
        this.id = id;
        this.owner = owner;
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.species = species;
        this.weight = weight;
        this.features = features;
    }

    
    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", owner=" + owner.getName() +  
                ", name='" + name + '\'' +
                ", age=" + age +
                ", breed='" + breed + '\'' +
                ", species='" + species + '\'' +
                ", weight=" + weight +
                ", features='" + features + '\'' +
                '}';
    }
}

