package org.openfact.email;

import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.provider.Provider;

public interface EmailSenderProvider extends Provider {

    void send(OrganizationModel organization, InvoiceModel invoice, String subject, String textBody,
            String htmlBody) throws EmailException;

}
