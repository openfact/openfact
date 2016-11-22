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

import org.openfact.common.util.MultivaluedHashMap;
import org.openfact.component.ComponentModel;
import org.openfact.keys.KeyProvider;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.search.SearchCriteriaFilterOperator;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.ubl.SendEventModel;
import org.openfact.models.ubl.common.*;
import org.openfact.provider.ProviderConfigProperty;
import org.openfact.representations.idm.ComponentRepresentation;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.representations.idm.PostalAddressRepresentation;
import org.openfact.representations.idm.search.PagingRepresentation;
import org.openfact.representations.idm.search.SearchCriteriaFilterOperatorRepresentation;
import org.openfact.representations.idm.search.SearchCriteriaFilterRepresentation.FilterValueType;
import org.openfact.representations.idm.search.SearchCriteriaRepresentation;
import org.openfact.representations.idm.ubl.CreditNoteRepresentation;
import org.openfact.representations.idm.ubl.DebitNoteRepresentation;
import org.openfact.representations.idm.ubl.InvoiceRepresentation;
import org.openfact.representations.idm.ubl.SendEventRepresentation;
import org.openfact.representations.idm.ubl.common.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

public class RepresentationToModel {

	public static SearchCriteriaModel toModel(SearchCriteriaRepresentation rep) {
		SearchCriteriaModel model = new SearchCriteriaModel();

		// filters
		Function<SearchCriteriaFilterOperatorRepresentation, SearchCriteriaFilterOperator> operatorFunction = f -> {
			return SearchCriteriaFilterOperator.valueOf(f.toString());
		};

		BiFunction<Object, FilterValueType, Object> valueFunction = (value, type) -> {
			Object result = null;
			switch (type) {
			case LONG:
				result = (long) value;
				break;
			case STRING:
				result = (String) value;
				break;
			case DATE:
				result = LocalDateTime.parse((String) value, DateTimeFormatter.ISO_DATE);
				break;
			case DATETIME:
				result = LocalDateTime.parse((String) value, DateTimeFormatter.ISO_DATE_TIME);
				break;
			default:
				result = value;
				break;
			}
			return result;
		};

		rep.getFilters().forEach(f -> {
			model.addFilter(f.getName(), valueFunction.apply(f.getValue(), f.getType()),
					operatorFunction.apply(f.getOperator()));
		});

		// sorter
		rep.getOrders().forEach(f -> model.addOrder(f.getName(), f.isAscending()));

		// paging
		PagingRepresentation paging = rep.getPaging();
		model.setPageSize(paging.getPageSize());
		model.setPage(paging.getPage());

		return model;
	}

