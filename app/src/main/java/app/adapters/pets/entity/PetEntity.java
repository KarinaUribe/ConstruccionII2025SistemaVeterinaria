/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package app.adapters.pets.entity;

import app.adapters.persons.entity.PersonEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pets")
@Getter
@Setter
@NoArgsConstructor
public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private PersonEntity owner;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "breed", nullable = false)
    private String breed;

    @Column(name = "species", nullable = false)
    private String species;

    @Column(name = "weight", nullable = false)
    private double weight;

    @Column(name = "features")
    private String features;

    public PetEntity(Long id, PersonEntity owner, String name, int age, String breed, String species, double weight, String features) {
        this.id = id;
        this.owner = owner;
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.species = species;
        this.weight = weight;
        this.features = features;
    }
}

