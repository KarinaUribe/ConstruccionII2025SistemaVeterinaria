/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package app.adapters.inputs.utils;

/**
 *
 * @author USUARIO
 */

public class SimpleValidator {

    public String stringValidator(String value, String fieldName) throws Exception {
        if (value == null || value.trim().isEmpty()) {
            throw new Exception(fieldName + " no puede estar vacio.");
        }
        return value.trim();
    }

    public int numberValidator(int value, String fieldName, int min, int max) throws Exception {
        if (value < min || value > max) {
            throw new Exception(fieldName + " debe estar entre " + min + " y " + max + ".");
        }
        return value;
    }

    public String alphabeticValidator(String value, String fieldName) throws Exception {
        String validatedValue = stringValidator(value, fieldName);
        if (!validatedValue.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) {
            throw new Exception(fieldName + " solo puede contener letras y espacios.");
        }
        return validatedValue;
    }

    public String emailValidator(String value) throws Exception {
        String validatedEmail = stringValidator(value, "Correo electrónico");
        if (!validatedEmail.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new Exception("Formato de correo electronico no valido.");
        }
        return validatedEmail;
    }
}
