/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
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
 *******************************************************************************/
package org.openfact.models.jpa.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jboss.logging.Logger;
import org.openfact.common.util.MultivaluedHashMap;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.RequiredActionDocument;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.OrganizationAdapter;
import org.openfact.models.jpa.entities.ubl.CreditNoteAttributeEntity;
import org.openfact.models.jpa.entities.ubl.CreditNoteEntity;
import org.openfact.models.jpa.entities.ubl.common.AllowanceChargeEntity;
import org.openfact.models.jpa.entities.ubl.common.BillingReferenceEntity;
import org.openfact.models.jpa.entities.ubl.common.CreditNoteLineEntity;
import org.openfact.models.jpa.entities.ubl.common.DocumentReferenceEntity;
import org.openfact.models.jpa.entities.ubl.common.PeriodEntity;
import org.openfact.models.jpa.entities.ubl.common.ResponseEntity;
import org.openfact.models.jpa.entities.ubl.common.SignatureEntity;
import org.openfact.models.jpa.entities.ubl.common.TaxTotalEntity;
import org.openfact.models.jpa.ubl.common.AllowanceChargeAdapter;
import org.openfact.models.jpa.ubl.common.BillingReferenceAdapter;
import org.openfact.models.jpa.ubl.common.CreditNoteLineAdapter;
import org.openfact.models.jpa.ubl.common.CustomerPartyAdapter;
import org.openfact.models.jpa.ubl.common.DocumentReferenceAdapter;
import org.openfact.models.jpa.ubl.common.ExchangeRateAdapter;
import org.openfact.models.jpa.ubl.common.MonetaryTotalAdapter;
import org.openfact.models.jpa.ubl.common.OrderReferenceAdapter;
import org.openfact.models.jpa.ubl.common.PartyAdapter;
import org.openfact.models.jpa.ubl.common.PeriodAdapter;
import org.openfact.models.jpa.ubl.common.ResponseAdapter;
import org.openfact.models.jpa.ubl.common.SignatureAdapter;
import org.openfact.models.jpa.ubl.common.SupplierPartyAdapter;
import org.openfact.models.jpa.ubl.common.TaxTotalAdapter;
import org.openfact.models.jpa.ubl.common.UBLExtensionsAdapter;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.common.AllowanceChargeModel;
import org.openfact.models.ubl.common.BillingReferenceModel;
import org.openfact.models.ubl.common.CreditNoteLineModel;
import org.openfact.models.ubl.common.CustomerPartyModel;
import org.openfact.models.ubl.common.DocumentReferenceModel;
import org.openfact.models.ubl.common.ExchangeRateModel;
import org.openfact.models.ubl.common.MonetaryTotalModel;
import org.openfact.models.ubl.common.OrderReferenceModel;
import org.openfact.models.ubl.common.PartyModel;
import org.openfact.models.ubl.common.PeriodModel;
import org.openfact.models.ubl.common.ResponseModel;
import org.openfact.models.ubl.common.SignatureModel;
import org.openfact.models.ubl.common.SupplierPartyModel;
import org.openfact.models.ubl.common.TaxTotalModel;
import org.openfact.models.ubl.common.UBLExtensionsModel;
import org.openfact.models.utils.OpenfactModelUtils;

public class CreditNoteAdapter implements CreditNoteModel, JpaModel<CreditNoteEntity> {

	protected static final Logger logger = Logger.getLogger(CreditNoteAdapter.class);

	protected OrganizationModel organization;
	protected CreditNoteEntity creditNote;
	protected EntityManager em;
	protected OpenfactSession session;

	public CreditNoteAdapter(OpenfactSession session, OrganizationModel organization, EntityManager em,
			CreditNoteEntity creditNote) {
		this.organization = organization;
		this.session = session;
		this.em = em;
		this.creditNote = creditNote;
	}

	@Override
	public CreditNoteEntity getEntity() {
		return creditNote;
	}

	/**
	 * @return the id
	 */
	@Override
	public String getId() {
		return creditNote.getId();
	}

