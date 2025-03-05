package app.interact.manages;

import app.manages.AdminManages;
import app.domain.models.Invoice;
import app.domain.models.Pet;
import app.domain.models.Person;
import app.domain.models.Order;
import java.time.LocalDate;
import java.util.List;

public class InvoiceInteract {

    private final AdminManages adminManages;

    public InvoiceController(AdminManages adminManages) {
        this.adminManages = adminManages;
    }

    public void createInvoice(long id, Pet pet, Person owner, Order order, List<String> items, double amount) {
        Invoice newInvoice = new Invoice(id, pet, owner, order, items, amount, LocalDate.now());
        adminManages.addInvoice(newInvoice);
        System.out.println("Factura Creada " + newInvoice.getId());
    }

    public List<Invoice> getAllInvoices() {
        return adminManages.getInvoices();
    }
}

