package org.openfact.testsuite.providers.ubl.send.pe;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.RequeridActionDocument;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.utils.OpenfactModelUtils;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.services.managers.OrganizationManager;
import org.openfact.testsuite.providers.AbstractProviderTest;
import org.openfact.ubl.UblExtensionContentGeneratorProvider;
import org.openfact.ubl.UblProvider;
import org.openfact.ubl.send.UblTaskRunnerProvider;

public class UblTaskRunnerProviderTest_PE extends AbstractProviderTest {
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
	public void exececuteTask() throws Exception {
		List<InvoiceModel> invoices = session.invoices().getInvoices(organization);
		for (InvoiceModel invoice : invoices) {
			session.getProvider(UblExtensionContentGeneratorProvider.class, organization.getDefaultUblLocale())
					.generateUBLExtensions(organization, invoice);
			session.getProvider(UblProvider.class, organization.getDefaultUblLocale()).getDocument(organization,
					invoice);
			invoice.setRequeridAction(Arrays.asList(RequeridActionDocument.SEND_SOA_XML_DOCUMENT));
		}

		UblTaskRunnerProvider task = session.getProvider(UblTaskRunnerProvider.class,
				organization.getDefaultUblLocale());
		task.exececuteTask(organization);

		//assertThat(invoice, is(notNullValue()));
	}

}
