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

@Component
public class UserValidator extends SimpleValidator {
    public String nameValidator(String value) throws Exception {
        return stringValidator(value, "Nombre de usuario");
    }

    public String passwordValidator(String value) throws Exception {
        String password = stringValidator(value, "Contraseña");

        if (password.length() < 6) {
            throw new Exception("La contraseña debe tener al menos 6 caracteres.");
        }

        return password;
    }

    public String roleValidator(String value) throws Exception {
        String role = stringValidator(value, "Rol");

        if (!role.equalsIgnoreCase("Admin") && 
            !role.equalsIgnoreCase("Veterinario") && 
            !role.equalsIgnoreCase("Vendedor") && 
            !role.equalsIgnoreCase("Dueño")) {
            throw new Exception("Rol no valido. Debe ser Admin, Veterinario, Vendedor o Dueño.");
        }

        return role;
    }
}

