package app.domain.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "history_clinical")
public class HistoryClinical implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "pet_id", nullable = false)
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "veterinarian_id", nullable = false)
    private User veterinarian; 

    private String reason;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private String diagnosis;        

    @ElementCollection
    private List<String> medicine;    

    @ElementCollection
    private List<String> dose;        

    private String procedureName;    
    private String procedureDetail;   

    private String status;            

    @ElementCollection
    private List<String> vaccination; 

    @ElementCollection
    private List<String> allergies;  

    @Override
    public String toString() {
        return "HistoryClinical{" +
                "id=" + id +
                ", date=" + date +
                ", pet=" + (pet != null ? pet.getName() : "No Pet") +  
                ", veterinarian=" + (veterinarian != null ? veterinarian.getPerson().getName() : "No Vet") +
                ", reason='" + reason + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", procedure='" + procedureName + " - " + procedureDetail + '\'' +
                ", status='" + status + '\'' +
                ", vaccinations=" + vaccination +
                ", allergies=" + allergies +
                '}';
    }
}

