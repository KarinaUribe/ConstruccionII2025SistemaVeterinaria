
package app.domain.services;

/**
 *
 * @author USUARIO
 */
import app.domain.models.Invoice;
import app.ports.InvoicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InvoiceService {
    @Autowired
    private InvoicePort invoicePort;

    public void registerInvoice(Invoice invoice) {
        invoicePort.save(invoice);
    }

    public List<Invoice> getAllInvoices() {
        return invoicePort.findAll();
    }
}

