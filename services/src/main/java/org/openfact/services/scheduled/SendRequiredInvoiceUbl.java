package org.openfact.services.scheduled;

import java.util.List;

import org.openfact.models.InvoiceModel;
import org.openfact.models.OpenfactModelUtils;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionTask;
import org.openfact.timer.ScheduledTask;
import org.openfact.ubl.UblException;
import org.openfact.ubl.UblSenderProvider;

public class SendRequiredInvoiceUbl implements ScheduledTask {

    @Override
    public void run(OpenfactSession session) {
        List<InvoiceModel> invoices = session.invoices().getInvoices(InvoiceModel.RequiredAction.SEND_EMAIL_INMEDIATELLY);
        for (InvoiceModel invoice : invoices) {
            OpenfactModelUtils.runJobInTransaction(session.getOpenfactSessionFactory(),
                    new OpenfactSessionTask() {
                        @Override
                        public void run(OpenfactSession session) {
                            UblSenderProvider ublSender = session.getProvider(UblSenderProvider.class);
                            try {
                                ublSender.send(invoice.getOrganization(), invoice, null);
                                invoice.removeRequiredAction(InvoiceModel.RequiredAction.SEND_UBL_INMEDIATELLY);
                            } catch (UblException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    });
        }
    }
}
