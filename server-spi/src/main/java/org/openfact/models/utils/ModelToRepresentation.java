/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openfact.models.utils;

import org.apache.commons.lang.ArrayUtils;
import org.openfact.common.converts.DocumentUtils;
import org.openfact.common.util.MultivaluedHashMap;
import org.openfact.component.ComponentModel;
import org.openfact.events.Event;
import org.openfact.events.admin.AdminEvent;
import org.openfact.events.admin.AuthDetails;
import org.openfact.models.ModelException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.ubl.SendEventModel;
import org.openfact.models.ubl.common.*;
import org.openfact.provider.ProviderConfigProperty;
import org.openfact.representations.idm.*;
import org.openfact.representations.idm.ubl.CreditNoteRepresentation;
import org.openfact.representations.idm.ubl.DebitNoteRepresentation;
import org.openfact.representations.idm.ubl.InvoiceRepresentation;
import org.openfact.representations.idm.ubl.SendEventRepresentation;
import org.openfact.representations.idm.ubl.common.*;
import org.w3c.dom.Document;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.util.*;

public class ModelToRepresentation {

	public static OrganizationRepresentation toRepresentation(OrganizationModel organization, boolean internal) {
		/**
		 * General information
		 */
		OrganizationRepresentation rep = new OrganizationRepresentation();
		rep.setId(organization.getId());
		rep.setOrganization(organization.getName());
		rep.setDescription(organization.getDescription());
		rep.setEnabled(organization.isEnabled());
		rep.setCreatedTimestamp(organization.getCreatedTimestamp());

		rep.setAdditionalAccountId(organization.getAdditionalAccountId());
		rep.setAssignedIdentificationId(organization.getAssignedIdentificationId());
		rep.setRegistrationName(organization.getRegistrationName());
		rep.setSupplierName(organization.getSupplierName());

		/**
		 * Postal address
		 */
		PostalAddressRepresentation postalAddressRep = new PostalAddressRepresentation();
		postalAddressRep.setStreetName(organization.getStreetName());
		postalAddressRep.setCitySubdivisionName(organization.getCitySubdivisionName());
		postalAddressRep.setCityName(organization.getCityName());
		postalAddressRep.setCountrySubentity(organization.getCountrySubentity());
		postalAddressRep.setDistrict(organization.getDistrict());
		postalAddressRep.setCountryIdentificationCode(organization.getCountryIdentificationCode());
		rep.setPostalAddress(postalAddressRep);

		/**
		 * Themes
		 */
		rep.setEmailTheme(organization.getEmailTheme());

		/**
		 * Internationalization
		 */
		rep.setInternationalizationEnabled(organization.isInternationalizationEnabled());
		if (organization.getSupportedLocales() != null) {
			rep.setSupportedLocales(new HashSet<String>());
			rep.getSupportedLocales().addAll(organization.getSupportedLocales());
		}
		rep.setDefaultLocale(organization.getDefaultLocale());

		/**
		 * Tasks schedule
		 */
		rep.setTaskFirstTime(organization.getTaskFirstTime());
		rep.setTaskDelay(organization.getTaskDelay());
		rep.setTasksEnabled(organization.isTasksEnabled());

		/**
		 * Currencies
		 */
		rep.setDefaultCurrency(organization.getDefaultCurrency());
		if (organization.getSupportedCurrencies() != null) {
			rep.setSupportedCurrencies(new HashSet<String>());
			rep.getSupportedCurrencies().addAll(organization.getSupportedCurrencies());
		}

		/**
		 * Events
		 */
		rep.setEventsEnabled(organization.isEventsEnabled());
		if (organization.getEventsExpiration() != 0) {
			rep.setEventsExpiration(organization.getEventsExpiration());
		}
		if (organization.getEventsListeners() != null) {
			rep.setEventsListeners(new LinkedList<String>(organization.getEventsListeners()));
		}
		if (organization.getEnabledEventTypes() != null) {
			rep.setEnabledEventTypes(new LinkedList<String>(organization.getEnabledEventTypes()));
		}
		rep.setAdminEventsEnabled(organization.isAdminEventsEnabled());
		rep.setAdminEventsDetailsEnabled(organization.isAdminEventsDetailsEnabled());

		/**
		 * Smtp server
		 */
		rep.setSmtpServer(new HashMap<>(organization.getSmtpConfig()));

		/**
		 * Attributes
		 */
		rep.setAttributes(new HashMap<>(organization.getAttributes()));

		if (internal) {

		}

		return rep;
	}

