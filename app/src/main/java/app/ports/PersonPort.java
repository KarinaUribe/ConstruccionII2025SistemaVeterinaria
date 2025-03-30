/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package app.ports;

import app.domain.models.Person;
import java.util.Optional;

public interface PersonPort {
    boolean existsByDocument(long document);
    void save(Person person);
    Optional<Person> findByDocument(long document);
}

