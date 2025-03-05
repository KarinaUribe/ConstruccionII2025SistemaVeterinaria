
package app.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@toString
public class Person {
    private long id;
    private String name;
    private String document; 
    private int age;

    public Person(long id, String name, String document, int age) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.age = age;
    }
}

