/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.domain.models.Person;
import app.ports.PersonPort;

@Service
public class PersonService {
    @Autowired
    private PersonPort personPort;

    public boolean isPersonRegistered(long document) {
        return personPort.existPerson(document);
    }

    public void registerPerson(Person person) {
        if (isPersonRegistered(person.getDocument())) {
            throw new IllegalArgumentException("La persona con documento " + person.getDocument() + " ya esta registrada.");
        }
        personPort.savePerson(person);
    }

    public Person getPersonByDocument(long document) {
    return personPort.findByDocument(document)
            .orElseThrow(() -> new IllegalArgumentException("No se encontro una persona con el documento " + document));
    }
}