package org.openfact.ubl.ubl21.debitnote;

import oasis.names.specification.ubl.schema.xsd.debitnote_21.DebitNoteType;
import org.openfact.models.OrganizationModel;
import org.openfact.models.utils.OpenfactModelUtils;
import org.openfact.ubl.ubl21.qualifiers.UBLDocumentType;
import org.openfact.ubl.ubl21.qualifiers.UBLProviderType;

@UBLProviderType("default")
@UBLDocumentType("DEBIT_NOTE")
public class DefaultUBLDebitNoteIDGenerator implements UBLDebitNoteIDGenerator {

    @Override
    public String generateID(OrganizationModel organization, DebitNoteType debitNoteType) {
        return OpenfactModelUtils.generateId();
    }

}
