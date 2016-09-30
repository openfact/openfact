package org.openfact.ubl.pe;

import java.math.BigDecimal;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.ubl.UblExtensionContentGeneratorProvider;
import org.openfact.ubl.pe.extensions.AdditionalInformationTypeSunatAgg;
import org.openfact.ubl.pe.extensions.AdditionalMonetaryTotalType;
import org.w3c.dom.Element;

import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.PayableAmountType;

public class UblExtensionContentGeneratorProvider_PE implements UblExtensionContentGeneratorProvider {

	private static final Logger log = Logger.getLogger(UblExtensionContentGeneratorProvider_PE.class);

	protected OpenfactSession session;

	public UblExtensionContentGeneratorProvider_PE(OpenfactSession session) {
		this.session = session;
	}

	@Override
	public void close() {

	}

	@Override
	public Element getExtensionContentType(OrganizationModel organization, InvoiceModel model) {
		AdditionalInformationTypeSunatAgg additionalInformation = new AdditionalInformationTypeSunatAgg();

		IDType idAMonetaryTotal = new IDType();
		idAMonetaryTotal.setValue(model.getDocumentCurrencyCode());
		PayableAmountType pa = new PayableAmountType();
		pa.setCurrencyID("PEN");
		pa.setValue(new BigDecimal(15));
		AdditionalMonetaryTotalType amtt = new AdditionalMonetaryTotalType();
		amtt.setID(idAMonetaryTotal);
		amtt.setPayableAmount(pa);

		additionalInformation.getAdditionalMonetaryTotal().add(amtt);

		return null;
	}

	@Override
	public Element getExtensionContentType(OrganizationModel organization, CreditNoteModel creditNote) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Element getExtensionContentType(OrganizationModel organization, DebitNoteModel debitNote) {
		// TODO Auto-generated method stub
		return null;
	}

}
