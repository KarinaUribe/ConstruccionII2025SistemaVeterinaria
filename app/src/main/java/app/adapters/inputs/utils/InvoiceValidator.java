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
import app.domain.models.Invoice;

@Component
public class InvoiceValidator extends SimpleValidator {

    public int amountValidator(int value) throws Exception {
        return numberValidator(value, "Monto de la factura", 1, 1000000);
    }

    public String clientNameValidator(String value) throws Exception {
        return alphabeticValidator(value, "Nombre del cliente");
    }

    public String invoiceIdValidator(String value) throws Exception {
        return stringValidator(value, "ID de la factura");
    }
}