	public static void importOrganization(OpenfactSession session, OrganizationRepresentation rep,
			OrganizationModel newOrganization) {

		newOrganization.setName(rep.getOrganization());

		/**
		 * General information
		 */
		if (rep.getDescription() != null) {
			newOrganization.setDescription(rep.getDescription());
		}
		if (rep.getEnabled() != null) {
			newOrganization.setEnabled(rep.getEnabled());
		}

		if (rep.getAssignedIdentificationId() != null) {
			newOrganization.setAssignedIdentificationId(rep.getAssignedIdentificationId());
		}
		if (rep.getAdditionalAccountId() != null) {
			newOrganization.setAdditionalAccountId(rep.getAdditionalAccountId());
		}
		if (rep.getSupplierName() != null) {
			newOrganization.setSupplierName(rep.getSupplierName());
		}
		if (rep.getRegistrationName() != null) {
			newOrganization.setRegistrationName(rep.getRegistrationName());
		}

		/**
		 * Postal address
		 */
		if (rep.getPostalAddress() != null) {
			PostalAddressRepresentation postalAddressRep = rep.getPostalAddress();
			if (postalAddressRep.getCountryIdentificationCode() != null) {
				newOrganization.setCountryIdentificationCode(postalAddressRep.getCountryIdentificationCode());
			}
			if (postalAddressRep.getCountrySubentity() != null) {
				newOrganization.setCountrySubentity(postalAddressRep.getCountrySubentity());
			}
			if (postalAddressRep.getCityName() != null) {
				newOrganization.setCityName(postalAddressRep.getCityName());
			}
			if (postalAddressRep.getCitySubdivisionName() != null) {
				newOrganization.setCitySubdivisionName(postalAddressRep.getCitySubdivisionName());
			}
			if (postalAddressRep.getDistrict() != null) {
				newOrganization.setDistrict(postalAddressRep.getDistrict());
			}
			if (postalAddressRep.getStreetName() != null) {
				newOrganization.setStreetName(postalAddressRep.getStreetName());
			}
		}

		/**
		 * Themes
		 */
		if (rep.getEmailTheme() != null) {
			newOrganization.setEmailTheme(rep.getEmailTheme());
		}

		/**
		 * Internationalization
		 */
		if (rep.getInternationalizationEnabled() != null) {
			newOrganization.setInternationalizationEnabled(rep.getInternationalizationEnabled());
		}
		if (rep.getSupportedLocales() != null) {
			newOrganization.setSupportedLocales(new HashSet<String>(rep.getSupportedLocales()));
		}
		if (rep.getDefaultLocale() != null) {
			newOrganization.setDefaultLocale(rep.getDefaultLocale());
		}

		/**
		 * Tasks schedule
		 */
		if (rep.getTaskFirstTime() != null) {
			newOrganization.setTaskFirstTime(rep.getTaskFirstTime());
		}
		if (rep.getTaskDelay() != null) {
			newOrganization.setTaskDelay(rep.getTaskDelay());
		}
		if (rep.isTasksEnabled() != null) {
			newOrganization.setTaskEnabled(rep.isTasksEnabled());
		} else {
			newOrganization.setTaskEnabled(false);
		}

		/**
		 * Currencies
		 */
		if (rep.getDefaultCurrency() != null) {
			newOrganization.setDefaultCurrency(rep.getDefaultCurrency());
		}
		if (rep.getSupportedCurrencies() != null) {
			newOrganization.setSupportedCurrencies(new HashSet<String>(rep.getSupportedCurrencies()));
		}

		/**
		 * Events
		 */
		if (rep.getEventsEnabled() != null) {
			newOrganization.setEventsEnabled(rep.getEventsEnabled());
		}
		if (rep.getEventsExpiration() != null) {
			newOrganization.setEventsExpiration(rep.getEventsExpiration());
		}
		if (rep.getEventsListeners() != null) {
			newOrganization.setEventsListeners(new HashSet<>(rep.getEventsListeners()));
		}
		if (rep.getAdminEventsEnabled() != null) {
			newOrganization.setAdminEventsEnabled(rep.getAdminEventsEnabled());
		}
		if (rep.getAdminEventsDetailsEnabled() != null) {
			newOrganization.setAdminEventsDetailsEnabled(rep.getAdminEventsDetailsEnabled());
		}

		/**
		 * Smtp server
		 */
		if (rep.getSmtpServer() != null) {
			newOrganization.setSmtpConfig(new HashMap<String, String>(rep.getSmtpServer()));
		}

		/**
		 * Certificate
		 */
		if (newOrganization.getComponents(newOrganization.getId(), KeyProvider.class.getName()).isEmpty()) {
			if (rep.getPrivateKey() != null) {
				DefaultKeyProviders.createProviders(newOrganization, rep.getPrivateKey(), rep.getCertificate());
			} else {
				DefaultKeyProviders.createProviders(newOrganization);
			}
		}

		/**
		 * Attributes
		 */
		if (rep.getAttributes() != null) {
			for (Map.Entry<String, String> attr : rep.getAttributes().entrySet()) {
				newOrganization.setAttribute(attr.getKey(), attr.getValue());
			}
		}

		/**
		 * Required actions
		 */

		// create invoices and their lines
		if (rep.getInvoices() != null) {
			for (InvoiceRepresentation invoiceRep : rep.getInvoices()) {
				InvoiceModel invoice = session.invoices().addInvoice(newOrganization, invoiceRep.getIdUbl());
				importInvoice(session, newOrganization, invoice, invoiceRep);
			}
		}

		// create debit notes and their lines
		if (rep.getCreditNotes() != null) {
			for (CreditNoteRepresentation creditNoteRep : rep.getCreditNotes()) {
				CreditNoteModel creditNote = session.creditNotes().addCreditNote(newOrganization,
						creditNoteRep.getIdUbl());
				importCreditNote(session, newOrganization, creditNote, creditNoteRep);
			}
		}

		// create debit notes and their lines
		if (rep.getDebitNotes() != null) {
			for (DebitNoteRepresentation debitNoteRep : rep.getDebitNotes()) {
				DebitNoteModel debitNote = session.debitNotes().addDebitNote(newOrganization, debitNoteRep.getIdUbl());
				importDebitNote(session, newOrganization, debitNote, debitNoteRep);
			}
		}

	}

