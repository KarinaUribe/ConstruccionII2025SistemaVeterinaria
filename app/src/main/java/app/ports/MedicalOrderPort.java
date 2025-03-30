/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package app.ports;

/**
 *
 * @author USUARIO
 */

import app.domain.models.MedicalOrder;
import java.util.List;
import java.util.Optional;

public interface MedicalOrderPort {
    void save(MedicalOrder medicalOrder);
    Optional<MedicalOrder> findById(long medicalOrderId);
    List<MedicalOrder> findAll();
}