	@Override
	public void setSingleAttribute(String name, String value) {
		String firstExistingAttrId = null;
		List<CreditNoteAttributeEntity> toRemove = new ArrayList<>();
		for (CreditNoteAttributeEntity attr : creditNote.getAttributes()) {
			if (attr.getName().equals(name)) {
				if (firstExistingAttrId == null) {
					attr.setValue(value);
					firstExistingAttrId = attr.getId();
				} else {
					toRemove.add(attr);
				}
			}
		}

		if (firstExistingAttrId != null) {
			// Remove attributes through HQL to avoid StaleUpdateException
			Query query = em.createNamedQuery("deleteCreditNoteAttributesOtherThan");
			query.setParameter("attrId", firstExistingAttrId);
			query.setParameter("creditNoteId", creditNote.getId());
			int numUpdated = query.executeUpdate();

			// Remove attribute from local entity
			creditNote.getAttributes().removeAll(toRemove);
		} else {

			persistAttributeValue(name, value);
		}
	}

	@Override
	public void setAttribute(String name, List<String> values) {
		// Remove all existing
		removeAttribute(name);

		// Put all new
		for (String value : values) {
			persistAttributeValue(name, value);
		}
	}

	private void persistAttributeValue(String name, String value) {
		CreditNoteAttributeEntity attr = new CreditNoteAttributeEntity();
		attr.setId(OpenfactModelUtils.generateId());
		attr.setName(name);
		attr.setValue(value);
		attr.setCreditNote(creditNote);
		em.persist(attr);
		creditNote.getAttributes().add(attr);
	}

	@Override
	public void removeAttribute(String name) {
		// OPENFACT-3296 : Remove attribute through HQL to avoid
		// StaleUpdateException
		Query query = em.createNamedQuery("deleteCreditNoteAttributesByNameAndCreditNote");
		query.setParameter("name", name);
		query.setParameter("creditNoteId", creditNote.getId());
		int numUpdated = query.executeUpdate();

		// Also remove attributes from local creditNote entity
		List<CreditNoteAttributeEntity> toRemove = new ArrayList<>();
		for (CreditNoteAttributeEntity attr : creditNote.getAttributes()) {
			if (attr.getName().equals(name)) {
				toRemove.add(attr);
			}
		}
		creditNote.getAttributes().removeAll(toRemove);
	}

	@Override
	public String getFirstAttribute(String name) {
		for (CreditNoteAttributeEntity attr : creditNote.getAttributes()) {
			if (attr.getName().equals(name)) {
				return attr.getValue();
			}
		}
		return null;
	}

	@Override
	public List<String> getAttribute(String name) {
		List<String> result = new ArrayList<>();
		for (CreditNoteAttributeEntity attr : creditNote.getAttributes()) {
			if (attr.getName().equals(name)) {
				result.add(attr.getValue());
			}
		}
		return result;
	}

	@Override
	public Map<String, List<String>> getAttributes() {
		MultivaluedHashMap<String, String> result = new MultivaluedHashMap<>();
		for (CreditNoteAttributeEntity attr : creditNote.getAttributes()) {
			result.add(attr.getName(), attr.getValue());
		}
		return result;
	}

	@Override
	public OrganizationModel getOrganization() {
		return new OrganizationAdapter(session, em, creditNote.getOrganization());
	}

	@Override
	public UBLExtensionsModel getUBLExtensions() {
		return new UBLExtensionsAdapter(session, em, creditNote.getUblExtensions());
	}

	@Override
	public void setUBLExtensions(UBLExtensionsModel value) {
		this.creditNote.setUblExtensions(UBLExtensionsAdapter.toEntity(value, em));
	}

	@Override
	public String getUBLVersionID() {
		return creditNote.getUblVersionID();
	}

	@Override
	public void setUBLVersionID(String value) {
		this.creditNote.setUblVersionID(value);
	}

	/**
	 * @return the customizationID
	 */
	@Override
	public String getCustomizationID() {
		return creditNote.getCustomizationID();
	}

	/**
	 * @param customizationID
	 *            the customizationID to set
	 */
	@Override
	public void setCustomizationID(String customizationID) {
		this.creditNote.setCustomizationID(customizationID);
	}