	public static void updateOrganization(OrganizationRepresentation rep, OrganizationModel organization,
			OpenfactSession session) {
		if (rep.getOrganization() != null) {
			renameOrganization(organization, rep.getOrganization());
		}

		// Import attributes first, so the stuff saved directly on
		// representation (displayName, bruteForce etc) has bigger priority
		if (rep.getAttributes() != null) {
			Set<String> attrsToRemove = new HashSet<>(organization.getAttributes().keySet());
			attrsToRemove.removeAll(rep.getAttributes().keySet());

			for (Map.Entry<String, String> entry : rep.getAttributes().entrySet()) {
				organization.setAttribute(entry.getKey(), entry.getValue());
			}

			for (String attr : attrsToRemove) {
				organization.removeAttribute(attr);
			}
		}

		/**
		 * General information
		 */
		if (rep.getDescription() != null) {
			organization.setDescription(rep.getDescription());
		}
		if (rep.getEnabled() != null) {
			organization.setEnabled(rep.getEnabled());
		}

		if (rep.getAssignedIdentificationId() != null) {
			organization.setAssignedIdentificationId(rep.getAssignedIdentificationId());
		}
		if (rep.getAdditionalAccountId() != null) {
			organization.setAdditionalAccountId(rep.getAdditionalAccountId());
		}
		if (rep.getSupplierName() != null) {
			organization.setSupplierName(rep.getSupplierName());
		}
		if (rep.getRegistrationName() != null) {
			organization.setRegistrationName(rep.getRegistrationName());
		}

		/**
		 * Postal address
		 */
		if (rep.getPostalAddress() != null) {
			PostalAddressRepresentation postalAddressRep = rep.getPostalAddress();
			if (postalAddressRep.getCountryIdentificationCode() != null) {
				organization.setCountryIdentificationCode(postalAddressRep.getCountryIdentificationCode());
			}
			if (postalAddressRep.getCountrySubentity() != null) {
				organization.setCountrySubentity(postalAddressRep.getCountrySubentity());
			}
			if (postalAddressRep.getCityName() != null) {
				organization.setCityName(postalAddressRep.getCityName());
			}
			if (postalAddressRep.getCitySubdivisionName() != null) {
				organization.setCitySubdivisionName(postalAddressRep.getCitySubdivisionName());
			}
			if (postalAddressRep.getDistrict() != null) {
				organization.setDistrict(postalAddressRep.getDistrict());
			}
			if (postalAddressRep.getStreetName() != null) {
				organization.setStreetName(postalAddressRep.getStreetName());
			}
		}

		/**
		 * Themes
		 */
		if (rep.getEmailTheme() != null) {
			organization.setEmailTheme(rep.getEmailTheme());
		}

		/**
		 * Internationalization
		 */
		if (rep.getInternationalizationEnabled() != null) {
			organization.setInternationalizationEnabled(rep.getInternationalizationEnabled());
		}
		if (rep.getSupportedLocales() != null) {
			organization.setSupportedLocales(new HashSet<String>(rep.getSupportedLocales()));
		}
		if (rep.getDefaultLocale() != null) {
			organization.setDefaultLocale(rep.getDefaultLocale());
		}

		/**
		 * Tasks schedule
		 */
		if (rep.isTasksEnabled() != null) {
			organization.setTaskEnabled(rep.isTasksEnabled());
		}
		if (rep.getTaskFirstTime() != null) {
			organization.setTaskFirstTime(rep.getTaskFirstTime());
		}
		if (rep.getTaskDelay() != null) {
			organization.setTaskDelay(rep.getTaskDelay());
		}

		/**
		 * Currencies
		 */
		if (rep.getDefaultCurrency() != null) {
			organization.setDefaultCurrency(rep.getDefaultCurrency());
		}
		if (rep.getSupportedCurrencies() != null) {
			organization.setSupportedCurrencies(new HashSet<String>(new HashSet<>(rep.getSupportedCurrencies())));
		}

		/**
		 * Events
		 */
		if (rep.getEventsEnabled() != null) {
			organization.setEventsEnabled(rep.getEventsEnabled());
		}
		if (rep.getEventsExpiration() != null) {
			organization.setEventsExpiration(rep.getEventsExpiration());
		}
		if (rep.getEventsListeners() != null) {
			organization.setEventsListeners(new HashSet<>(rep.getEventsListeners()));
		}
		if (rep.getEnabledEventTypes() != null) {
			organization.setEnabledEventTypes(new HashSet<>(rep.getEnabledEventTypes()));
		}

		if (rep.getAdminEventsEnabled() != null) {
			organization.setAdminEventsEnabled(rep.getAdminEventsEnabled());
		}
		if (rep.getAdminEventsDetailsEnabled() != null) {
			organization.setAdminEventsDetailsEnabled(rep.getAdminEventsDetailsEnabled());
		}

		/**
		 * Smtp Server
		 **/
		if (rep.getSmtpServer() != null) {
			organization.setSmtpConfig(new HashMap(rep.getSmtpServer()));
		}
	}

	public static void renameOrganization(OrganizationModel organization, String name) {
		if (name.equals(organization.getName())) {
			return;
		}

		String oldName = organization.getName();
		organization.setName(name);
	}

