package app.domain.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private long id;
    private String name;
    private String document;
    private int age;
}

