
package app.domain.services;

/**
 *
 * @author USUARIO
 */
import app.domain.models.MedicalOrder;
import app.ports.MedicalOrderPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MedicalOrderService {
    @Autowired
    private MedicalOrderPort medicalOrderPort;

    public void registerMedicalOrder(MedicalOrder medicalOrder) {
        medicalOrderPort.save(medicalOrder);
    }

    public List<MedicalOrder> getAllMedicalOrders() {
        return medicalOrderPort.findAll();
    }
}

