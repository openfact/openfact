package org.openfact.testsuite.providers.ubl.pe;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.utils.DocumentUtils;
import org.openfact.models.utils.OpenfactModelUtils;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.services.managers.OrganizationManager;
import org.openfact.testsuite.providers.AbstractProviderTest;
import org.openfact.ubl.UblProvider;
import org.w3c.dom.Document;

import com.helger.commons.error.list.IErrorList;
import com.helger.ubl21.UBL21Reader;
import com.helger.ubl21.UBL21Validator;

import oasis.names.specification.ubl.schema.xsd.creditnote_21.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.debitnote_21.DebitNoteType;
import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;

public class UblProviderTest_PE extends AbstractProviderTest {

	protected OrganizationModel organization;

	@Before
	@Override
	public void before() throws Exception {
		super.before();
		OrganizationManager manager = organizationManager;
		OrganizationRepresentation rep = AbstractProviderTest.loadJson("model/testorganization2.json");
		rep.setId("TestUblProvider");
		organization = manager.importOrganization(rep);
		OpenfactModelUtils.generateOrganizationKeys(organization);
	}

	@Test
	public void getInvoiceDocument() throws Exception {
		List<InvoiceModel> invoices = session.invoices().getInvoices(organization);
		InvoiceModel invoice = invoices.get(0);

		Set<UblProvider> providers = session.getAllProviders(UblProvider.class);
		for (UblProvider provider : providers) {
			Document xml = provider.getDocument(organization, invoice);			
			//InvoiceType invoiceType = UBL21Reader.invoice().read(xml);
			//IErrorList resourceErrorGroup = UBL21Validator.invoice().validate(invoiceType);

			assertThat(xml, is(notNullValue()));
			//assertThat(resourceErrorGroup.getAllErrors().getSize(), is(0));
		}
	}

	@Test
	public void getCreditNoteDocument() throws Exception {
		List<CreditNoteModel> creditNotes = session.creditNotes().getCreditNotes(organization);
		CreditNoteModel creditNote = creditNotes.get(0);

		Set<UblProvider> providers = session.getAllProviders(UblProvider.class);
		for (UblProvider provider : providers) {
			Document xml = provider.getDocument(organization, creditNote);
			// CreditNoteType creditNoteType =
			// UBL21Reader.creditNote().read(xml);
			// IErrorList resourceErrorGroup =
			// UBL21Validator.creditNote().validate(creditNoteType);

			assertThat(xml, is(notNullValue()));
			// assertThat(resourceErrorGroup.getAllErrors().getSize(), is(0));
		}
	}

	@Test
	public void getDebitNoteDocument() throws Exception {
		List<DebitNoteModel> debitNotes = session.debitNotes().getDebitNotes(organization);
		DebitNoteModel debitNote = debitNotes.get(0);

		Set<UblProvider> providers = session.getAllProviders(UblProvider.class);
		for (UblProvider provider : providers) {
			Document xml = provider.getDocument(organization, debitNote);
			// DebitNoteType debitNoteType = UBL21Reader.debitNote().read(xml);
			// IErrorList resourceErrorGroup =
			// UBL21Validator.debitNote().validate(debitNoteType);

			assertThat(xml, is(notNullValue()));
			// assertThat(resourceErrorGroup.getAllErrors().getSize(), is(0));
		}
	}

}
