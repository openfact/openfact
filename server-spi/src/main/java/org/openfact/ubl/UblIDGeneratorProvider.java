package org.openfact.ubl;

import org.openfact.models.OrganizationModel;
import org.openfact.provider.Provider;

public interface UblIDGeneratorProvider extends Provider {

    String generateInvoiceID(OrganizationModel organization, String invoiceCodeType);

    String generateCreditNoteID(OrganizationModel organization, String... referencesID);

    String generateDebitNoteID(OrganizationModel organization, String... referencesID);

}
