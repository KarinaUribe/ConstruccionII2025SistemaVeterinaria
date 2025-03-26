
package app.adapters.persons.entity;

/**
 *
 * @author USUARIO
 */
import app.domain.models.Person;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "person")
public class PersonEntity {
	@Id
	@Column(name = "id")
	private long personId;
	@Column(name = "document")
	private long document;
	@Column(name = "name")
	private String name;
	@Column(name = "age")
	private int age;
	public long getPersonId() {
		return personId;
	}
	public void setPersonId(long personId) {
		this.personId = personId;
	}
	public long getDocument() {
		return document;
	}
	public void setDocument(long document) {
		this.document = document;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
        
}
