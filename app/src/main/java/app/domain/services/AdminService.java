package app.domain.service;

import app.domain.models.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.domain.services.InvoiceService;
import app.domain.services.MedicalOrderService;
import app.domain.services.MedicalRecordService;
import app.domain.services.PersonService;
import app.domain.services.PetService;
import app.domain.services.UserService;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Service
public class AdminService {
    
    @Autowired
    private UserService userService;
    @Autowired
    private PersonService personService;
    @Autowired
    private PetService petService;
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private MedicalOrderService medicalOrderService;
    @Autowired
    private MedicalRecordService medicalRecordService;
    
    public void registerUser(Person person, String role) throws Exception {
        if (personService.existPerson(person.getDocument())) {
            throw new Exception("Ya existe una persona con esa cedula");
        }
        if (userService.existUserName(person.getUserName())) {
            throw new Exception("Ya existe ese username registrado");
        }
        person.setRole(role);
        personService.savePerson(person);
        userService.saveUser(person);
    }
    
    public List<Invoice> getInvoices(Person person) throws Exception {
        if (person == null) {
            return invoiceService.getAllInvoices();
        }
        person = personService.findByDocument(person.getDocument());
        if (person == null) {
            throw new Exception("No existe una persona con esa cedula");
        }
        return invoiceService.getInvoicesByPerson(person);
    }
    public void registerPet(Pet pet) throws Exception {
    petService.savePet(pet);
    }
    
    public boolean existPerson(long document) {
        return personPort.existsByDocument(document);
    }

    
    public void createMedicalOrder(MedicalOrder order) throws Exception {
        if (!medicalOrderService.validateOrder(order)) {
            throw new Exception("Orden medica invalida");
        }
        medicalOrderService.saveOrder(order);
    }
    
    public void updateMedicalRecord(MedicalRecord record) throws Exception {
        if (!medicalRecordService.exists(record.getPetId())) {
            throw new Exception("No existe una historia clinica para esta mascota");
        }
        medicalRecordService.updateRecord(record);
    }
}
