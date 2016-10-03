/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openfact.testsuite.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.math.BigDecimal;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.transform.dom.DOMResult;

import org.junit.Test;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.ubl.common.AddressModel;
import org.openfact.models.ubl.common.AttachmentModel;
import org.openfact.models.ubl.common.CustomerPartyModel;
import org.openfact.models.ubl.common.ExtensionContentModel;
import org.openfact.models.ubl.common.ExternalReferenceModel;
import org.openfact.models.ubl.common.InvoiceLineModel;
import org.openfact.models.ubl.common.ItemIdentificationModel;
import org.openfact.models.ubl.common.ItemModel;
import org.openfact.models.ubl.common.MonetaryTotalModel;
import org.openfact.models.ubl.common.PartyLegalModel;
import org.openfact.models.ubl.common.PartyModel;
import org.openfact.models.ubl.common.PriceModel;
import org.openfact.models.ubl.common.PricingReferenceModel;
import org.openfact.models.ubl.common.QuantityModel;
import org.openfact.models.ubl.common.SignatureModel;
import org.openfact.models.ubl.common.SupplierPartyModel;
import org.openfact.models.ubl.common.TaxCategoryModel;
import org.openfact.models.ubl.common.TaxSchemeModel;
import org.openfact.models.ubl.common.TaxSubtotalModel;
import org.openfact.models.ubl.common.TaxTotalModel;
import org.openfact.models.ubl.common.UBLExtensionModel;
import org.openfact.models.ubl.common.UBLExtensionsModel;
import org.openfact.models.utils.UblSignature;
import org.openfact.ubl.UblProvider;
import org.openfact.ubl.pe.extensions.AdditionalInformationTypeSunatAgg;
import org.openfact.ubl.pe.extensions.AdditionalMonetaryTotalType;
import org.openfact.ubl.pe.extensions.ObjectFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.helger.commons.error.list.IErrorList;
import com.helger.ubl21.UBL21Reader;
import com.helger.ubl21.UBL21Validator;
import com.helger.ubl21.UBL21Writer;

import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.PayableAmountType;
import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;

/**
 * @author <a href="mailto:sthorger@redhat.com">Stian Thorgersen</a>
 */
public class InvoiceModelTest extends AbstractModelTest {

	protected OrganizationModel organization;

	public void createOrganization() throws Exception {
		organization = organizationManager.createOrganization("SISTCOOP");
		organization.setName("SISTCOOP");
		organization.setDescription("SISTCOOP IS A SOFTWARE COMPANY");
		organization.setEnabled(true);
		organization.setAttempNumber(5);
		organization.setLapseTime(50);
		organization.setOnErrorAttempNumber(2);
		organization.setOnErrorLapseTime(500);
		organization.setDelayTime(0);
		organization.setSubmitTime(LocalTime.now());
		organization.setSubmitDays(new HashSet<DayOfWeek>(Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.THURSDAY)));

		organization.setAssignedIdentificationId("012345678910");
		organization.setSupplierName("SISTCOOP SAC");
		organization.setRegistrationName("SISTCOOP SOFTWARE");
		organization.setAdditionalAccountId("RUC");
		organization.setStreetName("Jr. Arequipa 123");
		organization.setCitySubdivisionName("Ayacucho");
		organization.setCityName("Huamanga");
		organization.setCountrySubentity("Region");
		organization.setDistrict("Jesus Nazareno");
		organization.setCountryIdentificationCode("PE");

		KeyPair keyPair = generateKeypair();
		organization.setPrivateKey(keyPair.getPrivate());
		organization.setPublicKey(keyPair.getPublic());

