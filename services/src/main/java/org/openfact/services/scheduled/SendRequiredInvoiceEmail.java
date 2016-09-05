package org.openfact.services.scheduled;

import java.util.List;

import org.openfact.email.EmailException;
import org.openfact.email.EmailTemplateProvider;
import org.openfact.models.InvoiceModel;
import org.openfact.models.utils.OpenfactModelUtils;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionTask;
import org.openfact.timer.ScheduledTask;

public class SendRequiredInvoiceEmail implements ScheduledTask {

    @Override
    public void run(OpenfactSession session) {             
        List<InvoiceModel> invoices = session.invoices().getInvoices(InvoiceModel.RequiredAction.SEND_EMAIL_INMEDIATELLY);
        for (InvoiceModel invoice : invoices) {                
            OpenfactModelUtils.runJobInTransaction(session.getOpenfactSessionFactory(), new OpenfactSessionTask() {               
                @Override
                public void run(OpenfactSession session) {
                    EmailTemplateProvider emailTemplate = session.getProvider(EmailTemplateProvider.class);
                    emailTemplate.setOrganization(invoice.getOrganization());
                    emailTemplate.setInvoice(invoice);
                    try {
                        emailTemplate.sendReceip();
                        invoice.removeRequiredAction(InvoiceModel.RequiredAction.SEND_EMAIL_INMEDIATELLY);
                    } catch (EmailException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
        }
    }

}
