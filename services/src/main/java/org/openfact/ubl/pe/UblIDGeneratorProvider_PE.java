package org.openfact.ubl.pe;

import java.util.Arrays;

import org.openfact.common.Utils;
import org.openfact.models.ModelException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.ubl.UblIDGeneratorProvider;

public class UblIDGeneratorProvider_PE implements UblIDGeneratorProvider {

    protected OpenfactSession session;

    public enum Codes_PE {
        /**
         * */
        FACTURA("01", "F%-%", 13),

        /**
        * */
        BOLETA("03", "B%-%", 13),

        /**
        * */
        NOTA_CREDITO("04", "%C%-%", 13),

        /**
        * */
        NOTA_DEBITO("05", "%D%-%", 13);

        private String code;
        private String mask;
        private int lenght;

        private Codes_PE(String code, String mask, int lenght) {
            this.code = code;
            this.mask = mask;
            this.lenght = lenght;
        }

        public static Codes_PE getByCode(String code) {
            return Arrays.asList(values()).stream().filter(p -> p.getCode().equals(code)).findAny()
                    .orElse(null);
        }

        public String getCode() {
            return code;
        }

        public String getMask() {
            return mask;
        }

        public int getLenght() {
            return lenght;
        }
    }

    public UblIDGeneratorProvider_PE(OpenfactSession session) {
        this.session = session;
    }

    @Override
    public void close() {
    }

    @Override
    public String generateInvoiceID(OrganizationModel organization, String invoiceTypeCode) {
        Codes_PE code;
        if (Codes_PE.FACTURA.getCode().equals(invoiceTypeCode)) {
            code = Codes_PE.FACTURA;
        } else if (Codes_PE.BOLETA.getCode().equals(invoiceTypeCode)) {
            code = Codes_PE.BOLETA;
        } else {
            throw new ModelException("Invalid invoiceTypeCode");
        }

        InvoiceModel invoice = session.invoices().getLastInvoice(organization, code.getLenght(),
                code.getMask());

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
        ID.append(code.getMask().substring(0, 1));
        ID.append(Utils.padLeft(String.valueOf(nextSeries), 3, "0"));
        ID.append("-");
        ID.append(Utils.padLeft(String.valueOf(nextNumber), 8, "0"));

        return ID.toString();
    }

    @Override
    public String generateCreditNoteID(OrganizationModel organization, String... referencesID) {
        if(referencesID.length != 1) {
            throw new ModelException("Invalid lenght refenceID");
        }
        String referenceID = referencesID[0];
        Codes_PE code = Codes_PE.NOTA_CREDITO;

        String firstLetter = referenceID.substring(0, 1);
        String mask;
        if (firstLetter.equals("F") || firstLetter.equals("B")) {
            mask = firstLetter + code.getMask();
        } else {
            throw new ModelException("Invalid refenceID");
        }
        CreditNoteModel creditNote = session.creditNotes().getLastCreditNote(organization, code.getLenght(),
                mask);

        int series = 0;
        int number = 0;
        if (creditNote != null) {
            String[] splits = creditNote.getID().split("-");
            series = Integer.parseInt(splits[0].substring(2));
            number = Integer.parseInt(splits[1]);
        }

        int nextNumber = getNextNumber(number, 99_999_999);
        int nextSeries = getNextSerie(series, number, 999, 99_999_999);
        StringBuilder ID = new StringBuilder();
        ID.append(mask.substring(0, 1));
        ID.append("C");
        ID.append(Utils.padLeft(String.valueOf(nextSeries), 2, "0"));
        ID.append("-");
        ID.append(Utils.padLeft(String.valueOf(nextNumber), 8, "0"));

        return ID.toString();
    }

    @Override
    public String generateDebitNoteID(OrganizationModel organization, String... referencesID) {
        if(referencesID.length != 1) {
            throw new ModelException("Invalid lenght refenceID");
        }
        String referenceID = referencesID[0];
        Codes_PE code = Codes_PE.NOTA_DEBITO;

        String firstLetter = referenceID.substring(0, 1);
        String mask;
        if (firstLetter.equals("F") || firstLetter.equals("B")) {
            mask = firstLetter + code.getMask();
        } else {
            throw new ModelException("Invalid refenceID");
        }
        DebitNoteModel debitNote = session.debitNotes().getLastDebitNote(organization, code.getLenght(),
                mask);

        int series = 0;
        int number = 0;
        if (debitNote != null) {
            String[] splits = debitNote.getID().split("-");
            series = Integer.parseInt(splits[0].substring(2));
            number = Integer.parseInt(splits[1]);
        }

        int nextNumber = getNextNumber(number, 99_999_999);
        int nextSeries = getNextSerie(series, number, 999, 99_999_999);
        StringBuilder ID = new StringBuilder();
        ID.append(mask.substring(0, 1));
        ID.append("D");
        ID.append(Utils.padLeft(String.valueOf(nextSeries), 2, "0"));
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