	public static InvoiceRepresentation toRepresentation(InvoiceModel model, boolean includeXml) {
		InvoiceRepresentation rep = new InvoiceRepresentation();

		rep.setId(model.getId());
		rep.setUblVersionID(model.getUBLVersionID());
		rep.setCustomizationID(model.getCustomizationID());
		if (model.getSignature() != null) {
			for (SignatureModel item : model.getSignature()) {
				rep.addSignature(toRepresentation(item));
			}
		}

		rep.setIssueDateTime(model.getIssueDateTime());
		if (model.getUBLExtensions() != null) {
			rep.setUblExtensions(toRepresentation(model.getUBLExtensions()));
		}
		if (model.getAccountingSupplierParty() != null) {
			rep.setAccountingSupplierParty(toRepresentation(model.getAccountingSupplierParty()));
		}

		rep.setIdUbl(model.getID());
		rep.setInvoiceTypeCode(model.getInvoiceTypeCode());

		if (model.getAccountingCustomerParty() != null) {
			rep.setAccountingCustomerParty(toRepresentation(model.getAccountingCustomerParty()));
		}
		if (model.getInvoiceLine() != null) {
			for (InvoiceLineModel item : model.getInvoiceLine()) {
				rep.addInvoiceLine(toRepresentation(item));
			}
		}
		if (model.getTaxTotal() != null) {
			for (TaxTotalModel item : model.getTaxTotal()) {
				rep.addTaxTotal(toRepresentation(item));
			}
		}
		if (model.getLegalMonetaryTotal() != null) {
			rep.setLegalMonetaryTotal(toRepresentation(model.getLegalMonetaryTotal()));
		}
		rep.setDocumentCurrencyCode(model.getDocumentCurrencyCode());

		if (includeXml) {
			try {
				Document document = DocumentUtils.byteToDocument(ArrayUtils.toPrimitive(model.getXmlDocument()));
				rep.setXml(DocumentUtils.getDocumentToString(document));
			} catch (Exception e) {
				throw new ModelException(e.getMessage());
			}
		}
		return rep;
	}

	public static CreditNoteRepresentation toRepresentation(CreditNoteModel model, boolean includeXml) {
		CreditNoteRepresentation rep = new CreditNoteRepresentation();

		rep.setId(model.getId());
		rep.setUblVersionID(model.getUBLVersionID());
		rep.setCustomizationID(model.getCustomizationID());
		if (model.getSignature() != null) {
			for (SignatureModel item : model.getSignature()) {
				rep.addSignature(toRepresentation(item));
			}
		}

		rep.setIssueDateTime(model.getIssueDateTime());
		if (model.getUBLExtensions() != null) {
			rep.setUblExtensions(toRepresentation(model.getUBLExtensions()));
		}
		if (model.getAccountingSupplierParty() != null) {
			rep.setAccountingSupplierParty(toRepresentation(model.getAccountingSupplierParty()));
		}
		if (model.getDiscrepancyResponse() != null) {
			for (ResponseModel item : model.getDiscrepancyResponse()) {
				rep.addDiscrepancyResponse(toRepresentation(item));
			}
		}

		rep.setIdUbl(model.getID());

		if (model.getAccountingCustomerParty() != null) {
			rep.setAccountingCustomerParty(toRepresentation(model.getAccountingCustomerParty()));
		}

		if (model.getCreditNoteLine() != null) {
			for (CreditNoteLineModel item : model.getCreditNoteLine()) {
				rep.addCreditNoteLine(toRepresentation(item));
			}
		}
		if (model.getTaxTotal() != null) {
			for (TaxTotalModel item : model.getTaxTotal()) {
				rep.addTaxTotal(toRepresentation(item));
			}
		}
		if (model.getLegalMonetaryTotal() != null) {
			rep.setLegalMonetaryTotal(toRepresentation(model.getLegalMonetaryTotal()));
		}
		rep.setDocumentCurrencyCode(model.getDocumentCurrencyCode());
		if (model.getBillingReference() != null) {
			for (BillingReferenceModel item : model.getBillingReference()) {
				rep.addBillingReference(toRepresentation(item));
			}
		}
		if (model.getDespatchDocumentReference() != null) {
			for (DocumentReferenceModel item : model.getDespatchDocumentReference()) {
				rep.addDespatchDocumentReference(toRepresentation(item));
			}
		}

		if (includeXml) {
			try {
				Document document = DocumentUtils.byteToDocument(ArrayUtils.toPrimitive(model.getXmlDocument()));
				rep.setXml(DocumentUtils.getDocumentToString(document));
			} catch (Exception e) {
				throw new ModelException(e.getMessage());
			}
		}
		return rep;
	}

