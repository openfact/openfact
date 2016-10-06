package org.openfact.services.managers;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.UblDocumentType;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.provider.CreditNoteProvider;
import org.openfact.models.utils.RepresentationToModel;
import org.openfact.representations.idm.ubl.CreditNoteRepresentation;
import org.openfact.ubl.UblExtensionContentGeneratorProvider;
import org.openfact.ubl.UblIDGeneratorProvider;

public class CreditNoteManager {

    protected static final Logger logger = Logger.getLogger(DebitNoteManager.class);
    
    protected OpenfactSession session;
    protected CreditNoteProvider model;

    public CreditNoteManager(OpenfactSession session) {
        this.session = session;
        this.model = session.creditNotes();
    }

    public CreditNoteModel getCreditNoteByID(OrganizationModel organization, String ID) {
        return model.getCreditNoteByID(organization, ID);
    }

    public CreditNoteModel addCreditNote(OrganizationModel organization, CreditNoteRepresentation rep) {
        String defaultUblLocale = organization.getDefaultUblLocale();
        
        String ID = rep.getId();
        if (ID == null) {
            UblIDGeneratorProvider provider;
            if(defaultUblLocale == null) {
                provider = session.getProvider(UblIDGeneratorProvider.class);                
            } else {
                provider = session.getProvider(UblIDGeneratorProvider.class, organization.getDefaultUblLocale());
            }
            ID = provider.generateID(organization, UblDocumentType.CREDIT_NOTE);
        }
        CreditNoteModel creditNote = model.addCreditNote(organization, ID);
        
        RepresentationToModel.importCreditNote(session, organization, creditNote, rep);
        
        // Generate extensions
        if(defaultUblLocale != null) {
            UblExtensionContentGeneratorProvider provider = session.getProvider(UblExtensionContentGeneratorProvider.class, organization.getDefaultUblLocale());
            provider.generateUBLExtensions(organization, creditNote);    
        } else {
            logger.debug("Credit note created without UBLExtension");
        }
        
        return creditNote;
    }

    public boolean removeCreditNote(OrganizationModel organization, CreditNoteModel creditNote) {
        if (model.removeCreditNote(organization, creditNote)) {
            return true;
        }
        return false;
    }
   
}
