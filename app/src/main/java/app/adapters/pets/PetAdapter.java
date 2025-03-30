/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package app.adapters.pets;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import app.adapters.pets.entity.PetEntity;
import app.adapters.pets.repository.PetRepository;
import app.domain.models.Pet;
import app.ports.PetPort;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PetAdapter implements PetPort {

    private final PetRepository petRepository;

    @Override
    @Transactional
    public Pet save(Pet pet) {
        PetEntity petEntity = petToEntity(pet);
        petEntity = petRepository.save(petEntity);
        return entityToPet(petEntity);
    }

    @Override
    public List<Pet> findAll() {
        return petRepository.findAll().stream()
                .map(PetAdapter::entityToPet)
                .collect(Collectors.toList());
    }

    private static PetEntity petToEntity(Pet pet) {
        return new PetEntity(
                pet.getId(),
                pet.getName(),
                pet.getAge(),
                pet.getBreed(),
                pet.getSpecies(),
                pet.getWeight(),
                pet.getFeatures()
        );
    }

    private static Pet entityToPet(PetEntity entity) {
        return new Pet(
                entity.getId(),
                entity.getName(),
                entity.getAge(),
                entity.getBreed(),
                entity.getSpecies(),
                entity.getWeight(),
                entity.getFeatures()
        );
    }
}
