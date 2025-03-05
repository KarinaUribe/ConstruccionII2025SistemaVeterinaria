package app.domain.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pets")
public class Pet implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    private String name;
    private int age;
    private String breed;     
    private String species;   
    private double weight;    
    private String features;

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", owner=" + (owner != null ? owner.getName() : "No Owner") +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", breed='" + breed + '\'' +
                ", species='" + species + '\'' +
                ", weight=" + weight +
                ", features='" + features + '\'' +
                '}';
    }
}


