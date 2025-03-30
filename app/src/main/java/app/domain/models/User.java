
package app.domain.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends Person {
    private long userId;
    private String password;
    private String role;
}