	/**
	 * @return the profileID
	 */
	@Override
	public String getProfileID() {
		return creditNote.getProfileID();
	}

	/**
	 * @param profileID
	 *            the profileID to set
	 */
	@Override
	public void setProfileID(String profileID) {
		this.creditNote.setProfileID(profileID);
	}

	/**
	 * @return the iD
	 */
	@Override
	public String getID() {
		return creditNote.getID();
	}

	/**
	 * @param iD
	 *            the iD to set
	 */
	@Override
	public void setID(String iD) {
		this.creditNote.setID(iD);
	}

	/**
	 * @return the copyIndicator
	 */
	@Override
	public boolean getCopyIndicator() {
		return creditNote.isCopyIndicator();
	}

	/**
	 * @param copyIndicator
	 *            the copyIndicator to set
	 */
	@Override
	public void setCopyIndicator(boolean copyIndicator) {
		this.creditNote.setCopyIndicator(copyIndicator);
	}

	/**
	 * @return the uuid
	 */
	@Override
	public String getUUID() {
		return creditNote.getUuid();
	}

	/**
	 * @param uuid
	 *            the uuid to set
	 */
	@Override
	public void setUUID(String uuid) {
		this.creditNote.setUuid(uuid);
	}

	/**
	 * @return the issueDate
	 */
	@Override
	public LocalDateTime getIssueDateTime() {
		return creditNote.getIssueDateTime();
	}

	/**
	 * @param issueDate
	 *            the issueDate to set
	 */
	@Override
	public void setIssueDateTime(LocalDateTime issueDateTime) {
		this.creditNote.setIssueDateTime(issueDateTime);
	}

	/**
	 * @return the note
	 */
	@Override
	public List<String> getNote() {
		return creditNote.getNote();
	}

	/**
	 * @param note
	 *            the note to set
	 */
	@Override
	public void setNote(List<String> note) {
		this.creditNote.setNote(note);
	}

	/**
	 * @return the taxPointDate
	 */
	@Override
	public LocalDate getTaxPointDate() {
		return creditNote.getTaxPointDate();
	}

	/**
	 * @param taxPointDate
	 *            the taxPointDate to set
	 */
	@Override
	public void setTaxPointDate(LocalDate taxPointDate) {
		this.creditNote.setTaxPointDate(taxPointDate);
	}

	/**
	 * @return the documentCurrencyCode
	 */
	@Override
	public String getDocumentCurrencyCode() {
		return creditNote.getDocumentCurrencyCode();
	}

	/**
	 * @param documentCurrencyCode
	 *            the documentCurrencyCode to set
	 */
	@Override
	public void setDocumentCurrencyCode(String documentCurrencyCode) {
		this.creditNote.setDocumentCurrencyCode(documentCurrencyCode);
	}

	/**
	 * @return the taxCurrencyCode
	 */
	@Override
	public String getTaxCurrencyCode() {
		return creditNote.getTaxCurrencyCode();
	}

	/**
	 * @param taxCurrencyCode
	 *            the taxCurrencyCode to set
	 */
	@Override
	public void setTaxCurrencyCode(String taxCurrencyCode) {
		this.creditNote.setTaxCurrencyCode(taxCurrencyCode);
	}

	/**
	 * @return the pricingCurrencyCode
	 */
	@Override
	public String getPricingCurrencyCode() {
		return creditNote.getPricingCurrencyCode();
	}

	/**
	 * @param pricingCurrencyCode
	 *            the pricingCurrencyCode to set
	 */
	@Override
	public void setPricingCurrencyCode(String pricingCurrencyCode) {
		this.creditNote.setPricingCurrencyCode(pricingCurrencyCode);
	}

	/**
	 * @return the paymentCurrencyCode
	 */
	@Override
	public String getPaymentCurrencyCode() {
		return creditNote.getPaymentCurrencyCode();
	}

