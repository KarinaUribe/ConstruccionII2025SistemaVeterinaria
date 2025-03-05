package app.interact.manages;

import app.manages.AdminManages;
import app.domain.models.ClinicalHistory;
import app.domain.models.Pet;
import app.domain.models.User;
import app.domain.models.Order;
import java.time.LocalDate;
import java.util.List;

public class ClinicalHistoryInteract {

    private final AdminManages adminManages;

    public ClinicalHistoryController(AdminManages adminManages) {
        this.adminManages = adminManages;
    }

    public void registerClinicalHistory(Pet pet, User veterinarian, String reason, Order order, String diagnosis, 
                                        List<String> medicine, List<String> dose, String procedureName, 
                                        String procedureDetail, String status, List<String> vaccination, List<String> allergies) {
        ClinicalHistory newHistory = new ClinicalHistory(LocalDate.now(), pet, veterinarian, reason, order, 
                                                          diagnosis, medicine, dose, procedureName, 
                                                          procedureDetail, status, vaccination, allergies);

        adminManages.addClinicalHistory(newHistory);
        System.out.println("Historia clinica creada para mascota " + pet.getName());
    }

    public List<ClinicalHistory> getAllClinicalHistories() {
        return adminManages.getClinicalHistories();
    }
}