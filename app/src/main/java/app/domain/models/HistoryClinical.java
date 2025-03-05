package app.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class HistoryClinical {
    private LocalDate date;
    private Pet pet;
    private User veterinarian; 
    private String reason;
    private Order order;
    private String diagnosis;         
    private List<String> medicine;    
    private List<String> dose;        
    private String procedureName;     
    private String procedureDetail;   
    private String status;            
    private List<String> vaccination; 
    private List<String> allergies;  

    public HistoryClinical(LocalDate date, Pet pet, User veterinarian, String reason, Order order, 
                           String diagnosis, List<String> medicine, List<String> dose, String procedureName, 
                           String procedureDetail, String status, List<String> vaccination, List<String> allergies) {
        this.date = date;
        this.pet = pet;
        this.veterinarian = veterinarian;
        this.reason = reason;
        this.order = order;
        this.diagnosis = diagnosis;
        this.medicine = medicine;
        this.dose = dose;
        this.procedureName = procedureName;
        this.procedureDetail = procedureDetail;
        this.status = status;
        this.vaccination = vaccination;
        this.allergies = allergies;
    }
    
    @Override
    public String toString() {
        return "HistoryClinical{" +
                "date=" + date +
                ", pet=" + pet.getName() +  
                ", veterinarian=" + veterinarian.getName() +
                ", reason='" + reason + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", procedure='" + procedureName + " - " + procedureDetail + '\'' +
                ", status='" + status + '\'' +
                ", vaccinations=" + vaccination +
                ", allergies=" + allergies +
                '}';
    }
}

