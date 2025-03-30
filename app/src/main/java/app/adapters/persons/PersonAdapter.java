/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package app.adapters.persons;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import app.adapters.persons.entity.PersonEntity;
import app.adapters.persons.repository.PersonRepository;
import app.domain.models.Person;
import app.ports.PersonPort;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonAdapter implements PersonPort {

    private final PersonRepository personRepository;

    @Override
    public boolean existPerson(long document) {
        return personRepository.existsByDocument(document);
    }

    @Override
    public void save(Person person) {
        PersonEntity personEntity = toEntity(person);
        personRepository.save(personEntity);
        person.setId(personEntity.getId());
    }

    @Override
    public Optional<Person> findByDocument(long document) {
        return personRepository.findByDocument(document)
                .map(this::toModel);
    }

    private Person toModel(PersonEntity personEntity) {
        return new Person(
                personEntity.getId(),
                personEntity.getName(),
                personEntity.getDocument(),
                personEntity.getAge()
        );
    }

    private PersonEntity toEntity(Person person) {
        return new PersonEntity(
                person.getId(),
                person.getName(),
                person.getDocument(),
                person.getAge()
        );
    }
}