	public static DebitNoteRepresentation toRepresentation(DebitNoteModel model, boolean includeXml) {
		DebitNoteRepresentation rep = new DebitNoteRepresentation();

		rep.setId(model.getId());
		rep.setUblVersionID(model.getUBLVersionID());
		rep.setCustomizationID(model.getCustomizationID());
		if (model.getSignature() != null) {
			for (SignatureModel item : model.getSignature()) {
				rep.addSignature(toRepresentation(item));
			}
		}

		rep.setIssueDateTime(model.getIssueDateTime());
		if (model.getUBLExtensions() != null) {
			rep.setUblExtensions(toRepresentation(model.getUBLExtensions()));
		}
		if (model.getAccountingSupplierParty() != null) {
			rep.setAccountingSupplierParty(toRepresentation(model.getAccountingSupplierParty()));
		}
		if (model.getDiscrepancyResponse() != null) {
			for (ResponseModel item : model.getDiscrepancyResponse()) {
				rep.addDiscrepancyResponse(toRepresentation(item));
			}
		}

		rep.setIdUbl(model.getID());

		if (model.getAccountingCustomerParty() != null) {
			rep.setAccountingCustomerParty(toRepresentation(model.getAccountingCustomerParty()));
		}

		if (model.getDebitNoteLine() != null) {
			for (DebitNoteLineModel item : model.getDebitNoteLine()) {
				rep.addDebitNoteLine(toRepresentation(item));
			}
		}
		if (model.getTaxTotal() != null) {
			for (TaxTotalModel item : model.getTaxTotal()) {
				rep.addTaxTotal(toRepresentation(item));
			}
		}
		if (model.getRequestedMonetaryTotal() != null) {
			rep.setRequestedMonetaryTotal(toRepresentation(model.getRequestedMonetaryTotal()));
		}
		rep.setDocumentCurrencyCode(model.getDocumentCurrencyCode());
		if (model.getBillingReference() != null) {
			for (BillingReferenceModel item : model.getBillingReference()) {
				rep.addBillingReference(toRepresentation(item));
			}
		}
		if (model.getDespatchDocumentReference() != null) {
			for (DocumentReferenceModel item : model.getDespatchDocumentReference()) {
				rep.addDespatchDocumentReference(toRepresentation(item));
			}
		}

		if (includeXml) {
			try {
				Document document = DocumentUtils.byteToDocument(ArrayUtils.toPrimitive(model.getXmlDocument()));
				rep.setXml(DocumentUtils.getDocumentToString(document));
			} catch (Exception e) {
				throw new ModelException(e.getMessage());
			}
		}

		return rep;
	}

