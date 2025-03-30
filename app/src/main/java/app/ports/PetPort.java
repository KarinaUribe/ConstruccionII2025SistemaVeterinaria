/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package app.ports;

import app.domain.models.Pet;
import java.util.List;
import java.util.Optional;

public interface PetPort {
    Pet save(Pet pet);
    List<Pet> findAll();
    Optional<Pet> findById(long petId);
}