	/**
	 * @param paymentCurrencyCode
	 *            the paymentCurrencyCode to set
	 */
	@Override
	public void setPaymentCurrencyCode(String paymentCurrencyCode) {
		this.creditNote.setPaymentCurrencyCode(paymentCurrencyCode);
	}

	/**
	 * @return the paymentAlternativeCurrencyCode
	 */
	@Override
	public String getPaymentAlternativeCurrencyCode() {
		return creditNote.getPaymentAlternativeCurrencyCode();
	}

	/**
	 * @param paymentAlternativeCurrencyCode
	 *            the paymentAlternativeCurrencyCode to set
	 */
	@Override
	public void setPaymentAlternativeCurrencyCode(String paymentAlternativeCurrencyCode) {
		this.creditNote.setPaymentAlternativeCurrencyCode(paymentAlternativeCurrencyCode);
	}

	/**
	 * @return the accountingCostCode
	 */
	@Override
	public String getAccountingCostCode() {
		return creditNote.getAccountingCostCode();
	}

	/**
	 * @param accountingCostCode
	 *            the accountingCostCode to set
	 */
	@Override
	public void setAccountingCostCode(String accountingCostCode) {
		this.creditNote.setAccountingCostCode(accountingCostCode);
	}

	/**
	 * @return the accountingCost
	 */
	@Override
	public String getAccountingCost() {
		return creditNote.getAccountingCost();
	}

	/**
	 * @param accountingCost
	 *            the accountingCost to set
	 */
	@Override
	public void setAccountingCost(String accountingCost) {
		this.creditNote.setAccountingCost(accountingCost);
	}

	/**
	 * @return the lineCountNumeric
	 */
	@Override
	public BigDecimal getLineCountNumeric() {
		return creditNote.getLineCountNumeric();
	}

	/**
	 * @param lineCountNumeric
	 *            the lineCountNumeric to set
	 */
	@Override
	public void setLineCountNumeric(BigDecimal lineCountNumeric) {
		this.creditNote.setLineCountNumeric(lineCountNumeric);
	}