	public static InvoiceLineRepresentation toRepresentation(InvoiceLineModel model) {
		InvoiceLineRepresentation rep = new InvoiceLineRepresentation();
		if (model.getInvoicedQuantity() != null) {
			rep.setInvoicedQuantity(toRepresentation(model.getInvoicedQuantity()));
		}
		if (model.getItem() != null) {
			rep.setItem(toRepresentation(model.getItem()));
		}
		if (model.getPrice() != null) {
			rep.setPrice(toRepresentation(model.getPrice()));
		}
		if (model.getPricingReference() != null) {
			rep.setPricingReference(toRepresentation(model.getPricingReference()));
		}
		if (model.getTaxTotal() != null) {
			for (TaxTotalModel item : model.getTaxTotal()) {
				rep.addTaxTotal(toRepresentation(item));
			}
		}
		rep.setLineExtensionAmount(model.getLineExtensionAmount());
		rep.setIdUbl(model.getID());
		if (model.getAllowanceCharge() != null) {
			for (AllowanceChargeModel item : model.getAllowanceCharge()) {
				rep.addAllowanceCharge(toRepresentation(item));
			}
		}
		return rep;
	}

	public static CreditNoteLineRepresentation toRepresentation(CreditNoteLineModel model) {
		CreditNoteLineRepresentation rep = new CreditNoteLineRepresentation();
		rep.setIdUbl(model.getID());
		if (model.getCreditedQuantity() != null) {
			rep.setCreditedQuantity(toRepresentation(model.getCreditedQuantity()));
		}
		if (model.getItem() != null) {
			rep.setItem(toRepresentation(model.getItem()));
		}
		if (model.getPrice() != null) {
			rep.setPrice(toRepresentation(model.getPrice()));
		}
		if (model.getPricingReference() != null) {
			rep.setPricingReference(toRepresentation(model.getPricingReference()));
		}
		if (model.getTaxTotal() != null) {
			for (TaxTotalModel item : model.getTaxTotal()) {
				rep.addTaxTotal(toRepresentation(item));
			}
		}
		rep.setLineExtensionAmount(model.getLineExtensionAmount());
		return rep;
	}

	public static DebitNoteLineRepresentation toRepresentation(DebitNoteLineModel model) {
		DebitNoteLineRepresentation rep = new DebitNoteLineRepresentation();
		rep.setIdUbl(model.getID());
		if (model.getDebitedQuantity() != null) {
			rep.setDebitedQuantity(toRepresentation(model.getDebitedQuantity()));
		}
		if (model.getItem() != null) {
			rep.setItem(toRepresentation(model.getItem()));
		}
		if (model.getPrice() != null) {
			rep.setPrice(toRepresentation(model.getPrice()));
		}
		if (model.getPricingReference() != null) {
			rep.setPricingReference(toRepresentation(model.getPricingReference()));
		}
		if (model.getTaxTotal() != null) {
			for (TaxTotalModel item : model.getTaxTotal()) {
				rep.addTaxTotal(toRepresentation(item));
			}
		}
		rep.setLineExtensionAmount(model.getLineExtensionAmount());
		return rep;
	}

	public static BillingReferenceRepresentation toRepresentation(BillingReferenceModel model) {
		BillingReferenceRepresentation rep = new BillingReferenceRepresentation();
		if (model.getInvoiceDocumentReference() != null) {
			rep.setInvoiceDocumentReference(toRepresentation(model.getInvoiceDocumentReference()));
		}
		return rep;
	}

	public static DocumentReferenceRepresentation toRepresentation(DocumentReferenceModel model) {
		DocumentReferenceRepresentation rep = new DocumentReferenceRepresentation();
		rep.setDocumentCodeRepresentation(model.getDocumentCode());
		return rep;
	}

	public static ResponseRepresentation toRepresentation(ResponseModel model) {
		ResponseRepresentation rep = new ResponseRepresentation();
		rep.setReferenceID(model.getReferenceID());
		rep.setResponseCode(model.getResponseCode());
		if (model.getDescription() != null) {
			for (String item : model.getDescription()) {
				rep.addDescription(item);
			}
		}
		return rep;
	}

