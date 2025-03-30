package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.domain.models.User;
import app.domain.models.Person;
import app.ports.UserPort;

@Service
public class UserService {
    @Autowired
    private UserPort userPort;

    public boolean isUserNameTaken(String username) {
        return userPort.existUserName(username);
    }

    public void registerUser(User user) {
        if (isUserNameTaken(user.getUsername())) {
            throw new IllegalArgumentException("El nombre de usuario ya esta en uso.");
        }
        userPort.saveUser(user);
    }

    public User getUserByPerson(Person person) {
        return userPort.findByPersonId(person);
    }

    public User getUserByUsername(String username) {
        User user = new User();
        user.setUsername(username);
        return userPort.findByUserName(user);
    }
}