	public static InvoiceModel importInvoice(OpenfactSession session, OrganizationModel organization,
			InvoiceModel model, InvoiceRepresentation rep) {
		if (rep.getUblVersionID() != null) {
			model.setUBLVersionID(rep.getUblVersionID());
		}
		if (rep.getCustomizationID() != null) {
			model.setCustomizationID(rep.getCustomizationID());
		}
		if (rep.getSignature() != null) {
			for (SignatureRepresentation item : rep.getSignature()) {
				updateModel(model.addSignature(), item);
			}
		}

		if (rep.getIssueDateTime() != null) {
			model.setIssueDateTime(rep.getIssueDateTime());
		}
		if (rep.getAccountingSupplierParty() != null) {
			updateModel(model.getAccountingSupplierParty(), rep.getAccountingSupplierParty());
		}
		if (rep.getInvoiceTypeCode() != null) {
			model.setInvoiceTypeCode(rep.getInvoiceTypeCode());
		}
		if (rep.getIdUbl() != null) {
			model.setID(rep.getIdUbl());
		}
		if (rep.getAccountingCustomerParty() != null) {
			updateModel(model.getAccountingCustomerParty(), rep.getAccountingCustomerParty());
		}
		if (rep.getInvoiceLine() != null) {
			for (InvoiceLineRepresentation item : rep.getInvoiceLine()) {
				updateModel(model.addInvoiceLine(), item);
			}
		}
		if (rep.getTaxTotal() != null) {
			for (TaxTotalRepresentation item : rep.getTaxTotal()) {
				updateModel(model.addTaxTotal(), item);
			}
		}
		if (rep.getLegalMonetaryTotal() != null) {
			updateModel(model.getLegalMonetaryTotal(), rep.getLegalMonetaryTotal());
		}
		model.setDocumentCurrencyCode(rep.getDocumentCurrencyCode());

		if (rep.getUblExtensions() != null) {
			updateModel(model.getUBLExtensions(), rep.getUblExtensions());
		}

		return model;
	}

	public static CreditNoteModel importCreditNote(OpenfactSession session, OrganizationModel organization,
			CreditNoteModel model, CreditNoteRepresentation rep) {
		if (rep.getUblVersionID() != null) {
			model.setUBLVersionID(rep.getUblVersionID());
		}
		if (rep.getCustomizationID() != null) {
			model.setCustomizationID(rep.getCustomizationID());
		}
		if (rep.getSignature() != null) {
			for (SignatureRepresentation item : rep.getSignature()) {
				updateModel(model.addSignature(), item);
			}
		}

		if (rep.getIssueDateTime() != null) {
			model.setIssueDateTime(rep.getIssueDateTime());
		}
		if (rep.getAccountingSupplierParty() != null) {
			updateModel(model.getAccountingSupplierParty(), rep.getAccountingSupplierParty());
		}
		if (rep.getDiscrepancyResponse() != null) {
			for (ResponseRepresentation item : rep.getDiscrepancyResponse()) {
				updateModel(model.addDiscrepancyResponse(), item);
			}
		}
		if (rep.getIdUbl() != null) {
			model.setID(rep.getIdUbl());
		}
		if (rep.getCreditNoteLine() != null) {
			for (CreditNoteLineRepresentation item : rep.getCreditNoteLine()) {
				updateModel(model.addCreditNoteLine(), item);
			}
		}
		if (rep.getTaxTotal() != null) {
			for (TaxTotalRepresentation item : rep.getTaxTotal()) {
				updateModel(model.addTaxTotal(), item);
			}
		}

		if (rep.getLegalMonetaryTotal() != null) {
			updateModel(model.getLegalMonetaryTotal(), rep.getLegalMonetaryTotal());
		}

		if (rep.getDocumentCurrencyCode() != null) {
			model.setDocumentCurrencyCode(rep.getDocumentCurrencyCode());
		}
		if (rep.getDespatchDocumentReference() != null) {
			for (DocumentReferenceRepresentation item : rep.getDespatchDocumentReference()) {
				updateModel(model.addDespatchDocumentReference(), item);
			}
		}
		return model;
	}

	public static DebitNoteModel importDebitNote(OpenfactSession session, OrganizationModel organization,
			DebitNoteModel model, DebitNoteRepresentation rep) {
		if (rep.getUblVersionID() != null) {
			model.setUBLVersionID(rep.getUblVersionID());
		}
		if (rep.getCustomizationID() != null) {
			model.setCustomizationID(rep.getCustomizationID());
		}
		if (rep.getSignature() != null) {
			for (SignatureRepresentation item : rep.getSignature()) {
				updateModel(model.addSignature(), item);
			}
		}

		if (rep.getIssueDateTime() != null) {
			model.setIssueDateTime(rep.getIssueDateTime());
		}
		if (rep.getAccountingSupplierParty() != null) {
			updateModel(model.getAccountingSupplierParty(), rep.getAccountingSupplierParty());
		}
		if (rep.getDiscrepancyResponse() != null) {
			for (ResponseRepresentation item : rep.getDiscrepancyResponse()) {
				updateModel(model.addDiscrepancyResponse(), item);
			}
		}
		if (rep.getIdUbl() != null) {
			model.setID(rep.getIdUbl());
		}
		if (rep.getAccountingCustomerParty() != null) {
			updateModel(model.getAccountingCustomerParty(), rep.getAccountingCustomerParty());
		}
		if (rep.getDebitNoteLine() != null) {
			for (DebitNoteLineRepresentation item : rep.getDebitNoteLine()) {
				updateModel(model.addDebitNoteLine(), item);
			}
		}
		if (rep.getTaxTotal() != null) {
			for (TaxTotalRepresentation item : rep.getTaxTotal()) {
				updateModel(model.addTaxTotal(), item);
			}
		}
		if (rep.getRequestedMonetaryTotal() != null) {
			updateModel(model.getRequestedMonetaryTotal(), rep.getRequestedMonetaryTotal());
		}
		if (rep.getDocumentCurrencyCode() != null) {
			model.setDocumentCurrencyCode(rep.getDocumentCurrencyCode());
		}
		if (rep.getBillingReference() != null) {
			for (BillingReferenceRepresentation item : rep.getBillingReference()) {
				updateModel(model.addBillingReference(), item);
			}
		}
		if (rep.getDespatchDocumentReference() != null) {
			for (DocumentReferenceRepresentation item : rep.getDespatchDocumentReference()) {
				updateModel(model.addDespatchDocumentReference(), item);
			}
		}
		return model;
	}

