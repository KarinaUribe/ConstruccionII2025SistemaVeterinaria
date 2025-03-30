/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package app.adapters.inputs.utils;

/**
 *
 * @author USUARIO
 */

import org.springframework.stereotype.Component;
import app.domain.models.MedicalRecord;

@Component
public class MedicalRecordValidator extends SimpleValidator {

    public String diagnosisValidator(String value) throws Exception {
        return stringValidator(value, "Diagnóstico");
    }

    public String treatmentValidator(String value) throws Exception {
        return stringValidator(value, "Tratamiento");
    }
}