		organization.addCurrency("PEN");
		organization.addCurrency("USD");
		commit();

	}

	@Test
	public void getDocument() throws Exception {
		createOrganization();

		InvoiceModel invoice = session.invoices().addInvoice(organization, "F001-0001");
		invoice.setUBLVersionID("2.0");
		invoice.setCustomizationID("1.0");

		invoice.setID("F001-0001");
		invoice.setIssueDate(LocalDate.now());
		invoice.setInvoiceTypeCode("01");
		invoice.setDocumentCurrencyCode("PEN");

		// signature
		SignatureModel signature = invoice.addSignature();
		signature.setID("IDSignOlva");

		PartyModel partySignature = signature.getSignatoryParty();
		partySignature.getPartyIdentification().add("20494637074");
		partySignature.getPartyName().add("AHREN CONTRATISTAS GENERALES S.A.C");

		AttachmentModel attachment = signature.getDigitalSignatureAttachment();

		ExternalReferenceModel externalReference = attachment.getExternalReference();
		externalReference.setURI("#SignatureOlva");

		// SupplierParty
		SupplierPartyModel supplierParty = invoice.getAccountingSupplierParty();
		supplierParty.setCustomerAssignedAccountID("20494637074");
		supplierParty.getAdditionalAccountID().add("6");

		PartyModel partySupplier = supplierParty.getParty();

		AddressModel address = partySupplier.getPostalAddress();
		address.setID("050101");
		address.setStreetName("MZA. A LOTE. 3");
		address.setCitySubdivisionName("ASOC. SANTA TERESA");
		address.setCityName("AYACUCHO");
		address.setCountrySubentity("HUAMANGA");
		address.setDistrict("AYACUCHO");
		address.getCountry().setIdentificationCode("PE");

		PartyLegalModel partyLegalSupplier = partySupplier.addPartyLegalEntity();
		partyLegalSupplier.setRegistrationName("SISTCOOP S.A.C");

		// CustomerParty
		CustomerPartyModel customerParty = invoice.getAccountingCustomerParty();
		customerParty.setCustomerAssignedAccountID("20407446497");
		customerParty.getAdditionalAccountID().add("6");

		PartyModel partyCustomer = customerParty.getParty();

		PartyLegalModel partyLegalCustomer = partyCustomer.addPartyLegalEntity();
		partyLegalCustomer.setRegistrationName("AHREN CONTRATISTAS");

		// TaxTotal
		TaxTotalModel taxTotalInvoice = invoice.addTaxTotal();
		taxTotalInvoice.setTaxAmount(new BigDecimal("62675.85"));

		TaxSubtotalModel taxSubtotalInvoice = taxTotalInvoice.addTaxSubtotal();
		taxSubtotalInvoice.setTaxAmount(new BigDecimal("62675.85"));

		TaxCategoryModel taxCategoryInvoice = taxSubtotalInvoice.getTaxCategory();

		TaxSchemeModel taxSchemeInvoice = taxCategoryInvoice.getTaxScheme();
		taxSchemeInvoice.setID("1000");
		taxSchemeInvoice.setName("IGV");
		taxSchemeInvoice.setTaxTypeCode("VAT");

		// LegalMonetaryTotal
		MonetaryTotalModel monetaryTotal = invoice.getLegalMonetaryTotal();
		monetaryTotal.setPayableAmount(new BigDecimal("423225.00"));

		// InvoiceLine
		InvoiceLineModel invoiceLine = invoice.addInvoiceLine();
		invoiceLine.setID("1");

		QuantityModel quantity = invoiceLine.getInvoicedQuantity();
		quantity.setUnitCode("NIU");
		quantity.setValue(new BigDecimal("2000"));

		invoiceLine.setLineExtensionAmount(new BigDecimal("149491.53"));

		PricingReferenceModel pricingReference = invoiceLine.getPricingReference();

		PriceModel price = pricingReference.addAlternativeConditionPrice();
		price.setPriceAmount(new BigDecimal("98.00"));
		price.setPriceTypeCode("01");

		TaxTotalModel taxTotalInvoiceLine = invoiceLine.addTaxTotal();
		taxTotalInvoiceLine.setTaxAmount(new BigDecimal("26908.47"));

		TaxSubtotalModel taxSubtotalInvoiceLine = taxTotalInvoiceLine.addTaxSubtotal();
		taxSubtotalInvoiceLine.setTaxAmount(new BigDecimal("26908.47"));

		TaxCategoryModel taxCategoryInvoiceLine = taxSubtotalInvoiceLine.getTaxCategory();
		taxCategoryInvoiceLine.setTaxExemptionReasonCode("10");

		TaxSchemeModel taxSchemeInvoiceLine = taxCategoryInvoiceLine.getTaxScheme();
		taxSchemeInvoiceLine.setID("1000");
		taxSchemeInvoiceLine.setName("IGV");
		taxSchemeInvoiceLine.setTaxTypeCode("VAT");

		ItemModel item = invoiceLine.getItem();
		item.getDescription().add("Grabadora LG Externo Modelo: GE20LU10");

		ItemIdentificationModel itemIdentification = item.getSellersItemIdentification();
		itemIdentification.setID("GLG199");
		invoiceLine.getPrice().setPriceAmount(new BigDecimal("83.05"));

		// add extension content type

		UBLExtensionsModel e = invoice.getUBLExtensions();
		UBLExtensionModel ee = e.addUblExtension();
		ExtensionContentModel cc = ee.getExtensionContent();

		// additional information sunat
		AdditionalInformationTypeSunatAgg additionalInformation = new AdditionalInformationTypeSunatAgg();
		IDType idAMonetaryTotal = new IDType();
		idAMonetaryTotal.setValue("1000");
		PayableAmountType pa = new PayableAmountType();
		pa.setCurrencyID("PEN");
		pa.setValue(new BigDecimal(348199.15));
		AdditionalMonetaryTotalType amtt = new AdditionalMonetaryTotalType();
		amtt.setID(idAMonetaryTotal);
		amtt.setPayableAmount(pa);
		additionalInformation.getAdditionalMonetaryTotal().add(amtt);

		IDType idAMonetaryTotal1 = new IDType();
		idAMonetaryTotal1.setValue("2000");
		PayableAmountType pa1 = new PayableAmountType();
		pa1.setCurrencyID("PEN");
		pa1.setValue(new BigDecimal(12350.00));
		AdditionalMonetaryTotalType amtt1 = new AdditionalMonetaryTotalType();
		amtt1.setID(idAMonetaryTotal1);
		amtt1.setPayableAmount(pa1);
		additionalInformation.getAdditionalMonetaryTotal().add(amtt1);

		ObjectFactory FACTORIA = new ObjectFactory();
		JAXBContext context = JAXBContext.newInstance(ObjectFactory.class);
		Marshaller marshallerElement = context.createMarshaller();

		JAXBElement<AdditionalInformationTypeSunatAgg> jeAits = FACTORIA
				.createAdditionalInformation(additionalInformation);
		DOMResult res = new DOMResult();
		marshallerElement.marshal(jeAits, res);
		Element elem = ((Document) res.getNode()).getDocumentElement();

		cc.setAny(elem);

		UBLExtensionsModel e1 = invoice.getUBLExtensions();
		UBLExtensionModel ee1 = e1.addUblExtension();
		ExtensionContentModel cc1 = ee1.getExtensionContent();
		Document document = UblSignature.ublSignatureGenerate(organization);
		Element element = document.getDocumentElement();
		cc1.setAny(element);

		// end demo additional information sunat
		commit();

		Set<UblProvider> providers = session.getAllProviders(UblProvider.class);
		for (UblProvider provider : providers) {
			Document xml = provider.getDocument(organization, invoice);
			InvoiceType invoiceType = UBL21Reader.invoice().read(xml);
			IErrorList resourceErrorGroup = UBL21Validator.invoice().validate(invoiceType);

			UBL21Writer.invoice().write(invoiceType, new File("/home/lxpary/carlos.xml"));
			assertThat(xml, is(notNullValue()));
			assertThat(resourceErrorGroup.getAllErrors().getSize(), is(0));
		}
	}

	private KeyPair generateKeypair() throws NoSuchAlgorithmException {
		return KeyPairGenerator.getInstance("RSA").generateKeyPair();
	}

	// @Test
	// public void persistUser() {
	// OrganizationModel organization =
	// organizationManager.createOrganization("original");
	// OpenfactSession session = organizationManager.getSession();
	// UserModel user = session.users().addUser(organization, "user");
	// user.setFirstName("first-name");
	// user.setLastName("last-name");
	// user.setEmail("email");
	// assertNotNull(user.getCreatedTimestamp());
	// // test that timestamp is current with 10s tollerance
	// Assert.assertTrue((System.currentTimeMillis() -
	// user.getCreatedTimestamp()) < 10000);
	//
	// user.addRequiredAction(RequiredAction.CONFIGURE_TOTP);
	// user.addRequiredAction(RequiredAction.UPDATE_PASSWORD);
	//
	// OrganizationModel searchOrganization =
	// organizationManager.getOrganization(organization.getId());
	// UserModel persisted = session.users().getUserByUsername("user",
	// searchOrganization);
	//
	// assertEquals(user, persisted);
	//
	// searchOrganization =
	// organizationManager.getOrganization(organization.getId());
	// UserModel persisted2 = session.users().getUserById(user.getId(),
	// searchOrganization);
	// assertEquals(user, persisted2);
	//
	// Map<String, String> attributes = new HashMap<String, String>();
	// attributes.put(UserModel.LAST_NAME, "last-name");
	// List<UserModel> search = session.users().searchForUser(attributes,
	// organization);
	// Assert.assertEquals(search.size(), 1);
	// Assert.assertEquals(search.get(0).getUsername(), "user");
	//
	// attributes.clear();
	// attributes.put(UserModel.EMAIL, "email");
	// search = session.users().searchForUser(attributes, organization);
	// Assert.assertEquals(search.size(), 1);
	// Assert.assertEquals(search.get(0).getUsername(), "user");
	//
	// attributes.clear();
	// attributes.put(UserModel.LAST_NAME, "last-name");
	// attributes.put(UserModel.EMAIL, "email");
	// search = session.users().searchForUser(attributes, organization);
	// Assert.assertEquals(search.size(), 1);
	// Assert.assertEquals(search.get(0).getUsername(), "user");
	// }
	//
	// @Test
	// public void webOriginSetTest() {
	// OrganizationModel organization =
	// organizationManager.createOrganization("original");
	// ClientModel client = organization.addClient("user");
	//
	// Assert.assertTrue(client.getWebOrigins().isEmpty());
	//
	// client.addWebOrigin("origin-1");
	// Assert.assertEquals(1, client.getWebOrigins().size());
	//
	// client.addWebOrigin("origin-2");
	// Assert.assertEquals(2, client.getWebOrigins().size());
	//
	// client.removeWebOrigin("origin-2");
	// Assert.assertEquals(1, client.getWebOrigins().size());
	//
	// client.removeWebOrigin("origin-1");
	// Assert.assertTrue(client.getWebOrigins().isEmpty());
	//
	// client = organization.addClient("oauthclient2");
	//
	// Assert.assertTrue(client.getWebOrigins().isEmpty());
	//
	// client.addWebOrigin("origin-1");
	// Assert.assertEquals(1, client.getWebOrigins().size());
	//
	// client.addWebOrigin("origin-2");
	// Assert.assertEquals(2, client.getWebOrigins().size());
	//
	// client.removeWebOrigin("origin-2");
	// Assert.assertEquals(1, client.getWebOrigins().size());
	//
	// client.removeWebOrigin("origin-1");
	// Assert.assertTrue(client.getWebOrigins().isEmpty());
	//
	// }
	//
	// @Test
	// public void testUserRequiredActions() throws Exception {
	// OrganizationModel organization =
	// organizationManager.createOrganization("original");
	// UserModel user = session.users().addUser(organization, "user");
	//
	// Assert.assertTrue(user.getRequiredActions().isEmpty());
	//
	// user.addRequiredAction(RequiredAction.CONFIGURE_TOTP);
	// String id = organization.getId();
	// commit();
	// organization = organizationManager.getOrganization(id);
	// user = session.users().getUserByUsername("user", organization);
	//
	// Assert.assertEquals(1, user.getRequiredActions().size());
	// Assert.assertTrue(user.getRequiredActions().contains(RequiredAction.CONFIGURE_TOTP.name()));
	//
	// user.addRequiredAction(RequiredAction.CONFIGURE_TOTP);
	// user = session.users().getUserByUsername("user", organization);
	//
	// Assert.assertEquals(1, user.getRequiredActions().size());
	// Assert.assertTrue(user.getRequiredActions().contains(RequiredAction.CONFIGURE_TOTP.name()));
	//
	// user.addRequiredAction(RequiredAction.VERIFY_EMAIL.name());
	// user = session.users().getUserByUsername("user", organization);
	//
	// Assert.assertEquals(2, user.getRequiredActions().size());
	// Assert.assertTrue(user.getRequiredActions().contains(RequiredAction.CONFIGURE_TOTP.name()));
	// Assert.assertTrue(user.getRequiredActions().contains(RequiredAction.VERIFY_EMAIL.name()));
	//
	// user.removeRequiredAction(RequiredAction.CONFIGURE_TOTP.name());
	// user = session.users().getUserByUsername("user", organization);
	//
	// Assert.assertEquals(1, user.getRequiredActions().size());
	// Assert.assertTrue(user.getRequiredActions().contains(RequiredAction.VERIFY_EMAIL.name()));
	//
	// user.removeRequiredAction(RequiredAction.VERIFY_EMAIL.name());
	// user = session.users().getUserByUsername("user", organization);
	//
	// Assert.assertTrue(user.getRequiredActions().isEmpty());
	// }
	//
	// @Test
	// public void testUserMultipleAttributes() throws Exception {
	// OrganizationModel organization =
	// organizationManager.createOrganization("original");
	// UserModel user = session.users().addUser(organization, "user");
	// UserModel userNoAttrs = session.users().addUser(organization,
	// "user-noattrs");
	//
	// user.setSingleAttribute("key1", "value1");
	// List<String> attrVals = new ArrayList<>(Arrays.asList( "val21", "val22"
	// ));
	// user.setAttribute("key2", attrVals);
	//
	// commit();
	//
	// // Test read attributes
	// organization = organizationManager.getOrganizationByName("original");
	// user = session.users().getUserByUsername("user", organization);
	//
	// attrVals = user.getAttribute("key1");
	// Assert.assertEquals(1, attrVals.size());
	// Assert.assertEquals("value1", attrVals.get(0));
	// Assert.assertEquals("value1", user.getFirstAttribute("key1"));
	//
	// attrVals = user.getAttribute("key2");
	// Assert.assertEquals(2, attrVals.size());
	// Assert.assertTrue(attrVals.contains("val21"));
	// Assert.assertTrue(attrVals.contains("val22"));
	//
	// attrVals = user.getAttribute("key3");
	// Assert.assertTrue(attrVals.isEmpty());
	// Assert.assertNull(user.getFirstAttribute("key3"));
	//
	// Map<String, List<String>> allAttrVals = user.getAttributes();
	// Assert.assertEquals(2, allAttrVals.size());
	// Assert.assertEquals(allAttrVals.get("key1"), user.getAttribute("key1"));
	// Assert.assertEquals(allAttrVals.get("key2"), user.getAttribute("key2"));
	//
	// // Test remove and rewrite attribute
	// user.removeAttribute("key1");
	// user.setSingleAttribute("key2", "val23");
	//
	// commit();
	//
	// organization = organizationManager.getOrganizationByName("original");
	// user = session.users().getUserByUsername("user", organization);
	// Assert.assertNull(user.getFirstAttribute("key1"));
	// attrVals = user.getAttribute("key2");
	// Assert.assertEquals(1, attrVals.size());
	// Assert.assertEquals("val23", attrVals.get(0));
	// }
	//
	// // OPENFACT-3494
	// @Test
	// public void testUpdateUserAttribute() throws Exception {
	// OrganizationModel organization =
	// organizationManager.createOrganization("original");
	// UserModel user = session.users().addUser(organization, "user");
	//
	// user.setSingleAttribute("key1", "value1");
	//
	// commit();
	//
	// organization = organizationManager.getOrganizationByName("original");
	// user = session.users().getUserByUsername("user", organization);
	//
	// // Update attribute
	// List<String> attrVals = new ArrayList<>(Arrays.asList( "val2" ));
	// user.setAttribute("key1", attrVals);
	// Map<String, List<String>> allAttrVals = user.getAttributes();
	//
	// // Ensure same transaction is able to see updated value
	// Assert.assertEquals(1, allAttrVals.size());
	// Assert.assertEquals(allAttrVals.get("key1"), Arrays.asList("val2"));
	//
	// commit();
	// }
	//
	// @Test
	// public void testSearchByString() {
	// OrganizationModel organization =
	// organizationManager.createOrganization("original");
	// UserModel user1 = session.users().addUser(organization, "user1");
	//
	// commit();
	// organization = session.organizations().getOrganizationByName("original");
	// List<UserModel> users = session.users().searchForUser("user",
	// organization, 0, 7);
	// Assert.assertTrue(users.contains(user1));
	// }
	//
	// @Test
	// public void testSearchByUserAttribute() throws Exception {
	// OrganizationModel organization =
	// organizationManager.createOrganization("original");
	// UserModel user1 = session.users().addUser(organization, "user1");
	// UserModel user2 = session.users().addUser(organization, "user2");
	// UserModel user3 = session.users().addUser(organization, "user3");
	//
	// user1.setSingleAttribute("key1", "value1");
	// user1.setSingleAttribute("key2", "value21");
	//
	// user2.setSingleAttribute("key1", "value1");
	// user2.setSingleAttribute("key2", "value22");
	//
	// user3.setSingleAttribute("key2", "value21");
	//
	// commit();
	// organization = session.organizations().getOrganizationByName("original");
	//
	// List<UserModel> users =
	// session.users().searchForUserByUserAttribute("key1", "value1",
	// organization);
	// Assert.assertEquals(2, users.size());
	// Assert.assertTrue(users.contains(user1));
	// Assert.assertTrue(users.contains(user2));
	//
	// users = session.users().searchForUserByUserAttribute("key2", "value21",
	// organization);
	// Assert.assertEquals(2, users.size());
	// Assert.assertTrue(users.contains(user1));
	// Assert.assertTrue(users.contains(user3));
	//
	// users = session.users().searchForUserByUserAttribute("key2", "value22",
	// organization);
	// Assert.assertEquals(1, users.size());
	// Assert.assertTrue(users.contains(user2));
	//
	// users = session.users().searchForUserByUserAttribute("key3", "value3",
	// organization);
	// Assert.assertEquals(0, users.size());
	// }
	//
	// @Test
	// public void testServiceAccountLink() throws Exception {
	// OrganizationModel organization =
	// organizationManager.createOrganization("original");
	// ClientModel client = organization.addClient("foo");
	//
	// UserModel user1 = session.users().addUser(organization, "user1");
	// user1.setFirstName("John");
	// user1.setLastName("Doe");
	//
	// UserModel user2 = session.users().addUser(organization, "user2");
	// user2.setFirstName("John");
	// user2.setLastName("Doe");
	//
	// // Search
	// Assert.assertNull(session.users().getServiceAccount(client));
	// List<UserModel> users = session.users().searchForUser("John Doe",
	// organization);
	// Assert.assertEquals(2, users.size());
	// Assert.assertTrue(users.contains(user1));
	// Assert.assertTrue(users.contains(user2));
	//
	// // Link service account
	// user1.setServiceAccountClientLink(client.getId());
	//
	// commit();
	//
	// // Search and assert service account user not found
	// organization = organizationManager.getOrganizationByName("original");
	// client = organization.getClientByClientId("foo");
	// UserModel searched = session.users().getServiceAccount(client);
	// Assert.assertEquals(searched, user1);
	// users = session.users().searchForUser("John Doe", organization);
	// Assert.assertEquals(1, users.size());
	// Assert.assertFalse(users.contains(user1));
	// Assert.assertTrue(users.contains(user2));
	//
	// users = session.users().getUsers(organization, false);
	// Assert.assertEquals(1, users.size());
	// Assert.assertFalse(users.contains(user1));
	// Assert.assertTrue(users.contains(user2));
	//
	// users = session.users().getUsers(organization, true);
	// Assert.assertEquals(2, users.size());
	// Assert.assertTrue(users.contains(user1));
	// Assert.assertTrue(users.contains(user2));
	//
	// Assert.assertEquals(2, session.users().getUsersCount(organization));
	//
	// // Remove client
	// new ClientManager(organizationManager).removeClient(organization,
	// client);
	// commit();
	//
	// // Assert service account removed as well
	// organization = organizationManager.getOrganizationByName("original");
	// Assert.assertNull(session.users().getUserByUsername("user1",
	// organization));
	// }
	//
	// @Test
	// public void testGrantToAll() {
	// OrganizationModel organization1 =
	// organizationManager.createOrganization("organization1");
	// RoleModel role1 = organization1.addRole("role1");
	// UserModel user1 =
	// organizationManager.getSession().users().addUser(organization1, "user1");
	// UserModel user2 =
	// organizationManager.getSession().users().addUser(organization1, "user2");
	//
	// OrganizationModel organization2 =
	// organizationManager.createOrganization("organization2");
	// UserModel organization2User1 =
	// organizationManager.getSession().users().addUser(organization2, "user1");
	//
	// commit();
	//
	// organization1 =
	// organizationManager.getOrganizationByName("organization1");
	// role1 = organization1.getRole("role1");
	// organizationManager.getSession().users().grantToAllUsers(organization1,
	// role1);
	//
	// commit();
	//
	// organization1 =
	// organizationManager.getOrganizationByName("organization1");
	// role1 = organization1.getRole("role1");
	// user1 =
	// organizationManager.getSession().users().getUserByUsername("user1",
	// organization1);
	// user2 =
	// organizationManager.getSession().users().getUserByUsername("user2",
	// organization1);
	// Assert.assertTrue(user1.hasRole(role1));
	// Assert.assertTrue(user2.hasRole(role1));
	//
	// organization2 =
	// organizationManager.getOrganizationByName("organization2");
	// organization2User1 =
	// organizationManager.getSession().users().getUserByUsername("user1",
	// organization2);
	// Assert.assertFalse(organization2User1.hasRole(role1));
	// }
	//
	// public static void assertEquals(UserModel expected, UserModel actual) {
	// Assert.assertEquals(expected.getUsername(), actual.getUsername());
	// Assert.assertEquals(expected.getCreatedTimestamp(),
	// actual.getCreatedTimestamp());
	// Assert.assertEquals(expected.getFirstName(), actual.getFirstName());
	// Assert.assertEquals(expected.getLastName(), actual.getLastName());
	//
	// String[] expectedRequiredActions =
	// expected.getRequiredActions().toArray(new
	// String[expected.getRequiredActions().size()]);
	// Arrays.sort(expectedRequiredActions);
	// String[] actualRequiredActions = actual.getRequiredActions().toArray(new
	// String[actual.getRequiredActions().size()]);
	// Arrays.sort(actualRequiredActions);
	//
	// Assert.assertArrayEquals(expectedRequiredActions, actualRequiredActions);
	// }

}
