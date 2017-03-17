package org.openfact.ubl.ubl21.creditnote;

import org.openfact.models.OrganizationModel;
import org.openfact.models.utils.OpenfactModelUtils;
import org.openfact.ubl.ubl21.qualifiers.UBLDocumentType;
import org.openfact.provider.ProviderType;

import javax.ejb.Stateless;

@ProviderType("default")
@UBLDocumentType("CREDIT_NOTE")
@Stateless
public class DefaultUBLCreditNoteIDGenerator implements UBLCreditNoteIDGenerator {

    @Override
    public String generateID(OrganizationModel organization, Object o) {
        return OpenfactModelUtils.generateId();
    }
}
