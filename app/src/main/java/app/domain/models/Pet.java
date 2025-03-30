package app.domain.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    private long petId;
    private String name;
    private int age;
    private String breed;
    private String species;
    private double weight;
    private String features;
    private Person owner;

    public Pet(long petId, String name, int age) {
        this.petId = petId;
        this.name = name;
        this.age = age;
    }
}
