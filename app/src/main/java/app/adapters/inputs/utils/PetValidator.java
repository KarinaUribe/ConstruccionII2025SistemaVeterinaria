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
import app.domain.models.Pet;

@Component
public class PetValidator extends SimpleValidator {

    public String nameValidator(String value) throws Exception {
        return alphabeticValidator(value, "Nombre de la mascota");
    }

    public int ageValidator(int value) throws Exception {
        return numberValidator(value, "Edad de la mascota", 0, 30);
    }

    public String speciesValidator(String value) throws Exception {
        return alphabeticValidator(value, "Especie de la mascota");
    }
}