	public static void updateModel(UBLExtensionsModel model, UBLExtensionsRepresentation rep) {
		if (rep.getUblExtension() != null) {
			for (UBLExtensionRepresentation item : rep.getUblExtension()) {
				updateModel(model.addUblExtension(), item);
			}
		}
	}

	public static void updateModel(UBLExtensionModel model, UBLExtensionRepresentation rep) {
		if (rep.getExtensionAgencyID() != null) {
			model.setExtensionAgencyID(rep.getExtensionAgencyID());
		}
		if (rep.getExtensionAgencyName() != null) {
			model.setExtensionAgencyName(rep.getExtensionAgencyName());
		}
		if (rep.getExtensionAgencyURI() != null) {
			model.setExtensionAgencyURI(rep.getExtensionAgencyURI());
		}
		if (rep.getExtensionReason() != null) {
			model.setExtensionReason(rep.getExtensionReason());
		}
		if (rep.getExtensionReasonCode() != null) {
			model.setExtensionReasonCode(rep.getExtensionReasonCode());
		}
		if (rep.getExtensionURI() != null) {
			model.setExtensionURI(rep.getExtensionURI());
		}
		if (rep.getExtensionVersionID() != null) {
			model.setExtensionVersionID(rep.getExtensionVersionID());
		}
		if (rep.getIdUbl() != null) {
			model.setID(rep.getIdUbl());
		}
		if (rep.getName() != null) {
			model.setName(rep.getName());
		}
		if (rep.getExtensionContent() != null) {
			updateModel(model.getExtensionContent(), rep.getExtensionContent());
		}
	}

	public static void updateModel(ExtensionContentModel model, ExtensionContentRepresentation rep) {
		if (rep.getAnyItem() != null) {
			model.setAnyItem(rep.getAnyItem());
		}
		if (rep.getAny() != null) {
			model.setAny(rep.getAny());
		}
	}

	public static void updateModel(InvoiceLineModel model, InvoiceLineRepresentation rep) {
		if (rep.getInvoicedQuantity() != null) {
			updateModel(model.getInvoicedQuantity(), rep.getInvoicedQuantity());
		}
		if (rep.getItem() != null) {
			updateModel(model.getItem(), rep.getItem());
		}
		if (rep.getPrice() != null) {
			updateModel(model.getPrice(), rep.getPrice());
		}
		if (rep.getPricingReference() != null) {
			updateModel(model.getPricingReference(), rep.getPricingReference());
		}
		if (rep.getTaxTotal() != null) {
			for (TaxTotalRepresentation item : rep.getTaxTotal()) {
				updateModel(model.addTaxTotal(), item);
			}
		}
		if (rep.getLineExtensionAmount() != null) {
			model.setLineExtensionAmount(rep.getLineExtensionAmount());
		}
		if (rep.getIdUbl() != null) {
			model.setID(rep.getIdUbl());
		}
		if (rep.getAllowanceCharge() != null) {
			for (AllowanceChargeRepresentation item : rep.getAllowanceCharge()) {
				updateModel(model.addAllowanceCharge(), item);
			}
		}
	}

	public static void updateModel(CreditNoteLineModel model, CreditNoteLineRepresentation rep) {
		if (rep.getIdUbl() != null) {
			model.setID(rep.getIdUbl());
		}
		if (rep.getCreditedQuantity() != null) {
			updateModel(model.getCreditedQuantity(), rep.getCreditedQuantity());
		}
		if (rep.getItem() != null) {
			updateModel(model.getItem(), rep.getItem());
		}
		if (rep.getPrice() != null) {
			updateModel(model.getPrice(), rep.getPrice());
		}
		if (rep.getPricingReference() != null) {
			updateModel(model.getPricingReference(), rep.getPricingReference());
		}
		if (rep.getTaxTotal() != null) {
			for (TaxTotalRepresentation item : rep.getTaxTotal()) {
				updateModel(model.addTaxTotal(), item);
			}
		}
		if (rep.getLineExtensionAmount() != null) {
			model.setLineExtensionAmount(rep.getLineExtensionAmount());
		}
	}

