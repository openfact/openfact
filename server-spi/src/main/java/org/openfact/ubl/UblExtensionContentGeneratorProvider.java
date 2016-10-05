package org.openfact.ubl;

import java.util.List;

import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.ubl.common.UBLExtensionModel;
import org.openfact.models.ubl.common.UBLExtensionsModel;
import org.openfact.provider.Provider;
import org.w3c.dom.Element;

public interface UblExtensionContentGeneratorProvider extends Provider {

	public List<UBLExtensionModel> generateUBLExtensions(OrganizationModel organization, InvoiceModel invoice);

	public List<UBLExtensionModel> generateUBLExtensions(OrganizationModel organization, CreditNoteModel creditNote);

	public List<UBLExtensionModel> generateUBLExtensions(OrganizationModel organization, DebitNoteModel debitNote);

}
