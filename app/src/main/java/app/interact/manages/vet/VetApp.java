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
            System.out.println("1️⃣ Registrar Usuario");
            System.out.println("2️⃣ Registrar Mascota");
            System.out.println("3️⃣ Crear Historia Clínica");
            System.out.println("4️⃣ Crear Orden Médica");
            System.out.println("5️⃣ Generar Factura");
            System.out.println("6️⃣ Mostrar Usuarios Registrados");
            System.out.println("7️⃣ Mostrar Mascotas Registradas");
            System.out.println("8️⃣ Mostrar Historias Clínicas");
            System.out.println("9️⃣ Mostrar órdenes médicas");
            System.out.println("0️⃣ Salir");
            System.out.print("🔷 Elija una opción: ");
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