	/**
	 * @return the creditNotePeriod
	 */
	@Override
	public List<PeriodModel> getInvoicePeriod() {
		return creditNote.getInvoicePeriod().stream().map(f -> new PeriodAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	/**
	 * @param creditNotePeriod
	 *            the creditNotePeriod to set
	 */
	@Override
	public void setInvoicePeriod(List<PeriodModel> creditNotePeriod) {
		List<PeriodEntity> entities = creditNotePeriod.stream().map(f -> PeriodAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		creditNote.setInvoicePeriod(entities);
	}

	/**
	 * @return the discrepancyResponse
	 */
	@Override
	public List<ResponseModel> getDiscrepancyResponse() {
		return creditNote.getDiscrepancyResponse().stream().map(f -> new ResponseAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	/**
	 * @param discrepancyResponse
	 *            the discrepancyResponse to set
	 */
	@Override
	public void setDiscrepancyResponse(List<ResponseModel> discrepancyResponse) {
		List<ResponseEntity> entities = discrepancyResponse.stream().map(f -> ResponseAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		creditNote.setDiscrepancyResponse(entities);
	}

	/**
	 * @return the orderReference
	 */
	@Override
	public OrderReferenceModel getOrderReference() {
		return new OrderReferenceAdapter(session, em, creditNote.getOrderReference());
	}

	/**
	 * @param orderReference
	 *            the orderReference to set
	 */
	@Override
	public void setOrderReference(OrderReferenceModel orderReference) {
		this.creditNote.setOrderReference(OrderReferenceAdapter.toEntity(orderReference, em));
	}

	/**
	 * @return the billingReference
	 */
	@Override
	public List<BillingReferenceModel> getBillingReference() {
		return creditNote.getBillingReference().stream().map(f -> new BillingReferenceAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	/**
	 * @param billingReference
	 *            the billingReference to set
	 */
	@Override
	public void setBillingReference(List<BillingReferenceModel> billingReference) {
		List<BillingReferenceEntity> entities = billingReference.stream()
				.map(f -> BillingReferenceAdapter.toEntity(f, em)).collect(Collectors.toList());
		creditNote.setBillingReference(entities);
	}

	/**
	 * @return the despatchDocumentReference
	 */
	@Override
	public List<DocumentReferenceModel> getDespatchDocumentReference() {
		return creditNote.getDespatchDocumentReference().stream().map(f -> new DocumentReferenceAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	/**
	 * @param despatchDocumentReference
	 *            the despatchDocumentReference to set
	 */
	@Override
	public void setDespatchDocumentReference(List<DocumentReferenceModel> despatchDocumentReference) {
		List<DocumentReferenceEntity> entities = despatchDocumentReference.stream()
				.map(f -> DocumentReferenceAdapter.toEntity(f, em)).collect(Collectors.toList());
		creditNote.setDespatchDocumentReference(entities);
	}

	/**
	 * @return the receiptDocumentReference
	 */
	@Override
	public List<DocumentReferenceModel> getReceiptDocumentReference() {
		return creditNote.getReceiptDocumentReference().stream().map(f -> new DocumentReferenceAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	/**
	 * @param receiptDocumentReference
	 *            the receiptDocumentReference to set
	 */
	@Override
	public void setReceiptDocumentReference(List<DocumentReferenceModel> receiptDocumentReference) {
		List<DocumentReferenceEntity> entities = receiptDocumentReference.stream()
				.map(f -> DocumentReferenceAdapter.toEntity(f, em)).collect(Collectors.toList());
		creditNote.setReceiptDocumentReference(entities);
	}

	/**
	 * @return the contractDocumentReference
	 */
	@Override
	public List<DocumentReferenceModel> getContractDocumentReference() {
		return creditNote.getContractDocumentReference().stream().map(f -> new DocumentReferenceAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	/**
	 * @param contractDocumentReference
	 *            the contractDocumentReference to set
	 */
	@Override
	public void setContractDocumentReference(List<DocumentReferenceModel> contractDocumentReference) {
		List<DocumentReferenceEntity> entities = contractDocumentReference.stream()
				.map(f -> DocumentReferenceAdapter.toEntity(f, em)).collect(Collectors.toList());
		creditNote.setContractDocumentReference(entities);
	}

	/**
	 * @return the additionalDocumentReference
	 */
	@Override
	public List<DocumentReferenceModel> getAdditionalDocumentReference() {
		return creditNote.getAdditionalDocumentReference().stream()
				.map(f -> new DocumentReferenceAdapter(session, em, f)).collect(Collectors.toList());
	}

	/**
	 * @param additionalDocumentReference
	 *            the additionalDocumentReference to set
	 */
	@Override
	public void setAdditionalDocumentReference(List<DocumentReferenceModel> additionalDocumentReference) {
		List<DocumentReferenceEntity> entities = additionalDocumentReference.stream()
				.map(f -> DocumentReferenceAdapter.toEntity(f, em)).collect(Collectors.toList());
		creditNote.setAdditionalDocumentReference(entities);
	}

	/**
	 * @return the signature
	 */
	@Override
	public List<SignatureModel> getSignature() {
		return creditNote.getSignature().stream().map(f -> new SignatureAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	/**
	 * @param signature
	 *            the signature to set
	 */
	@Override
	public void setSignature(List<SignatureModel> signature) {
		List<SignatureEntity> entities = signature.stream().map(f -> SignatureAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		creditNote.setSignature(entities);
	}

	/**
	 * @return the accountingSupplierParty
	 */
	@Override
	public SupplierPartyModel getAccountingSupplierParty() {
		return new SupplierPartyAdapter(session, em, creditNote.getAccountingSupplierParty());
	}

	/**
	 * @param accountingSupplierParty
	 *            the accountingSupplierParty to set
	 */
	@Override
	public void setAccountingSupplierParty(SupplierPartyModel accountingSupplierParty) {
		this.creditNote.setAccountingSupplierParty(SupplierPartyAdapter.toEntity(accountingSupplierParty, em));
	}

	/**
	 * @return the accountingCustomerParty
	 */
	@Override
	public CustomerPartyModel getAccountingCustomerParty() {
		return new CustomerPartyAdapter(session, em, creditNote.getAccountingCustomerParty());
	}

	/**
	 * @param accountingCustomerParty
	 *            the accountingCustomerParty to set
	 */
	@Override
	public void setAccountingCustomerParty(CustomerPartyModel accountingCustomerParty) {
		this.creditNote.setAccountingCustomerParty(CustomerPartyAdapter.toEntity(accountingCustomerParty, em));
	}

	/**
	 * @return the payeeParty
	 */
	@Override
	public PartyModel getPayeeParty() {
		return new PartyAdapter(session, em, creditNote.getPayeeParty());
	}

	/**
	 * @param payeeParty
	 *            the payeeParty to set
	 */
	@Override
	public void setPayeeParty(PartyModel payeeParty) {
		this.creditNote.setPayeeParty(PartyAdapter.toEntity(payeeParty, em));
	}

	/**
	 * @return the taxRepresentativeParty
	 */
	@Override
	public PartyModel getTaxRepresentativeParty() {
		return new PartyAdapter(session, em, creditNote.getTaxRepresentativeParty());
	}

	/**
	 * @param taxRepresentativeParty
	 *            the taxRepresentativeParty to set
	 */
	@Override
	public void setTaxRepresentativeParty(PartyModel taxRepresentativeParty) {
		this.creditNote.setTaxRepresentativeParty(PartyAdapter.toEntity(taxRepresentativeParty, em));
	}

	/**
	 * @return the taxExchangeRate
	 */
	@Override
	public ExchangeRateModel getTaxExchangeRate() {
		return new ExchangeRateAdapter(session, em, creditNote.getTaxExchangeRate());
	}

	/**
	 * @param taxExchangeRate
	 *            the taxExchangeRate to set
	 */
	@Override
	public void setTaxExchangeRate(ExchangeRateModel taxExchangeRate) {
		this.creditNote.setTaxExchangeRate(ExchangeRateAdapter.toEntity(taxExchangeRate, em));
	}

	/**
	 * @return the pricingExchangeRate
	 */
	@Override
	public ExchangeRateModel getPricingExchangeRate() {
		return new ExchangeRateAdapter(session, em, creditNote.getPricingExchangeRate());
	}

	/**
	 * @param pricingExchangeRate
	 *            the pricingExchangeRate to set
	 */
	@Override
	public void setPricingExchangeRate(ExchangeRateModel pricingExchangeRate) {
		this.creditNote.setPricingExchangeRate(ExchangeRateAdapter.toEntity(pricingExchangeRate, em));
	}

	/**
	 * @return the paymentExchangeRate
	 */
	@Override
	public ExchangeRateModel getPaymentExchangeRate() {
		return new ExchangeRateAdapter(session, em, creditNote.getPaymentExchangeRate());
	}

	/**
	 * @param paymentExchangeRate
	 *            the paymentExchangeRate to set
	 */
	@Override
	public void setPaymentExchangeRate(ExchangeRateModel paymentExchangeRate) {
		this.creditNote.setPaymentExchangeRate(ExchangeRateAdapter.toEntity(paymentExchangeRate, em));
	}

	/**
	 * @return the paymentAlternativeExchangeRate
	 */
	@Override
	public ExchangeRateModel getPaymentAlternativeExchangeRate() {
		return new ExchangeRateAdapter(session, em, creditNote.getPaymentAlternativeExchangeRate());
	}

	/**
	 * @param paymentAlternativeExchangeRate
	 *            the paymentAlternativeExchangeRate to set
	 */
	@Override
	public void setPaymentAlternativeExchangeRate(ExchangeRateModel paymentAlternativeExchangeRate) {
		this.creditNote
				.setPaymentAlternativeExchangeRate(ExchangeRateAdapter.toEntity(paymentAlternativeExchangeRate, em));
	}

	/**
	 * @return the taxTotal
	 */
	@Override
	public List<TaxTotalModel> getTaxTotal() {
		return creditNote.getTaxTotal().stream().map(f -> new TaxTotalAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	/**
	 * @param taxTotal
	 *            the taxTotal to set
	 */
	@Override
	public void setTaxTotal(List<TaxTotalModel> taxTotal) {
		List<TaxTotalEntity> entities = taxTotal.stream().map(f -> TaxTotalAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		creditNote.setTaxTotal(entities);
	}

	/**
	 * @return the creditNoteLine
	 */
	@Override
	public List<CreditNoteLineModel> getCreditNoteLine() {
		return creditNote.getCreditNoteLine().stream().map(f -> new CreditNoteLineAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	/**
	 * @param creditNoteLine
	 *            the creditNoteLine to set
	 */
	@Override
	public void setCreditNoteLine(List<CreditNoteLineModel> creditNoteLine) {
		List<CreditNoteLineEntity> entities = creditNoteLine.stream().map(f -> CreditNoteLineAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		creditNote.setCreditNoteLine(entities);
	}

	@Override
	public List<AllowanceChargeModel> getAllowanceCharge() {
		return creditNote.getAllowanceCharge().stream().map(f -> new AllowanceChargeAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setAllowanceCharge(List<AllowanceChargeModel> allowanceCharge) {
		List<AllowanceChargeEntity> entities = allowanceCharge.stream().map(f -> AllowanceChargeAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		creditNote.setAllowanceCharge(entities);
	}

	@Override
	public MonetaryTotalModel getLegalMonetaryTotal() {
		return new MonetaryTotalAdapter(session, em, creditNote.getLegalMonetaryTotal());
	}

	@Override
	public void setLegalMonetaryTotal(MonetaryTotalModel value) {
		creditNote.setLegalMonetaryTotal(MonetaryTotalAdapter.toEntity(value, em));
	}

	@Override
	public ResponseModel addDiscrepancyResponse() {
		List<ResponseEntity> entities = creditNote.getDiscrepancyResponse();

		ResponseEntity entity = new ResponseEntity();
		entities.add(entity);
		return new ResponseAdapter(session, em, entity);
	}

	@Override
	public CreditNoteLineModel addCreditNoteLine() {
		List<CreditNoteLineEntity> entities = creditNote.getCreditNoteLine();

		CreditNoteLineEntity entity = new CreditNoteLineEntity();
		entities.add(entity);
		return new CreditNoteLineAdapter(session, em, entity);
	}

	@Override
	public TaxTotalModel addTaxTotal() {
		List<TaxTotalEntity> entities = creditNote.getTaxTotal();

		TaxTotalEntity entity = new TaxTotalEntity();
		entities.add(entity);
		return new TaxTotalAdapter(session, em, entity);
	}

	@Override
	public DocumentReferenceModel addDespatchDocumentReference() {
		List<DocumentReferenceEntity> entities = creditNote.getDespatchDocumentReference();

		DocumentReferenceEntity entity = new DocumentReferenceEntity();
		entities.add(entity);
		return new DocumentReferenceAdapter(session, em, entity);
	}

	@Override
	public SignatureModel addSignature() {
		List<SignatureEntity> entities = creditNote.getSignature();

		SignatureEntity entity = new SignatureEntity();
		entities.add(entity);
		return new SignatureAdapter(session, em, entity);
	}

	@Override
	public Byte[] getXmlDocument() {
		return creditNote.getXmlDocument();
	}

	@Override
	public void setXmlDocument(Byte[] value) {
		creditNote.setXmlDocument(value);

	}

	public static CreditNoteEntity toEntity(CreditNoteModel model, EntityManager em) {
		if (model instanceof CreditNoteAdapter) {
			return ((CreditNoteAdapter) model).getEntity();
		}
		return em.getReference(CreditNoteEntity.class, model.getId());
	}

	@Override
	public List<RequiredActionDocument> getRequeridAction() {
		return creditNote.getRequeridAction();
	}

	@Override
	public void setRequeridAction(List<RequiredActionDocument> requeridAction) {
		creditNote.setRequeridAction(requeridAction);
	}

	@Override
	public boolean removeRequeridAction(RequiredActionDocument requeridAction) {
		boolean result =creditNote.getRequeridAction().remove(requeridAction);	
		return result;
	}

}
