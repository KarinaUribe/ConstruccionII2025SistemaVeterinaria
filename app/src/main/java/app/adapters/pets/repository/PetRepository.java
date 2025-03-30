/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package app.adapater.pets.repository;

import app.adapater.pets.entity.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author berna
 */
public interface PetRepository extends JpaRepository<PetEntity, Long> {
     boolean existsByDocument(long document);
     PetEntity findByDocument(long document);
    
}

