
package app.ports;

/**
 *
 * @author USUARIO
 */
import app.domain.models.MedicalRecord;
import java.util.List;
import java.util.Optional;

public interface MedicalRecordPort {
    void save(MedicalRecord medicalRecord);
    Optional<MedicalRecord> findById(long medicalRecordId);
    List<MedicalRecord> findAll();
}

