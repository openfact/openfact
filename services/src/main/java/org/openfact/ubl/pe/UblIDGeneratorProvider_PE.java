package org.openfact.ubl.pe;

import org.openfact.common.Utils;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.UblDocumentType;
import org.openfact.models.ubl.InvoiceModel;
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
    public String generateID(OrganizationModel organization, UblDocumentType type) {
        try {
            if (type.equals(UblDocumentType.INVOICE)) {
                InvoiceModel invoice = session.invoices().getLastInvoice(organization, 13, "%-%");
                String series, number;
                if (invoice == null) {
                    series = "F" + getSerie(String.valueOf(1), String.valueOf(0));
                    number = getNumber(String.valueOf(1), String.valueOf(0));
                } else {
                    String ID = invoice.getID();
                    String[] Ids = ID.split("-");
                    series = Ids[0].substring(0, 1) + getSerie(Ids[0].substring(1), Ids[1]);
                    number = getNumber(Ids[0].substring(1), Ids[1]);
                }
                return series + "-" + number;

            } else if (type.equals(UblDocumentType.CREDIT_NOTE)) {
                return "";
            } else if (type.equals(UblDocumentType.DEBIT_NOTE)) {
                return "";
            }
        } catch (NumberFormatException e) {
            log.
        }
        return null;
    }
    
    @Override
    public String generateID(OrganizationModel organization, UblDocumentType type, String codeType) {
        // TODO Auto-generated method stub
        return null;
    }

    private String getSerie(String serie, String number) {
        if (Integer.valueOf(number) < 99999999) {
            return Utils.padLeft(serie, 3, "0");
        } else {
            Integer Serie = Integer.valueOf(serie);
            Serie = Serie + 1;
            return Utils.padLeft(String.valueOf(Serie), 3, "0");
        }
    }

    private String getNumber(String serie, String number) {
        if (Integer.valueOf(number) < 99999999) {
            Integer Number = Integer.valueOf(number) + 1;
            return Utils.leftPad(String.valueOf(Number), 8, '0');
        } else {
            return Utils.leftPad(String.valueOf(1), 8, '0');
        }
    }

    

}
