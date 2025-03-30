/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package app.ports;

import app.domain.models.User;
import java.util.Optional;

public interface UserPort {
    boolean existsByUsername(String username);
    void save(User user);
    Optional<User> findByPersonId(long personId);
    Optional<User> findByUsername(String username);
}