	public static void updateModel(DebitNoteLineModel model, DebitNoteLineRepresentation rep) {
		if (rep.getIdUbl() != null) {
			model.setID(rep.getIdUbl());
		}
		if (rep.getDebitedQuantity() != null) {
			updateModel(model.getDebitedQuantity(), rep.getDebitedQuantity());
		}
		if (rep.getItem() != null) {
			updateModel(model.getItem(), rep.getItem());
		}
		if (rep.getPrice() != null) {
			updateModel(model.getPrice(), rep.getPrice());
		}
		if (rep.getPricingReference() != null) {
			updateModel(model.getPricingReference(), rep.getPricingReference());
		}
		if (rep.getTaxTotal() != null) {
			for (TaxTotalRepresentation item : rep.getTaxTotal()) {
				updateModel(model.addTaxTotal(), item);
			}
		}
		if (rep.getLineExtensionAmount() != null) {
			model.setLineExtensionAmount(rep.getLineExtensionAmount());
		}
	}

	public static void updateModel(BillingReferenceModel model, BillingReferenceRepresentation rep) {
		if (rep.getInvoiceDocumentReference() != null) {
			updateModel(model.getInvoiceDocumentReference(), rep.getInvoiceDocumentReference());
		}
	}

	public static void updateModel(DocumentReferenceModel model, DocumentReferenceRepresentation rep) {
		if (rep.getDocumentCodeRepresentation() != null) {
			model.setDocumentCode(rep.getDocumentCodeRepresentation());
		}
	}

	public static void updateModel(ResponseModel model, ResponseRepresentation rep) {
		if (rep.getReferenceID() != null) {
			model.setReferenceID(rep.getReferenceID());
		}
		if (rep.getReferenceID() != null) {
			model.setReferenceID(rep.getReferenceID());
		}
		if (rep.getDescription() != null) {
			for (String item : rep.getDescription()) {
				model.getDescription().add(item);
			}
		}
	}

	public static void updateModel(MonetaryTotalModel model, MonetaryTotalRepresentation rep) {
		if (rep.getChargeTotalAmount() != null) {
			model.setChargeTotalAmount(rep.getChargeTotalAmount());
		}
		if (rep.getPayableAmount() != null) {
			model.setPayableAmount(rep.getPayableAmount());
		}
		if (rep.getAllowanceTotalAmount() != null) {
			model.setAllowanceTotalAmount(rep.getAllowanceTotalAmount());
		}
	}

	public static void updateModel(AllowanceChargeModel model, AllowanceChargeRepresentation rep) {
		if (rep.getAmount() != null) {
			model.setAmount(rep.getAmount());
		}
		if (rep.getChargeIndicator() != null) {
			model.setChargeIndicator(rep.getChargeIndicator());
		}
	}

	public static void updateModel(PricingReferenceModel model, PricingReferenceRepresentation rep) {
		if (rep.getAlternativeConditionPrice() != null) {
			for (PriceRepresentation item : rep.getAlternativeConditionPrice()) {
				updateModel(model.addAlternativeConditionPrice(), item);
			}
		}
	}

	public static void updateModel(PriceModel model, PriceRepresentation rep) {
		if (rep.getPriceAmount() != null) {
			model.setPriceAmount(rep.getPriceAmount());
		}
		if (rep.getPriceTypeCode() != null) {
			model.setPriceTypeCode(rep.getPriceTypeCode());
		}
	}

	public static void updateModel(ItemModel model, ItemRepresentation rep) {
		if (rep.getDescription() != null) {
			for (String item : rep.getDescription()) {
				model.getDescription().add(item);
			}
		}
		if (rep.getSellersItemIdentification() != null) {
			updateModel(model.getSellersItemIdentification(), rep.getSellersItemIdentification());
		}
	}

	public static void updateModel(ItemIdentificationModel model, ItemIdentificationRepresentation rep) {
		if (rep.getIdUbl() != null) {
			model.setID(rep.getIdUbl());
		}
	}

	public static void updateModel(TaxTotalModel model, TaxTotalRepresentation rep) {
		if (rep.getTaxAmount() != null) {
			model.setTaxAmount(rep.getTaxAmount());
		}
		if (rep.getTaxSubtotal() != null) {
			for (TaxSubtotalRepresentation item : rep.getTaxSubtotal()) {
				updateModel(model.addTaxSubtotal(), item);
			}
		}
	}

	public static void updateModel(TaxSubtotalModel model, TaxSubtotalRepresentation rep) {
		if (rep.getTaxAmount() != null) {
			model.setTaxAmount(rep.getTaxAmount());
		}
		if (rep.getTaxCategory() != null) {
			updateModel(model.getTaxCategory(), rep.getTaxCategory());
		}
	}

	public static void updateModel(TaxCategoryModel model, TaxCategoryRepresentation rep) {
		if (rep.getTaxExemptionReasonCode() != null) {
			model.setTaxExemptionReasonCode(rep.getTaxExemptionReasonCode());
		}
		if (rep.getTaxScheme() != null) {
			updateModel(model.getTaxScheme(), rep.getTaxScheme());
		}
		if (rep.getTierRange() != null) {
			model.setTierRange(rep.getTierRange());
		}
	}

	public static void updateModel(TaxSchemeModel model, TaxSchemeRepresentation rep) {
		if (rep.getIdUbl() != null) {
			model.setID(rep.getIdUbl());
		}
		if (rep.getName() != null) {
			model.setName(rep.getName());
		}
		if (rep.getTaxCodeType() != null) {
			model.setTaxTypeCode(rep.getTaxCodeType());
		}
	}

