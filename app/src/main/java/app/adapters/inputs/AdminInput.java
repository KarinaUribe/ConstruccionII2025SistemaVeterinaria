/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package app.adapters.inputs;

/**
 *
 * @author USUARIO
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import app.adapters.inputs.utils.PetValidator;
import app.adapters.inputs.utils.PersonValidator;
import app.adapters.inputs.utils.UserValidator;
import app.adapters.inputs.utils.Utils;
import app.domain.models.Pet;
import app.domain.models.User;
import app.ports.InputPort;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Component
public class AdminInput implements InputPort {

    @Autowired
    private PetValidator petValidator;
    @Autowired
    private UserValidator userValidator;

    private final String MENU = "\n MENU \n" +
            "1 registrar usruario\n" +
            "2 Registrar mascota\n" +
            "3 crear Orden medica\n" +
            "4 Generar factura\n" +
            "5 Mostrar usuarios registrados\n" +
            "6 Mostrar mascotas registradas\n" +
            "7 Mostrar historias Clinicas\n" +
            "8 Mostrar ordenes Medicas\n" +
            "0 Salir\n" +
            "* Elija una Opcion: ";

    public void menu() {
        System.out.println(MENU);
        String option = Utils.getReader().nextLine();
        switch (option) {
            case "1" -> registerUser();
            case "2" -> registerPet();
            case "3" -> createMedicalOrder();
            case "4" -> generateInvoice();
            case "5" -> printAllUsers();
            case "6" -> printAllPets();
            case "7" -> printAllMedicalRecord();
            case "8" -> printAllMedicalOrders();
            case "0" -> System.out.println("Cargando... Gracias!");
            default -> System.out.println("¡Opcion no valida! Intentalo de nuevo");
        }
    }

    private void registerUser() {
        System.out.println("Ingrese el nombre del usuario:");
        String name = userValidator.nameValidator(Utils.getReader().nextLine());
        System.out.println("Ingrese el documento del usuario:");
        long document = userValidator.documentValidator(Utils.getReader().nextLine());
        System.out.println("Ingrese la edad del usuario:");
        int age = Integer.parseInt(Utils.getReader().nextLine());

        User user = new User(document, name, age);
        System.out.println("Usuario registrado con exito: " + user);
    }

    private void registerPet() {
        System.out.println("Ingrese el nombre de la mascota:");
        String name = petValidator.nameValidator(Utils.getReader().nextLine());
        System.out.println("Ingrese la edad de la mascota:");
        int age = Integer.parseInt(Utils.getReader().nextLine());

        Pet pet = new Pet(name, age);
        System.out.println("Mascota registrada con exito: " + pet);
    }

    private void createMedicalOrder() {
        System.out.println("Funcionalidad en desarrollo...");
    }

    private void generateInvoice() {
        System.out.println("Funcionalidad en desarrollo...");
    }

    private void printAllUsers() {
        System.out.println("Mostrando todos los usuarios...");
    }

    private void printAllPets() {
        System.out.println("Mostrando todas las mascotas...");
    }

    private void printAllMedicalRecord() {
        System.out.println("Mostrando historias clinicas...");
    }

    private void printAllMedicalOrder() {
        System.out.println("Mostrando ordenes medicas...");
    }
}
