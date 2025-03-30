/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package app.domain.services;

/**
 *
 * @author USUARIO
 */
import app.domain.models.MedicalRecord;
import app.ports.MedicalRecordPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MedicalRecordService {
    @Autowired
    private MedicalRecordPort medicalRecordPort;

    public void registerMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecordPort.save(medicalRecord);
    }

    public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordPort.findAll();
    }
}