	public static MonetaryTotalRepresentation toRepresentation(MonetaryTotalModel model) {
		MonetaryTotalRepresentation rep = new MonetaryTotalRepresentation();
		rep.setChargeTotalAmount(model.getChargeTotalAmount());
		rep.setPayableAmount(model.getPayableAmount());
		rep.setAllowanceTotalAmount(model.getAllowanceTotalAmount());
		return rep;
	}

	public static AllowanceChargeRepresentation toRepresentation(AllowanceChargeModel model) {
		AllowanceChargeRepresentation rep = new AllowanceChargeRepresentation();
		rep.setAmount(model.getAmount());
		rep.setChargeIndicator(model.getChargeIndicator());
		return rep;
	}

	public static PricingReferenceRepresentation toRepresentation(PricingReferenceModel model) {
		PricingReferenceRepresentation rep = new PricingReferenceRepresentation();
		if (model.getAlternativeConditionPrice() != null) {
			for (PriceModel item : model.getAlternativeConditionPrice()) {
				rep.addAlternativeConditionPrice(toRepresentation(item));
			}
		}
		return rep;
	}

	public static PriceRepresentation toRepresentation(PriceModel model) {
		PriceRepresentation rep = new PriceRepresentation();
		rep.setPriceAmount(model.getPriceAmount());
		rep.setPriceTypeCode(model.getPriceTypeCode());

		return rep;
	}

	public static ItemRepresentation toRepresentation(ItemModel model) {
		ItemRepresentation rep = new ItemRepresentation();
		for (String item : model.getDescription()) {
			rep.addDescription(item);
		}
		if (model.getSellersItemIdentification() != null) {
			rep.setSellersItemIdentification(toRepresentation(model.getSellersItemIdentification()));
		}
		return rep;
	}

	public static ItemIdentificationRepresentation toRepresentation(ItemIdentificationModel model) {
		ItemIdentificationRepresentation rep = new ItemIdentificationRepresentation();
		rep.setIdUbl(model.getID());
		return rep;
	}

	public static TaxTotalRepresentation toRepresentation(TaxTotalModel model) {
		TaxTotalRepresentation rep = new TaxTotalRepresentation();
		rep.setTaxAmount(model.getTaxAmount());
		if (model.getTaxSubtotal() != null) {
			for (TaxSubtotalModel item : model.getTaxSubtotal()) {
				rep.addTaxSubtotal(toRepresentation(item));
			}
		}
		return rep;
	}

	public static TaxSubtotalRepresentation toRepresentation(TaxSubtotalModel model) {
		TaxSubtotalRepresentation rep = new TaxSubtotalRepresentation();
		rep.setTaxAmount(model.getTaxAmount());
		rep.setTaxCategory(toRepresentation(model.getTaxCategory()));
		return rep;
	}

	public static TaxCategoryRepresentation toRepresentation(TaxCategoryModel model) {
		TaxCategoryRepresentation rep = new TaxCategoryRepresentation();
		rep.setTaxExemptionReasonCode(model.getTaxExemptionReasonCode());
		if (model.getTaxScheme() != null) {
			rep.setTaxScheme(toRepresentation(model.getTaxScheme()));
		}
		rep.setTierRange(model.getTierRange());
		return rep;
	}

	public static TaxSchemeRepresentation toRepresentation(TaxSchemeModel model) {
		TaxSchemeRepresentation rep = new TaxSchemeRepresentation();
		rep.setIdUbl(model.getID());
		rep.setName(model.getName());
		rep.setTaxCodeType(model.getTaxCode());
		return rep;
	}

	public static CustomerPartyRepresentation toRepresentation(CustomerPartyModel model) {
		CustomerPartyRepresentation rep = new CustomerPartyRepresentation();
		rep.setCustomerAssignedAccountID(model.getCustomerAssignedAccountID());
		for (String item : model.getAdditionalAccountID()) {
			rep.addAdditionalAccountID(item);
		}
		if (model.getParty() != null) {
			rep.setParty(toRepresentation(model.getParty()));
		}
		return rep;
	}

