package org.openfact.ubl.send.pe;

import org.openfact.models.OpenfactSession;
import org.openfact.ubl.send.UblTaskRunnerProvider;

public class UblTaskRunnerProvider_PE implements UblTaskRunnerProvider {

    protected OpenfactSession session;

    public UblTaskRunnerProvider_PE(OpenfactSession session) {
        this.session = session;
    }

    @Override
    public void close() {
    }

    @Override
    public void exececuteTask() {
        System.out.println("UblTaskRunnerProvider_PE");
        sendInvoices();
        sendCreditNotes();
        sendDebitNotes();
    }

    protected void sendInvoices() {

    }

    protected void sendCreditNotes() {

    }

    protected void sendDebitNotes() {

    }

}
