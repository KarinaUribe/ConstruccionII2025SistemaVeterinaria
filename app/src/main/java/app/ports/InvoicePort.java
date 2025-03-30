
package app.ports;

import app.domain.models.Invoice;
import java.util.List;
import java.util.Optional;

public interface InvoicePort {
    void save(Invoice invoice);
    Optional<Invoice> findById(long invoiceId);
    List<Invoice> findAll();
}