	public static SupplierPartyRepresentation toRepresentation(SupplierPartyModel model) {
		SupplierPartyRepresentation rep = new SupplierPartyRepresentation();
		if (model.getParty() != null) {
			rep.setParty(toRepresentation(model.getParty()));
		}
		rep.setCustomerAssignedAccountID(model.getCustomerAssignedAccountID());
		for (String item : model.getAdditionalAccountID()) {
			rep.addAdditionalAccountID(item);
		}
		return rep;
	}

	public static PartyRepresentation toRepresentation(PartyModel model) {
		PartyRepresentation rep = new PartyRepresentation();
		if (model.getPostalAddress() != null) {
			rep.setPostalAddress(toRepresentation(model.getPostalAddress()));
		}
		for (PartyLegalModel item : model.getPartyLegalEntity()) {
			rep.addPartyLegalEntity(toRepresentation(item));
		}
		for (String item : model.getPartyName()) {
			rep.addPartyName(item);
		}
		for (String item : model.getPartyIdentification()) {
			rep.addPartyIdentification(item);
		}
		return rep;
	}

	public static PartyLegalEntityRepresentation toRepresentation(PartyLegalModel model) {
		PartyLegalEntityRepresentation rep = new PartyLegalEntityRepresentation();
		rep.setRegistrationName(model.getRegistrationName());
		return rep;
	}

	public static AddressRepresentation toRepresentation(AddressModel model) {
		AddressRepresentation rep = new AddressRepresentation();
		rep.setIdUbl(model.getID());
		rep.setStreetName(model.getStreetName());
		rep.setCitySubdivisionName(model.getCitySubdivisionName());
		rep.setCityName(model.getCityName());
		rep.setCountrySubentity(model.getCountrySubentity());
		rep.setDistrict(model.getDistrict());
		rep.setDepartment(model.getDepartment());
		if (model.getCountry() != null) {
			rep.setCountry(toRepresentation(model.getCountry()));
		}
		return rep;
	}

	public static CountryRepresentation toRepresentation(CountryModel model) {
		CountryRepresentation rep = new CountryRepresentation();
		rep.setIdentificationCode(model.getIdentificationCode());
		return rep;
	}

	public static QuantityRepresentation toRepresentation(QuantityModel model) {
		QuantityRepresentation rep = new QuantityRepresentation();
		rep.setUnitCode(model.getUnitCode());
		rep.setValue(model.getValue());
		return rep;
	}

	public static SignatureRepresentation toRepresentation(SignatureModel model) {
		SignatureRepresentation rep = new SignatureRepresentation();
		if (model.getCanonicalizationMethod() != null) {
			rep.setCanonicalizationMethod(model.getCanonicalizationMethod());
		}
		if (model.getID() != null) {
			rep.setIdUbl(model.getID());
		}
		if (model.getNote() != null) {
			rep.setNote(model.getNote());
		}
		if (model.getSignatureMethod() != null) {
			rep.setSignatureMethod(model.getSignatureMethod());
		}
		if (model.getValidationDate() != null) {
			rep.setValidationDate(model.getValidationDate());
		}
		if (model.getValidationTime() != null) {
			rep.setValidationTime(model.getValidationTime());
		}
		if (model.getValidatorID() != null) {
			rep.setValidatorID(model.getValidatorID());
		}
		if (model.getSignatoryParty() != null) {
			rep.setSignatoryParty(toRepresentation(model.getSignatoryParty()));
		}
		if (model.getDigitalSignatureAttachment() != null) {
			rep.setDigitalSignatureAttachment(toRepresentation(model.getDigitalSignatureAttachment()));
		}
		return rep;
	}

