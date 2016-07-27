package org.openfact.models;

public interface InvoiceIdModel {

    String getId();

    int getSeries();

    int getNumber();
    
    InvoiceModel getInvoice();

}
