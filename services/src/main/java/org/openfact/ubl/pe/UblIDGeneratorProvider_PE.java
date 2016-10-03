package org.openfact.ubl.pe;

import org.openfact.common.Utils;
import org.openfact.models.ModelException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.UblDocumentType;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
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
        switch (type) {
        case INVOICE:
            throw new ModelException("Imposible generar ID");
        case CREDIT_NOTE:
            return generateCreditNoteID(organization, type);
        case DEBIT_NOTE:
            return generateDebitNoteID(organization, type);
        default:
            throw new ModelException("Not implemented");
        }
    }

    @Override
    public String generateID(OrganizationModel organization, UblDocumentType type, String codeType) {
        switch (type) {
        case INVOICE:
            return generateInvoiceID(organization, type, codeType);
        case CREDIT_NOTE:
            return generateCreditNoteID(organization, type);
        case DEBIT_NOTE:
            return generateDebitNoteID(organization, type);
        default:
            throw new ModelException("Not implemented");
        }
    }

    private String generateInvoiceID(OrganizationModel organization, UblDocumentType type, String codeType) {
        String mask = null;
        int lenght = 13;

        if (codeType == "01") {
            mask = "F%-%";
        } else if (codeType == "03") {
            mask = "B%-%";
        } else {
            throw new ModelException("Not implemented");
        }

        InvoiceModel invoice = session.invoices().getLastInvoice(organization, lenght, mask);

        int series = 0;
        int number = 0;
        if (invoice != null) {
            String[] splits = invoice.getID().split("-");
            series = Integer.parseInt(splits[0].substring(1));
            number = Integer.parseInt(splits[1]);
        }

        int nextNumber = getNextNumber(number, 99_999_999);
        int nextSeries = getNextSerie(series, number, 999, 99_999_999);
        StringBuilder ID = new StringBuilder();
        ID.append(mask.substring(0, 1));
        ID.append(Utils.padLeft(String.valueOf(nextSeries), 3, "0"));
        ID.append("-");
        ID.append(Utils.padLeft(String.valueOf(nextNumber), 8, "0"));

        return ID.toString();
    }

    private String generateCreditNoteID(OrganizationModel organization, UblDocumentType type) {
        String mask = "C%-%";
        int lenght = 13;

        CreditNoteModel creditNote = session.creditNotes().getLastCreditNote(organization, lenght, mask);

        int series = 0;
        int number = 0;
        if (creditNote != null) {
            String[] splits = creditNote.getID().split("-");
            series = Integer.parseInt(splits[0].substring(1));
            number = Integer.parseInt(splits[1]);
        }

        int nextNumber = getNextNumber(number, 99_999_999);
        int nextSeries = getNextSerie(series, number, 999, 99_999_999);
        StringBuilder ID = new StringBuilder();
        ID.append(mask.substring(0, 1));
        ID.append(Utils.padLeft(String.valueOf(nextSeries), 3, "0"));
        ID.append("-");
        ID.append(Utils.padLeft(String.valueOf(nextNumber), 8, "0"));

        return ID.toString();
    }

    private String generateDebitNoteID(OrganizationModel organization, UblDocumentType type) {
        String mask = "D%-%";
        int lenght = 13;

        DebitNoteModel debitNote = session.debitNotes().getLastDebitNote(organization, lenght, mask);

        int series = 0;
        int number = 0;
        if (debitNote != null) {
            String[] splits = debitNote.getID().split("-");
            series = Integer.parseInt(splits[0].substring(1));
            number = Integer.parseInt(splits[1]);
        }

        int nextNumber = getNextNumber(number, 99_999_999);
        int nextSeries = getNextSerie(series, number, 999, 99_999_999);
        StringBuilder ID = new StringBuilder();
        ID.append(mask.substring(0, 1));
        ID.append(Utils.padLeft(String.valueOf(nextSeries), 3, "0"));
        ID.append("-");
        ID.append(Utils.padLeft(String.valueOf(nextNumber), 8, "0"));

        return ID.toString();
    }

    private int getNextSerie(int currentSerie, int currenctNumber, int maxSerie, int maxNumber) {
        if (getNextNumber(currenctNumber, maxNumber) == 1) {
            return ++currentSerie;
        } else if (currentSerie < maxSerie) {
            return currentSerie;
        } else {
            throw new ModelException("Max series and number");
        }
    }

    private int getNextNumber(int currenctNumber, int maxNumber) {
        if (currenctNumber < maxNumber) {
            return ++currenctNumber;
        } else {
            return 1;
        }
    }

}