	public static void updateModel(CustomerPartyModel model, CustomerPartyRepresentation rep) {
		if (rep.getCustomerAssignedAccountID() != null) {
			model.setCustomerAssignedAccountID(rep.getCustomerAssignedAccountID());
		}
		if (rep.getAdditionalAccountID() != null) {
			for (String item : rep.getAdditionalAccountID()) {
				model.getAdditionalAccountID().add(item);
			}
		}
		if (rep.getParty() != null) {
			updateModel(model.getParty(), rep.getParty());
		}
	}

	public static void updateModel(SupplierPartyModel model, SupplierPartyRepresentation rep) {
		if (rep.getParty() != null) {
			updateModel(model.getParty(), rep.getParty());
		}
		if (rep.getCustomerAssignedAccountID() != null) {
			model.setCustomerAssignedAccountID(rep.getCustomerAssignedAccountID());
		}
		if (rep.getAdditionalAccountID() != null) {
			for (String item : rep.getAdditionalAccountID()) {
				model.getAdditionalAccountID().add(item);
			}
		}
	}

	public static void updateModel(PartyModel model, PartyRepresentation rep) {
		if (rep.getPartyLegalEntity() != null) {
			for (PartyLegalEntityRepresentation item : rep.getPartyLegalEntity()) {
				updateModel(model.addPartyLegalEntity(), item);
			}
		}
		if (rep.getPartyIdentification() != null) {
			for (String item : rep.getPartyIdentification()) {
				model.getPartyIdentification().add(item);
			}
		}
		if (rep.getPartyName() != null) {
			for (String item : rep.getPartyName()) {
				model.getPartyName().add(item);
			}
		}
		if (rep.getPostalAddress() != null) {
			updateModel(model.getPostalAddress(), rep.getPostalAddress());
		}
	}

	public static void updateModel(PartyLegalModel model, PartyLegalEntityRepresentation rep) {
		if (rep.getRegistrationName() != null) {
			model.setRegistrationName(rep.getRegistrationName());
		}
	}

	public static void updateModel(AddressModel model, AddressRepresentation rep) {
		if (rep.getIdUbl() != null) {
			model.setID(rep.getIdUbl());
		}
		if (rep.getStreetName() != null) {
			model.setStreetName(rep.getStreetName());
		}
		if (rep.getCitySubdivisionName() != null) {
			model.setCitySubdivisionName(rep.getCitySubdivisionName());
		}
		if (rep.getCityName() != null) {
			model.setCityName(rep.getCityName());
		}
		if (rep.getCountrySubentity() != null) {
			model.setCountrySubentity(rep.getCountrySubentity());
		}
		if (rep.getDistrict() != null) {
			model.setDistrict(rep.getDistrict());
		}
		if (rep.getDepartment() != null) {
			model.setDepartment(rep.getDepartment());
		}
		if (rep.getCountry() != null) {
			updateModel(model.getCountry(), rep.getCountry());
		}
	}

	public static void updateModel(CountryModel model, CountryRepresentation rep) {
		if (rep.getIdentificationCode() != null) {
			model.setIdentificationCode(rep.getIdentificationCode());
		}
	}

	public static void updateModel(QuantityModel model, QuantityRepresentation rep) {
		if (rep.getUnitCode() != null) {
			model.setUnitCode(rep.getUnitCode());
		}
		if (rep.getValue() != null) {
			model.setValue(rep.getValue());
		}
	}

	public static void updateModel(SignatureModel model, SignatureRepresentation rep) {
		if (rep.getCanonicalizationMethod() != null) {
			model.setCanonicalizationMethod(rep.getCanonicalizationMethod());
		}
		if (rep.getIdUbl() != null) {
			model.setID(rep.getIdUbl());
		}
		if (rep.getNote() != null) {
			model.setNote(rep.getNote());
		}
		if (rep.getSignatureMethod() != null) {
			model.setSignatureMethod(rep.getSignatureMethod());
		}
		if (rep.getValidationDate() != null) {
			model.setValidationDate(rep.getValidationDate());
		}
		if (rep.getValidationTime() != null) {
			model.setValidationTime(rep.getValidationTime());
		}
		if (rep.getValidatorID() != null) {
			model.setValidatorID(rep.getValidatorID());
		}
		if (rep.getSignatoryParty() != null) {
			updateModel(model.getSignatoryParty(), rep.getSignatoryParty());
		}
		if (rep.getDigitalSignatureAttachment() != null) {
			updateModel(model.getDigitalSignatureAttachment(), rep.getDigitalSignatureAttachment());
		}
	}

	public static void updateModel(AttachmentModel model, AttachmentRepresentation rep) {
		if (rep.getExternalReference() != null) {
			updateModel(model.getExternalReference(), rep.getExternalReference());
		}
		if (rep.getEmbeddedDocumentBinaryObject() != null) {
			updateModel(model.getEmbeddedDocumentBinaryObject(), rep.getEmbeddedDocumentBinaryObject());
		}
	}

