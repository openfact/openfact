package org.openfact.ubl.pe;

import java.text.ParseException;

import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.UblDocumentType;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.services.util.MaskToString;
import org.openfact.ubl.UblIDGeneratorProvider;

public class UblIDGeneratorProvider_PE implements UblIDGeneratorProvider {

    protected OpenfactSession session;

    public UblIDGeneratorProvider_PE(OpenfactSession session) {
        this.session = session;
    }

    @Override
    public void close() {
    }

    @Override
    public String getID(OrganizationModel organization, UblDocumentType type) {
        InvoiceModel i = session.invoices().getLastInvoice(organization);
        String value = i.getID();
        String mask = "A###-########";
        try {
            return MaskToString.formatString(value, mask, true);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
