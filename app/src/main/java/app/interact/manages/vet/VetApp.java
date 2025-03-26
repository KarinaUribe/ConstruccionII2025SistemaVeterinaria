package app.interact.manages;

import app.manages.AdminManages;
import app.domain.models.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VetApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AdminManages adminManages = new AdminManages();
    private static final PetInteract petInteract = new PetInteract(adminManages);
    private static final UserInteract userInteract = new UserInteract(adminManages);
    private static final ClinicalHistoryInteract clinicalHistoryInteract = new ClinicalHistoryInteract(adminManages);
    private static final OrderInteract orderInteract = new OrderInteract(adminManages);
    private static final InvoiceInteract invoiceInteract = new InvoiceInteract(adminManages);

    public static void main(String[] args) {
        int option;
        do {
            System.out.println("\n📌 SISTEMA DE GESTIÓN VETERINARIA 📌");
            ("1️⃣ Registrar Usuario");
            ("2️⃣ Registrar Mascota");
            ("3️⃣ Crear Historia Clínica");
            ("4️⃣ Crear Orden Médica");
            ("5️⃣ Generar Factura");
            ("6️⃣ Mostrar Usuarios Registrados");
            ("7️⃣ Mostrar Mascotas Registradas");
            ("8️⃣ Mostrar Historias Clínicas");
            ("9️⃣ Mostrar órdenes médicas");
            ("0️⃣ Salir");
            ("🔷 Elija una opción: ");
            option = scanner.nextInt();
            scanner.nextLine();


            switch (option) {
                case 1 -> registerUser();
                case 2 -> registerPet();
                case 3 -> createClinicalHistory();
                case 4 -> createMedicalOrder();
                case 5 -> generateInvoice();
                case 6 -> userInteract.printAllUsers();
                case 7 -> petInteract.printAllPets();
                case 8 -> clinicalHistoryInteract.printAllClinicalHistories();
                case 9 -> orderInteract.printAllOrders();
                case 0 -> System.out.println("Cargando... Gracias!");
                default -> System.out.println("¡Opcion no valida! Intentalo de nuevo");
            }
        } while (option != 0);
    }
}