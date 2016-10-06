package org.openfact.services.managers;

import java.util.List;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.provider.DebitNoteProvider;
import org.openfact.models.utils.RepresentationToModel;
import org.openfact.representations.idm.ubl.DebitNoteRepresentation;
import org.openfact.ubl.UblExtensionContentGeneratorProvider;
import org.openfact.ubl.UblIDGeneratorProvider;

public class DebitNoteManager {

    protected static final Logger logger = Logger.getLogger(DebitNoteManager.class);
    
    protected OpenfactSession session;
    protected DebitNoteProvider model;    

    public DebitNoteManager(OpenfactSession session) {
        this.session = session;
        this.model = session.debitNotes();
    }

    public DebitNoteModel getDebitNoteByID(OrganizationModel organization, String ID) {
        return model.getDebitNoteByID(organization, ID);
    }

    public DebitNoteModel addDebitNote(OrganizationModel organization, DebitNoteRepresentation rep) {
        String defaultUblLocale = organization.getDefaultUblLocale();
        
        String ID = rep.getId();
        if (ID == null) {
            UblIDGeneratorProvider provider;
            if(defaultUblLocale == null) {
                provider = session.getProvider(UblIDGeneratorProvider.class);                
            } else {
                provider = session.getProvider(UblIDGeneratorProvider.class, organization.getDefaultUblLocale());
            }
            List<String> referencesID = rep.getDiscrepancyResponse().stream().map(f -> f.getReferenceID()).collect(Collectors.toList());
            ID = provider.generateCreditNoteID(organization, referencesID.toArray(new String[referencesID.size()]));
        }
        DebitNoteModel debitNote = model.addDebitNote(organization, ID);
        
        RepresentationToModel.importDebitNote(session, organization, debitNote, rep);
        
        // Generate extensions
        if(defaultUblLocale != null) {
            UblExtensionContentGeneratorProvider provider = session.getProvider(UblExtensionContentGeneratorProvider.class, organization.getDefaultUblLocale());
            provider.generateUBLExtensions(organization, debitNote);    
        } else {
            logger.debug("Debit note created without UBLExtension");
        }
        
        return debitNote;
    }

    public boolean removeDebitNote(OrganizationModel organization, DebitNoteModel debitNote) {
        if (model.removeDebitNote(organization, debitNote)) {
            return true;
        }
        return false;
    }    

}
