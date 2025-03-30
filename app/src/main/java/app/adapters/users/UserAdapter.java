/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package app.adapters.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.adapters.users.entity.UserEntity;
import app.adapters.users.repository.UserRepository;
import app.adapters.persons.entity.PersonEntity;
import app.domain.models.User;
import app.domain.models.Person;
import app.ports.UserPort;

@Service
public class UserAdapter implements UserPort {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean existUserName(String username) {
        return userRepository.existsByUsername(username);
    }
    
    @Override
    public void saveUser(User user) {
    UserEntity userEntity = toEntity(user);
    userRepository.save(userEntity);
    user.setUserId(userEntity.getUserId());
    }

    @Override
    public User findByPersonId(Person person) {
        PersonEntity personEntity = toEntity(person);
        UserEntity userEntity = userRepository.findByPerson(personEntity);
        return toDomain(userEntity);
    }

    @Override
    public User findByUserName(User user) {
        UserEntity userEntity = userRepository.findByUsername(user.getUsername());
        return userEntity != null ? toDomain(userEntity) : null;
    }

    private User toDomain(UserEntity entity) {
        if (entity == null) return null;
        User user = new User();
        user.setUserId(entity.getUserId());
        user.setPerson(toDomain(entity.getPerson()));
        user.setUsername(entity.getUsername());
        user.setPassword(entity.getPassword());
        user.setRole(entity.getRole());
        return user;
    }

    private UserEntity toEntity(User user) {
        if (user == null) return null;
        UserEntity entity = new UserEntity();
        entity.setUserId(user.getUserId());
        entity.setPerson(toEntity(user.getPerson()));
        entity.setUsername(user.getUsername());
        entity.setPassword(user.getPassword());
        entity.setRole(user.getRole());
        return entity;
    }

    private Person toDomain(PersonEntity entity) {
        if (entity == null) return null;
        return new Person(entity.getPersonId(), entity.getDocument(), entity.getName(), entity.getAge());
    }

    private PersonEntity toEntity(Person person) {
        if (person == null) return null;
        return new PersonEntity(person.getPersonId(), person.getDocument(), person.getName(), person.getAge());
    }
}