	public static AttachmentRepresentation toRepresentation(AttachmentModel model) {
		AttachmentRepresentation rep = new AttachmentRepresentation();
		if (model.getExternalReference() != null) {
			rep.setExternalReference(toRepresentation(model.getExternalReference()));
		}
		if (model.getEmbeddedDocumentBinaryObject() != null) {
			rep.setEmbeddedDocumentBinaryObject(toRepresentation(model.getEmbeddedDocumentBinaryObject()));
		}
		return rep;
	}

	public static ExternalReferenceRepresentation toRepresentation(ExternalReferenceModel model) {
		ExternalReferenceRepresentation rep = new ExternalReferenceRepresentation();
		if (model.getDocumentHash() != null) {
			rep.setDocumentHash(model.getDocumentHash());
		}
		if (model.getExpiryDate() != null) {
			rep.setExpiryDate(model.getExpiryDate());
		}
		if (model.getExpiryTime() != null) {
			rep.setExpiryTime(model.getExpiryTime());
		}
		if (model.getURI() != null) {
			rep.setUri(model.getURI());
		}
		return rep;
	}

	public static BinaryObjectRepresentation toRepresentation(BinaryObjectModel model) {
		BinaryObjectRepresentation rep = new BinaryObjectRepresentation();
		if (model.getCharacterSetCode() != null) {
			rep.setCharacterSetCode(model.getCharacterSetCode());
		}
		if (model.getEncodingCode() != null) {
			rep.setEncodingCode(model.getEncodingCode());
		}
		if (model.getFilename() != null) {
			rep.setFilename(model.getFilename());
		}
		if (model.getFormat() != null) {
			rep.setFormat(model.getFormat());
		}
		if (model.getMimeCode() != null) {
			rep.setMimeCode(model.getMimeCode());
		}
		if (model.getUri() != null) {
			rep.setUri(model.getUri());
		}
		if (model.getValue() != null) {
			rep.setValue(model.getValue());
		}
		return rep;
	}

	public static UBLExtensionsRepresentation toRepresentation(UBLExtensionsModel model) {
		UBLExtensionsRepresentation rep = new UBLExtensionsRepresentation();
		for (UBLExtensionModel item : model.getUBLExtension()) {
			rep.addUBLExtension(toRepresentation(item));
		}
		return null;
	}

	public static UBLExtensionRepresentation toRepresentation(UBLExtensionModel model) {
		// TODO Auto-generated method stub
		return null;
	}

	public static XMLGregorianCalendar toRepresentation(LocalDate date) throws DatatypeConfigurationException {
		return DatatypeFactory.newInstance().newXMLGregorianCalendar(date.toString());
	}

	public static OrganizationEventsConfigRepresentation toEventsConfigReprensetation(OrganizationModel organization) {

		OrganizationEventsConfigRepresentation rep = new OrganizationEventsConfigRepresentation();
		rep.setEventsEnabled(organization.isEventsEnabled());

		if (organization.getEventsExpiration() != 0) {
			rep.setEventsExpiration(organization.getEventsExpiration());
		}

		if (organization.getEventsListeners() != null) {
			rep.setEventsListeners(new LinkedList<>(organization.getEventsListeners()));
		}

		if (organization.getEnabledEventTypes() != null) {
			rep.setEnabledEventTypes(new LinkedList<>(organization.getEnabledEventTypes()));
		}

		rep.setAdminEventsEnabled(organization.isAdminEventsEnabled());

		rep.setAdminEventsDetailsEnabled(organization.isAdminEventsDetailsEnabled());

		return rep;
	}

	public static EventRepresentation toRepresentation(Event event) {
		EventRepresentation rep = new EventRepresentation();
		rep.setTime(event.getTime());
		rep.setType(event.getType().toString());
		rep.setOrganizationId(event.getOrganizationId());
		rep.setUserId(event.getUserId());
		rep.setIpAddress(event.getIpAddress());
		rep.setError(event.getError());
		rep.setDetails(event.getDetails());
		return rep;
	}

