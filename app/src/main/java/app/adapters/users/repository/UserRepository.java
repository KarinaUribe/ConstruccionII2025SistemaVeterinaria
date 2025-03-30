/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package app.adapters.users.repository;

/**
 *
 * @author USUARIO
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import app.adapters.users.entity.UserEntity;
import app.adapters.persons.entity.PersonEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByUsername(String username);
    UserEntity findByPerson(PersonEntity person);
    UserEntity findByUsername(String username);
}
