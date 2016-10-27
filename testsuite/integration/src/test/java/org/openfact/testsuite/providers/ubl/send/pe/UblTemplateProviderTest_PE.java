package org.openfact.testsuite.providers.ubl.send.pe;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.RequeridActionDocument;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.utils.OpenfactModelUtils;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.services.managers.OrganizationManager;
import org.openfact.testsuite.providers.AbstractProviderTest;
import org.openfact.ubl.UblExtensionContentGeneratorProvider;
import org.openfact.ubl.UblProvider;
import org.openfact.ubl.send.UblTemplateProvider;

public class UblTemplateProviderTest_PE extends AbstractProviderTest {

	public static final String LOCAL = "pe";

	protected OrganizationModel organization;

	@Before
	@Override
	public void before() throws Exception {
		super.before();
		OrganizationManager manager = organizationManager;
		OrganizationRepresentation rep = AbstractProviderTest.loadJson("model/testorganization2.json");
		rep.setId("TestTemplateProviderPE");

		organization = manager.importOrganization(rep);
		organization.setAssignedIdentificationId("10467793549");
		Map<String, String> config = new HashMap<>();
		config.put("username", "10467793549MODDATOS");
		config.put("password", "MODDATOS");
		config.put("urlService", "https://e-beta.sunat.gob.pe/ol-ti-itcpfegem-beta/billService");
		organization.setUblSenderConfig(config);
		organization.setDefaultUblLocale(LOCAL);
	}

	@Test
	public void sendInvoice() throws Exception {
		List<InvoiceModel> invoices = session.invoices().getInvoices(organization);
		InvoiceModel invoice = invoices.get(0);
		List<RequeridActionDocument> requerid = new ArrayList<>();
		requerid.add(RequeridActionDocument.SEND_SOA_XML_DOCUMENT);
		requerid.add(RequeridActionDocument.SEND_EMAIL_CUSTOMER);
		requerid.add(RequeridActionDocument.SEND_EMAIL_SUPLIER);
		requerid.add(RequeridActionDocument.SEND_EMAIL_RESPONSE);
		invoice.setRequeridAction(requerid);
		session.getProvider(UblExtensionContentGeneratorProvider.class, organization.getDefaultUblLocale())
				.generateUBLExtensions(organization, invoice);
		session.getProvider(UblProvider.class, organization.getDefaultUblLocale()).getDocument(organization, invoice);
		UblTemplateProvider template = session.getProvider(UblTemplateProvider.class,
				organization.getDefaultUblLocale());
		template.setOrganization(organization);
		template.sendInvoice(Arrays.asList(invoice));

		assertThat(invoice, is(notNullValue()));
	}

	@Test
	public void sendCreditNote() throws Exception {
		List<CreditNoteModel> creditNotes = session.creditNotes().getCreditNotes(organization);
		CreditNoteModel creditNote = creditNotes.get(0);
		List<RequeridActionDocument> requerid = new ArrayList<>();
		requerid.add(RequeridActionDocument.SEND_SOA_XML_DOCUMENT);
		requerid.add(RequeridActionDocument.SEND_EMAIL_CUSTOMER);
		requerid.add(RequeridActionDocument.SEND_EMAIL_SUPLIER);
		requerid.add(RequeridActionDocument.SEND_EMAIL_RESPONSE);
		creditNote.setRequeridAction(requerid);
		session.getProvider(UblExtensionContentGeneratorProvider.class, organization.getDefaultUblLocale())
				.generateUBLExtensions(organization, creditNote);
		session.getProvider(UblProvider.class, organization.getDefaultUblLocale()).getDocument(organization,
				creditNote);
		UblTemplateProvider template = session.getProvider(UblTemplateProvider.class,
				organization.getDefaultUblLocale());
		template.setOrganization(organization);
		template.sendCreditNote(creditNote);

		assertThat(creditNote, is(notNullValue()));
	}

	@Test
	public void sendDebitNote() throws Exception {
		List<DebitNoteModel> debitNotes = session.debitNotes().getDebitNotes(organization);
		DebitNoteModel debitNote = debitNotes.get(0);
		List<RequeridActionDocument> requerid = new ArrayList<>();
		requerid.add(RequeridActionDocument.SEND_SOA_XML_DOCUMENT);
		requerid.add(RequeridActionDocument.SEND_EMAIL_CUSTOMER);
		requerid.add(RequeridActionDocument.SEND_EMAIL_SUPLIER);
		requerid.add(RequeridActionDocument.SEND_EMAIL_RESPONSE);
		debitNote.setRequeridAction(requerid);
		session.getProvider(UblExtensionContentGeneratorProvider.class, organization.getDefaultUblLocale())
				.generateUBLExtensions(organization, debitNote);
		session.getProvider(UblProvider.class, organization.getDefaultUblLocale()).getDocument(organization, debitNote);
		UblTemplateProvider template = session.getProvider(UblTemplateProvider.class,
				organization.getDefaultUblLocale());
		template.setOrganization(organization);
		template.sendDebitNote(debitNote);

		assertThat(debitNote, is(notNullValue()));
	}

}