	public static AdminEventRepresentation toRepresentation(AdminEvent adminEvent) {
		AdminEventRepresentation rep = new AdminEventRepresentation();
		rep.setTime(adminEvent.getTime());
		rep.setOrganizationId(adminEvent.getOrganizationId());
		if (adminEvent.getAuthDetails() != null) {
			rep.setAuthDetails(toRepresentation(adminEvent.getAuthDetails()));
		}
		rep.setOperationType(adminEvent.getOperationType().toString());
		if (adminEvent.getResourceType() != null) {
			rep.setResourceType(adminEvent.getResourceType().toString());
		}
		rep.setResourcePath(adminEvent.getResourcePath());
		rep.setRepresentation(adminEvent.getRepresentation());
		rep.setError(adminEvent.getError());

		return rep;
	}

	public static AuthDetailsRepresentation toRepresentation(AuthDetails authDetails) {
		AuthDetailsRepresentation rep = new AuthDetailsRepresentation();
		rep.setOrganizationId(authDetails.getOrganizationId());
		rep.setUserId(authDetails.getUserId());
		rep.setIpAddress(authDetails.getIpAddress());
		return rep;
	}

	public static List<ConfigPropertyRepresentation> toRepresentation(List<ProviderConfigProperty> configProperties) {
		List<ConfigPropertyRepresentation> propertiesRep = new LinkedList<>();
		for (ProviderConfigProperty prop : configProperties) {
			ConfigPropertyRepresentation propRep = toRepresentation(prop);
			propertiesRep.add(propRep);
		}
		return propertiesRep;
	}

	public static ConfigPropertyRepresentation toRepresentation(ProviderConfigProperty prop) {
		ConfigPropertyRepresentation propRep = new ConfigPropertyRepresentation();
		propRep.setName(prop.getName());
		propRep.setLabel(prop.getLabel());
		propRep.setType(prop.getType());
		propRep.setDefaultValue(prop.getDefaultValue());
		propRep.setOptions(prop.getOptions());
		propRep.setHelpText(prop.getHelpText());
		propRep.setSecret(prop.isSecret());
		return propRep;
	}

	public static ComponentRepresentation toRepresentation(OpenfactSession session, ComponentModel component,
			boolean internal) {
		ComponentRepresentation rep = new ComponentRepresentation();
		rep.setId(component.getId());
		rep.setName(component.getName());
		rep.setProviderId(component.getProviderId());
		rep.setProviderType(component.getProviderType());
		rep.setSubType(component.getSubType());
		rep.setParentId(component.getParentId());
		if (internal) {
			rep.setConfig(component.getConfig());
		} else {
			Map<String, ProviderConfigProperty> configProperties = ComponentUtil.getComponentConfigProperties(session,
					component);
			MultivaluedHashMap<String, String> config = new MultivaluedHashMap<>();

			for (Map.Entry<String, List<String>> e : component.getConfig().entrySet()) {
				ProviderConfigProperty configProperty = configProperties.get(e.getKey());
				if (configProperty != null) {
					if (configProperty.isSecret()) {
						config.putSingle(e.getKey(), ComponentRepresentation.SECRET_VALUE);
					} else {
						config.put(e.getKey(), e.getValue());
					}
				}
			}

			rep.setConfig(config);
		}
		return rep;
	}

	public static SendEventRepresentation toRepresentation(SendEventModel model) {
		SendEventRepresentation rep = new SendEventRepresentation();
		rep.setAccepted(model.isAccepted());
		rep.setBarCode(model.getbarCode());
		rep.setCustomerDoument(model.getCustomerDoument());
		rep.setDescription(model.getDescription());
		rep.setDigestValue(model.getDigestValue());
		rep.setDocumentResponse(model.getDocumentResponse());
		rep.setError(model.getError());
		rep.setID(model.getID());
		rep.setNote(model.getNote());
		rep.setResponseCode(model.getResponseCode());
		rep.setSendWarning(model.getSendWarning());
		rep.setXmlDoument(model.getXmlDoument());
		return rep;
	}

}
