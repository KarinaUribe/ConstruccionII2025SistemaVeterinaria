
package app.domain.models;

import app.model.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

/**
 *
 * @author USUARIO
 */
@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Person person;
    private String username;
    private String password;
    private String role; 
    
    @OneToOne
    @JoinColumn(name = "person_id")

    public User(long id, Person person, String username, String password, String role) {
        this.id = id;
        this.person = person;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", person=" + person.getName() +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

