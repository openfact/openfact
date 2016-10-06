package org.openfact.services.managers;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.UblDocumentType;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.ubl.provider.InvoiceProvider;
import org.openfact.models.utils.RepresentationToModel;
import org.openfact.representations.idm.ubl.InvoiceRepresentation;
import org.openfact.ubl.UblExtensionContentGeneratorProvider;
import org.openfact.ubl.UblIDGeneratorProvider;

public class InvoiceManager {

    protected static final Logger logger = Logger.getLogger(DebitNoteManager.class);
    
    protected OpenfactSession session;
    protected InvoiceProvider model;

    public InvoiceManager(OpenfactSession session) {
        this.session = session;
        this.model = session.invoices();
    }

    public InvoiceModel getInvoiceByID(OrganizationModel organization, String ID) {
        return model.getInvoiceByID(organization, ID);
    }

    public InvoiceModel addInvoice(OrganizationModel organization, InvoiceRepresentation rep) {
        String defaultUblLocale = organization.getDefaultUblLocale();
        
        String ID = rep.getId();
        if (ID == null) {
            UblIDGeneratorProvider provider;
            if (defaultUblLocale == null) {
                provider = session.getProvider(UblIDGeneratorProvider.class);
            } else {
                provider = session.getProvider(UblIDGeneratorProvider.class, organization.getDefaultUblLocale());
            }

            if (rep.getInvoiceTypeCode() == null) {
                ID = provider.generateID(organization, UblDocumentType.CREDIT_NOTE);
            } else {
                ID = provider.generateID(organization, UblDocumentType.CREDIT_NOTE, rep.getInvoiceTypeCode());
            }
        }
        InvoiceModel invoice = model.addInvoice(organization, ID);

        RepresentationToModel.importInvoice(session, organization, invoice, rep);
        
        // Generate extensions
        if(defaultUblLocale != null) {
            UblExtensionContentGeneratorProvider provider = session.getProvider(UblExtensionContentGeneratorProvider.class, organization.getDefaultUblLocale());
            provider.generateUBLExtensions(organization, invoice);    
        } else {
            logger.debug("Invoice created without UBLExtension");
        }
        
        return invoice;
    }

    public boolean removeInvoice(OrganizationModel organization, InvoiceModel invoice) {
        if (model.removeInvoice(organization, invoice)) {
            return true;
        }
        return false;
    }

}
