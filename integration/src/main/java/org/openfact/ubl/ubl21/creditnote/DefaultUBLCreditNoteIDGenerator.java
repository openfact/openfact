package org.openfact.ubl.ubl21.creditnote;

import oasis.names.specification.ubl.schema.xsd.creditnote_21.CreditNoteType;
import org.openfact.models.OrganizationModel;
import org.openfact.models.utils.OpenfactModelUtils;
import org.openfact.ubl.ubl21.qualifiers.UBLDocumentType;
import org.openfact.ubl.ubl21.qualifiers.UBLProviderType;

import javax.ejb.Stateless;

@UBLProviderType("default")
@UBLDocumentType("CREDIT_NOTE")
@Stateless
public class DefaultUBLCreditNoteIDGenerator implements UBLCreditNoteIDGenerator {

    @Override
    public String generateID(OrganizationModel organization, CreditNoteType creditNoteType) {
        return OpenfactModelUtils.generateId();
    }

}