	public static void updateModel(ExternalReferenceModel model, ExternalReferenceRepresentation rep) {
		if (rep.getDocumentHash() != null) {
			model.setDocumentHash(rep.getDocumentHash());
		}
		if (rep.getExpiryDate() != null) {
			model.setExpiryDate(rep.getExpiryDate());
		}
		if (rep.getExpiryTime() != null) {
			model.setExpiryTime(rep.getExpiryTime());
		}
		if (rep.getUri() != null) {
			model.setURI(rep.getUri());
		}
	}

	public static void updateModel(BinaryObjectModel model, BinaryObjectRepresentation rep) {
		if (rep.getCharacterSetCode() != null) {
			model.setCharacterSetCode(rep.getCharacterSetCode());
		}
		if (rep.getEncodingCode() != null) {
			model.setEncodingCode(rep.getEncodingCode());
		}
		if (rep.getFilename() != null) {
			model.setFilename(rep.getFilename());
		}
		if (rep.getFormat() != null) {
			model.setFormat(rep.getFormat());
		}
		if (rep.getMimeCode() != null) {
			model.setMimeCode(rep.getMimeCode());
		}
		if (rep.getUri() != null) {
			model.setUri(rep.getUri());
		}
		if (rep.getValue() != null) {
			model.setValue(rep.getValue());
		}
	}

	public static ComponentModel toModel(OpenfactSession session, ComponentRepresentation rep) {
		ComponentModel model = new ComponentModel();
		model.setParentId(rep.getParentId());
		model.setProviderType(rep.getProviderType());
		model.setProviderId(rep.getProviderId());
		model.setConfig(new MultivaluedHashMap<>());
		model.setName(rep.getName());
		model.setSubType(rep.getSubType());

		if (rep.getConfig() != null) {
			Set<String> keys = new HashSet<>(rep.getConfig().keySet());
			for (String k : keys) {
				List<String> values = rep.getConfig().get(k);
				if (values != null) {
					ListIterator<String> itr = values.listIterator();
					while (itr.hasNext()) {
						String v = itr.next();
						if (v == null || v.trim().isEmpty()) {
							itr.remove();
						}
					}

					if (!values.isEmpty()) {
						model.getConfig().put(k, values);
					}
				}
			}
		}

		return model;
	}

	public static void updateComponent(OpenfactSession session, ComponentRepresentation rep, ComponentModel component,
			boolean internal) {
		if (rep.getParentId() != null) {
			component.setParentId(rep.getParentId());
		}

		if (rep.getProviderType() != null) {
			component.setProviderType(rep.getProviderType());
		}

		if (rep.getProviderId() != null) {
			component.setProviderId(rep.getProviderId());
		}

		if (rep.getSubType() != null) {
			component.setSubType(rep.getSubType());
		}

		Map<String, ProviderConfigProperty> providerConfiguration = null;
		if (!internal) {
			providerConfiguration = ComponentUtil.getComponentConfigProperties(session, component);
		}

		if (rep.getConfig() != null) {
			Set<String> keys = new HashSet<>(rep.getConfig().keySet());
			for (String k : keys) {
				if (!internal && !providerConfiguration.containsKey(k)) {
					break;
				}

				List<String> values = rep.getConfig().get(k);
				if (values == null || values.isEmpty() || values.get(0) == null || values.get(0).trim().isEmpty()) {
					component.getConfig().remove(k);
				} else {
					ListIterator<String> itr = values.listIterator();
					while (itr.hasNext()) {
						String v = itr.next();
						if (v == null || v.trim().isEmpty() || v.equals(ComponentRepresentation.SECRET_VALUE)) {
							itr.remove();
						}
					}

					if (!values.isEmpty()) {
						component.getConfig().put(k, values);
					}
				}
			}
		}
	}

	public static void toModel(SendEventRepresentation rep, SendEventModel model) {
		model.setAccepted(rep.isAccepted());
		if (rep.getBarCode() != null) {
			model.setbarCode(rep.getBarCode());
		}
		if (rep.getCustomerDoument() != null) {
			model.setCustomerDoument(rep.getCustomerDoument());
		}
		if (rep.getDescription() != null) {
			model.setDescription(rep.getDescription());
		}
		if (rep.getDigestValue() != null) {
			model.setDigestValue(rep.getDigestValue());
		}
		if (rep.getDocumentResponse() != null) {
			model.setDocumentResponse(rep.getDocumentResponse());
		}
		if (rep.getError() != null) {
			model.setError(rep.getError());
		}
		model.setID(rep.getID());
		if (rep.getNote() != null) {
			model.setNote(rep.getNote());
		}
		if (rep.getResponseCode() != null) {
			model.setResponseCode(rep.getResponseCode());
		}
		if (rep.getSendWarning() != null) {
			model.setSendWarning(rep.getSendWarning());
		}
		if (rep.getXmlDoument() != null) {
			model.setXmlDocument(rep.getXmlDoument());
		}
	}
}