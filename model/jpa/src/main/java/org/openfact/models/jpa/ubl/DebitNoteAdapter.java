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
import org.openfact.models.enums.RequeridActionDocument;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.OrganizationAdapter;
import org.openfact.models.jpa.entities.ubl.DebitNoteAttributeEntity;
import org.openfact.models.jpa.entities.ubl.DebitNoteEntity;
import org.openfact.models.jpa.entities.ubl.common.BillingReferenceEntity;
import org.openfact.models.jpa.entities.ubl.common.DebitNoteLineEntity;
import org.openfact.models.jpa.entities.ubl.common.DocumentReferenceEntity;
import org.openfact.models.jpa.entities.ubl.common.PaymentEntity;
import org.openfact.models.jpa.entities.ubl.common.PeriodEntity;
import org.openfact.models.jpa.entities.ubl.common.ResponseEntity;
import org.openfact.models.jpa.entities.ubl.common.SignatureEntity;
import org.openfact.models.jpa.entities.ubl.common.TaxTotalEntity;
import org.openfact.models.jpa.ubl.common.BillingReferenceAdapter;
import org.openfact.models.jpa.ubl.common.CustomerPartyAdapter;
import org.openfact.models.jpa.ubl.common.DebitNoteLineAdapter;
import org.openfact.models.jpa.ubl.common.DocumentReferenceAdapter;
import org.openfact.models.jpa.ubl.common.ExchangeRateAdapter;
import org.openfact.models.jpa.ubl.common.MonetaryTotalAdapter;
import org.openfact.models.jpa.ubl.common.OrderReferenceAdapter;
import org.openfact.models.jpa.ubl.common.PartyAdapter;
import org.openfact.models.jpa.ubl.common.PaymentAdapter;
import org.openfact.models.jpa.ubl.common.PeriodAdapter;
import org.openfact.models.jpa.ubl.common.ResponseAdapter;
import org.openfact.models.jpa.ubl.common.SignatureAdapter;
import org.openfact.models.jpa.ubl.common.SupplierPartyAdapter;
import org.openfact.models.jpa.ubl.common.TaxTotalAdapter;
import org.openfact.models.jpa.ubl.common.UBLExtensionsAdapter;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.common.BillingReferenceModel;
import org.openfact.models.ubl.common.CustomerPartyModel;
import org.openfact.models.ubl.common.DebitNoteLineModel;
import org.openfact.models.ubl.common.DocumentReferenceModel;
import org.openfact.models.ubl.common.ExchangeRateModel;
import org.openfact.models.ubl.common.MonetaryTotalModel;
import org.openfact.models.ubl.common.OrderReferenceModel;
import org.openfact.models.ubl.common.PartyModel;
import org.openfact.models.ubl.common.PaymentModel;
import org.openfact.models.ubl.common.PeriodModel;
import org.openfact.models.ubl.common.ResponseModel;
import org.openfact.models.ubl.common.SignatureModel;
import org.openfact.models.ubl.common.SupplierPartyModel;
import org.openfact.models.ubl.common.TaxTotalModel;
import org.openfact.models.ubl.common.UBLExtensionsModel;
import org.openfact.models.utils.OpenfactModelUtils;

public class DebitNoteAdapter implements DebitNoteModel, JpaModel<DebitNoteEntity> {

	protected static final Logger logger = Logger.getLogger(DebitNoteAdapter.class);

	protected OrganizationModel organization;
	protected DebitNoteEntity debitNote;
	protected EntityManager em;
	protected OpenfactSession session;

	public DebitNoteAdapter(OpenfactSession session, OrganizationModel organization, EntityManager em,
			DebitNoteEntity debitNote) {
		this.organization = organization;
		this.session = session;
		this.em = em;
		this.debitNote = debitNote;
	}

	@Override
	public DebitNoteEntity getEntity() {
		return debitNote;
	}

	/**
	 * @return the id
	 */
	@Override
	public String getId() {
		return debitNote.getId();
	}

	@Override
	public void setSingleAttribute(String name, String value) {
		String firstExistingAttrId = null;
		List<DebitNoteAttributeEntity> toRemove = new ArrayList<>();
		for (DebitNoteAttributeEntity attr : debitNote.getAttributes()) {
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
			Query query = em.createNamedQuery("deleteDebitNoteAttributesOtherThan");
			query.setParameter("attrId", firstExistingAttrId);
			query.setParameter("debitNoteId", debitNote.getId());
			int numUpdated = query.executeUpdate();

			// Remove attribute from local entity
			debitNote.getAttributes().removeAll(toRemove);
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
		DebitNoteAttributeEntity attr = new DebitNoteAttributeEntity();
		attr.setId(OpenfactModelUtils.generateId());
		attr.setName(name);
		attr.setValue(value);
		attr.setDebitNote(debitNote);
		em.persist(attr);
		debitNote.getAttributes().add(attr);
	}

	@Override
	public void removeAttribute(String name) {
		// OPENFACT-3296 : Remove attribute through HQL to avoid
		// StaleUpdateException
		Query query = em.createNamedQuery("deleteDebitNoteAttributesByNameAndDebitNote");
		query.setParameter("name", name);
		query.setParameter("debitNoteId", debitNote.getId());
		int numUpdated = query.executeUpdate();

		// Also remove attributes from local debitNote entity
		List<DebitNoteAttributeEntity> toRemove = new ArrayList<>();
		for (DebitNoteAttributeEntity attr : debitNote.getAttributes()) {
			if (attr.getName().equals(name)) {
				toRemove.add(attr);
			}
		}
		debitNote.getAttributes().removeAll(toRemove);
	}

	@Override
	public String getFirstAttribute(String name) {
		for (DebitNoteAttributeEntity attr : debitNote.getAttributes()) {
			if (attr.getName().equals(name)) {
				return attr.getValue();
			}
		}
		return null;
	}

	@Override
	public List<String> getAttribute(String name) {
		List<String> result = new ArrayList<>();
		for (DebitNoteAttributeEntity attr : debitNote.getAttributes()) {
			if (attr.getName().equals(name)) {
				result.add(attr.getValue());
			}
		}
		return result;
	}

	@Override
	public Map<String, List<String>> getAttributes() {
		MultivaluedHashMap<String, String> result = new MultivaluedHashMap<>();
		for (DebitNoteAttributeEntity attr : debitNote.getAttributes()) {
			result.add(attr.getName(), attr.getValue());
		}
		return result;
	}

	@Override
	public OrganizationModel getOrganization() {
		return new OrganizationAdapter(session, em, debitNote.getOrganization());
	}

	@Override
	public UBLExtensionsModel getUBLExtensions() {
		return new UBLExtensionsAdapter(session, em, debitNote.getUblExtensions());
	}

	@Override
	public void setUBLExtensions(UBLExtensionsModel value) {
		this.debitNote.setUblExtensions(UBLExtensionsAdapter.toEntity(value, em));
	}

	@Override
	public String getUBLVersionID() {
		return debitNote.getUblVersionID();
	}

	@Override
	public void setUBLVersionID(String value) {
		this.debitNote.setUblVersionID(value);
	}

	/**
	 * @return the customizationID
	 */
	@Override
	public String getCustomizationID() {
		return debitNote.getCustomizationID();
	}

	/**
	 * @param customizationID
	 *            the customizationID to set
	 */
	@Override
	public void setCustomizationID(String customizationID) {
		this.debitNote.setCustomizationID(customizationID);
	}

	/**
	 * @return the profileID
	 */
	@Override
	public String getProfileID() {
		return debitNote.getProfileID();
	}

	/**
	 * @param profileID
	 *            the profileID to set
	 */
	@Override
	public void setProfileID(String profileID) {
		this.debitNote.setProfileID(profileID);
	}

	/**
	 * @return the iD
	 */
	@Override
	public String getID() {
		return debitNote.getID();
	}

	/**
	 * @param iD
	 *            the iD to set
	 */
	@Override
	public void setID(String iD) {
		this.debitNote.setID(iD);
	}

	/**
	 * @return the copyIndicator
	 */
	@Override
	public boolean getCopyIndicator() {
		return debitNote.isCopyIndicator();
	}

	/**
	 * @param copyIndicator
	 *            the copyIndicator to set
	 */
	@Override
	public void setCopyIndicator(boolean copyIndicator) {
		this.debitNote.setCopyIndicator(copyIndicator);
	}

	/**
	 * @return the uuid
	 */
	@Override
	public String getUUID() {
		return debitNote.getUuid();
	}

	/**
	 * @param uuid
	 *            the uuid to set
	 */
	@Override
	public void setUUID(String uuid) {
		this.debitNote.setUuid(uuid);
	}

	/**
	 * @return the issueDate
	 */
	@Override
	public LocalDateTime getIssueDateTime() {
		return debitNote.getIssueDateTime();
	}

	/**
	 * @param issueDate
	 *            the issueDate to set
	 */
	@Override
	public void setIssueDateTime(LocalDateTime issueDateTime) {
		this.debitNote.setIssueDateTime(issueDateTime);
	}

	/**
	 * @return the note
	 */
	@Override
	public List<String> getNote() {
		return debitNote.getNote();
	}

	/**
	 * @param note
	 *            the note to set
	 */
	@Override
	public void setNote(List<String> note) {
		this.debitNote.setNote(note);
	}

	/**
	 * @return the taxPointDate
	 */
	@Override
	public LocalDate getTaxPointDate() {
		return debitNote.getTaxPointDate();
	}

	/**
	 * @param taxPointDate
	 *            the taxPointDate to set
	 */
	@Override
	public void setTaxPointDate(LocalDate taxPointDate) {
		this.debitNote.setTaxPointDate(taxPointDate);
	}

	/**
	 * @return the documentCurrencyCode
	 */
	@Override
	public String getDocumentCurrencyCode() {
		return debitNote.getDocumentCurrencyCode();
	}

	/**
	 * @param documentCurrencyCode
	 *            the documentCurrencyCode to set
	 */
	@Override
	public void setDocumentCurrencyCode(String documentCurrencyCode) {
		this.debitNote.setDocumentCurrencyCode(documentCurrencyCode);
	}

	/**
	 * @return the taxCurrencyCode
	 */
	@Override
	public String getTaxCurrencyCode() {
		return debitNote.getTaxCurrencyCode();
	}

	/**
	 * @param taxCurrencyCode
	 *            the taxCurrencyCode to set
	 */
	@Override
	public void setTaxCurrencyCode(String taxCurrencyCode) {
		this.debitNote.setTaxCurrencyCode(taxCurrencyCode);
	}

	/**
	 * @return the pricingCurrencyCode
	 */
	@Override
	public String getPricingCurrencyCode() {
		return debitNote.getPricingCurrencyCode();
	}

	/**
	 * @param pricingCurrencyCode
	 *            the pricingCurrencyCode to set
	 */
	@Override
	public void setPricingCurrencyCode(String pricingCurrencyCode) {
		this.debitNote.setPricingCurrencyCode(pricingCurrencyCode);
	}

	/**
	 * @return the paymentCurrencyCode
	 */
	@Override
	public String getPaymentCurrencyCode() {
		return debitNote.getPaymentCurrencyCode();
	}

	/**
	 * @param paymentCurrencyCode
	 *            the paymentCurrencyCode to set
	 */
	@Override
	public void setPaymentCurrencyCode(String paymentCurrencyCode) {
		this.debitNote.setPaymentCurrencyCode(paymentCurrencyCode);
	}

	/**
	 * @return the paymentAlternativeCurrencyCode
	 */
	@Override
	public String getPaymentAlternativeCurrencyCode() {
		return debitNote.getPaymentAlternativeCurrencyCode();
	}

	/**
	 * @param paymentAlternativeCurrencyCode
	 *            the paymentAlternativeCurrencyCode to set
	 */
	@Override
	public void setPaymentAlternativeCurrencyCode(String paymentAlternativeCurrencyCode) {
		this.debitNote.setPaymentAlternativeCurrencyCode(paymentAlternativeCurrencyCode);
	}

	/**
	 * @return the accountingCostCode
	 */
	@Override
	public String getAccountingCostCode() {
		return debitNote.getAccountingCostCode();
	}

	/**
	 * @param accountingCostCode
	 *            the accountingCostCode to set
	 */
	@Override
	public void setAccountingCostCode(String accountingCostCode) {
		this.debitNote.setAccountingCostCode(accountingCostCode);
	}

	/**
	 * @return the accountingCost
	 */
	@Override
	public String getAccountingCost() {
		return debitNote.getAccountingCost();
	}

	/**
	 * @param accountingCost
	 *            the accountingCost to set
	 */
	@Override
	public void setAccountingCost(String accountingCost) {
		this.debitNote.setAccountingCost(accountingCost);
	}

	/**
	 * @return the lineCountNumeric
	 */
	@Override
	public BigDecimal getLineCountNumeric() {
		return debitNote.getLineCountNumeric();
	}

	/**
	 * @param lineCountNumeric
	 *            the lineCountNumeric to set
	 */
	@Override
	public void setLineCountNumeric(BigDecimal lineCountNumeric) {
		this.debitNote.setLineCountNumeric(lineCountNumeric);
	}

	/**
	 * @return the invoicePeriod
	 */
	@Override
	public List<PeriodModel> getInvoicePeriod() {
		return debitNote.getInvoicePeriod().stream().map(f -> new PeriodAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	/**
	 * @param invoicePeriod
	 *            the invoicePeriod to set
	 */
	@Override
	public void setInvoicePeriod(List<PeriodModel> invoicePeriod) {
		List<PeriodEntity> entities = invoicePeriod.stream().map(f -> PeriodAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		debitNote.setInvoicePeriod(entities);
	}

	/**
	 * @return the discrepancyResponse
	 */
	@Override
	public List<ResponseModel> getDiscrepancyResponse() {
		return debitNote.getDiscrepancyResponse().stream().map(f -> new ResponseAdapter(session, em, f))
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
		debitNote.setDiscrepancyResponse(entities);
	}

	/**
	 * @return the orderReference
	 */
	@Override
	public OrderReferenceModel getOrderReference() {
		return new OrderReferenceAdapter(session, em, debitNote.getOrderReference());
	}

	/**
	 * @param orderReference
	 *            the orderReference to set
	 */
	@Override
	public void setOrderReference(OrderReferenceModel orderReference) {
		this.debitNote.setOrderReference(OrderReferenceAdapter.toEntity(orderReference, em));
	}

	/**
	 * @return the billingReference
	 */
	@Override
	public List<BillingReferenceModel> getBillingReference() {
		return debitNote.getBillingReference().stream().map(f -> new BillingReferenceAdapter(session, em, f))
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
		debitNote.setBillingReference(entities);
	}

	/**
	 * @return the despatchDocumentReference
	 */
	@Override
	public List<DocumentReferenceModel> getDespatchDocumentReference() {
		return debitNote.getDespatchDocumentReference().stream().map(f -> new DocumentReferenceAdapter(session, em, f))
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
		debitNote.setDespatchDocumentReference(entities);
	}

	/**
	 * @return the receiptDocumentReference
	 */
	@Override
	public List<DocumentReferenceModel> getReceiptDocumentReference() {
		return debitNote.getReceiptDocumentReference().stream().map(f -> new DocumentReferenceAdapter(session, em, f))
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
		debitNote.setReceiptDocumentReference(entities);
	}

	/**
	 * @return the contractDocumentReference
	 */
	@Override
	public List<DocumentReferenceModel> getContractDocumentReference() {
		return debitNote.getContractDocumentReference().stream().map(f -> new DocumentReferenceAdapter(session, em, f))
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
		debitNote.setContractDocumentReference(entities);
	}

	/**
	 * @return the additionalDocumentReference
	 */
	@Override
	public List<DocumentReferenceModel> getAdditionalDocumentReference() {
		return debitNote.getAdditionalDocumentReference().stream()
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
		debitNote.setAdditionalDocumentReference(entities);
	}

	/**
	 * @return the signature
	 */
	@Override
	public List<SignatureModel> getSignature() {
		return debitNote.getSignature().stream().map(f -> new SignatureAdapter(session, em, f))
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
		debitNote.setSignature(entities);
	}

	/**
	 * @return the accountingSupplierParty
	 */
	@Override
	public SupplierPartyModel getAccountingSupplierParty() {
		return new SupplierPartyAdapter(session, em, debitNote.getAccountingSupplierParty());
	}

	/**
	 * @param accountingSupplierParty
	 *            the accountingSupplierParty to set
	 */
	@Override
	public void setAccountingSupplierParty(SupplierPartyModel accountingSupplierParty) {
		this.debitNote.setAccountingSupplierParty(SupplierPartyAdapter.toEntity(accountingSupplierParty, em));
	}

	/**
	 * @return the accountingCustomerParty
	 */
	@Override
	public CustomerPartyModel getAccountingCustomerParty() {
		return new CustomerPartyAdapter(session, em, debitNote.getAccountingCustomerParty());
	}

	/**
	 * @param accountingCustomerParty
	 *            the accountingCustomerParty to set
	 */
	@Override
	public void setAccountingCustomerParty(CustomerPartyModel accountingCustomerParty) {
		this.debitNote.setAccountingCustomerParty(CustomerPartyAdapter.toEntity(accountingCustomerParty, em));
	}

	/**
	 * @return the payeeParty
	 */
	@Override
	public PartyModel getPayeeParty() {
		return new PartyAdapter(session, em, debitNote.getPayeeParty());
	}

	/**
	 * @param payeeParty
	 *            the payeeParty to set
	 */
	@Override
	public void setPayeeParty(PartyModel payeeParty) {
		this.debitNote.setPayeeParty(PartyAdapter.toEntity(payeeParty, em));
	}

	/**
	 * @return the taxRepresentativeParty
	 */
	@Override
	public PartyModel getTaxRepresentativeParty() {
		return new PartyAdapter(session, em, debitNote.getTaxRepresentativeParty());
	}

	/**
	 * @param taxRepresentativeParty
	 *            the taxRepresentativeParty to set
	 */
	@Override
	public void setTaxRepresentativeParty(PartyModel taxRepresentativeParty) {
		this.debitNote.setTaxRepresentativeParty(PartyAdapter.toEntity(taxRepresentativeParty, em));
	}

	/**
	 * @return the prepaidPayment
	 */
	@Override
	public List<PaymentModel> getPrepaidPayment() {
		return debitNote.getPrepaidPayment().stream().map(f -> new PaymentAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	/**
	 * @param prepaidPayment
	 *            the prepaidPayment to set
	 */
	@Override
	public void setPrepaidPayment(List<PaymentModel> prepaidPayment) {
		List<PaymentEntity> entities = prepaidPayment.stream().map(f -> PaymentAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		debitNote.setPrepaidPayment(entities);
	}

	/**
	 * @return the taxExchangeRate
	 */
	@Override
	public ExchangeRateModel getTaxExchangeRate() {
		return new ExchangeRateAdapter(session, em, debitNote.getTaxExchangeRate());
	}

	/**
	 * @param taxExchangeRate
	 *            the taxExchangeRate to set
	 */
	@Override
	public void setTaxExchangeRate(ExchangeRateModel taxExchangeRate) {
		this.debitNote.setTaxExchangeRate(ExchangeRateAdapter.toEntity(taxExchangeRate, em));
	}

	/**
	 * @return the pricingExchangeRate
	 */
	@Override
	public ExchangeRateModel getPricingExchangeRate() {
		return new ExchangeRateAdapter(session, em, debitNote.getPricingExchangeRate());
	}

	/**
	 * @param pricingExchangeRate
	 *            the pricingExchangeRate to set
	 */
	@Override
	public void setPricingExchangeRate(ExchangeRateModel pricingExchangeRate) {
		this.debitNote.setPricingExchangeRate(ExchangeRateAdapter.toEntity(pricingExchangeRate, em));
	}

	/**
	 * @return the paymentExchangeRate
	 */
	@Override
	public ExchangeRateModel getPaymentExchangeRate() {
		return new ExchangeRateAdapter(session, em, debitNote.getPaymentExchangeRate());
	}

	/**
	 * @param paymentExchangeRate
	 *            the paymentExchangeRate to set
	 */
	@Override
	public void setPaymentExchangeRate(ExchangeRateModel paymentExchangeRate) {
		this.debitNote.setPaymentExchangeRate(ExchangeRateAdapter.toEntity(paymentExchangeRate, em));
	}

	/**
	 * @return the paymentAlternativeExchangeRate
	 */
	@Override
	public ExchangeRateModel getPaymentAlternativeExchangeRate() {
		return new ExchangeRateAdapter(session, em, debitNote.getPaymentAlternativeExchangeRate());
	}

	/**
	 * @param paymentAlternativeExchangeRate
	 *            the paymentAlternativeExchangeRate to set
	 */
	@Override
	public void setPaymentAlternativeExchangeRate(ExchangeRateModel paymentAlternativeExchangeRate) {
		this.debitNote
				.setPaymentAlternativeExchangeRate(ExchangeRateAdapter.toEntity(paymentAlternativeExchangeRate, em));
	}

	/**
	 * @return the taxTotal
	 */
	@Override
	public List<TaxTotalModel> getTaxTotal() {
		return debitNote.getTaxTotal().stream().map(f -> new TaxTotalAdapter(session, em, f))
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
		debitNote.setTaxTotal(entities);
	}

	/**
	 * @return the requestedMonetaryTotal
	 */
	@Override
	public MonetaryTotalModel getRequestedMonetaryTotal() {
		return new MonetaryTotalAdapter(session, em, debitNote.getRequestedMonetaryTotal());
	}

	/**
	 * @param requestedMonetaryTotal
	 *            the requestedMonetaryTotal to set
	 */
	@Override
	public void setRequestedMonetaryTotal(MonetaryTotalModel requestedMonetaryTotal) {
		this.debitNote.setRequestedMonetaryTotal(MonetaryTotalAdapter.toEntity(requestedMonetaryTotal, em));
	}

	/**
	 * @return the debitNoteLine
	 */
	@Override
	public List<DebitNoteLineModel> getDebitNoteLine() {
		return debitNote.getDebitNoteLine().stream().map(f -> new DebitNoteLineAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	/**
	 * @param debitNoteLine
	 *            the debitNoteLine to set
	 */
	@Override
	public void setDebitNoteLine(List<DebitNoteLineModel> debitNoteLine) {
		List<DebitNoteLineEntity> entities = debitNoteLine.stream().map(f -> DebitNoteLineAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		debitNote.setDebitNoteLine(entities);
	}

	@Override
	public ResponseModel addDiscrepancyResponse() {
		List<ResponseEntity> entities = debitNote.getDiscrepancyResponse();

		ResponseEntity entity = new ResponseEntity();
		entities.add(entity);
		return new ResponseAdapter(session, em, entity);
	}

	@Override
	public DebitNoteLineModel addDebitNoteLine() {
		List<DebitNoteLineEntity> entities = debitNote.getDebitNoteLine();

		DebitNoteLineEntity entity = new DebitNoteLineEntity();
		entities.add(entity);
		return new DebitNoteLineAdapter(session, em, entity);
	}

	@Override
	public TaxTotalModel addTaxTotal() {
		List<TaxTotalEntity> entities = debitNote.getTaxTotal();

		TaxTotalEntity entity = new TaxTotalEntity();
		entities.add(entity);
		return new TaxTotalAdapter(session, em, entity);
	}

	@Override
	public BillingReferenceModel addBillingReference() {
		List<BillingReferenceEntity> entities = debitNote.getBillingReference();

		BillingReferenceEntity entity = new BillingReferenceEntity();
		entities.add(entity);
		return new BillingReferenceAdapter(session, em, entity);
	}

	@Override
	public DocumentReferenceModel addDespatchDocumentReference() {
		List<DocumentReferenceEntity> entities = debitNote.getDespatchDocumentReference();

		DocumentReferenceEntity entity = new DocumentReferenceEntity();
		entities.add(entity);
		return new DocumentReferenceAdapter(session, em, entity);
	}

	@Override
	public SignatureModel addSignature() {
		List<SignatureEntity> entities = debitNote.getSignature();

		SignatureEntity entity = new SignatureEntity();
		entities.add(entity);
		return new SignatureAdapter(session, em, entity);
	}

	@Override
	public Byte[] getXmlDoument() {
		return debitNote.getXmlDocument();
	}

	@Override
	public void setXmlDocument(Byte[] value) {
		debitNote.setXmlDocument(value);

	}

	public static DebitNoteEntity toEntity(DebitNoteModel model, EntityManager em) {
		if (model instanceof DebitNoteAdapter) {
			return ((DebitNoteAdapter) model).getEntity();
		}
		return em.getReference(DebitNoteEntity.class, model.getId());
	}

	@Override
	public List<RequeridActionDocument> getRequeridAction() {
		return debitNote.getRequeridAction();
	}

	@Override
	public void setRequeridAction(List<RequeridActionDocument> requeridAction) {
		debitNote.setRequeridAction(requeridAction);
	}

	@Override
	public boolean removeRequeridAction(RequeridActionDocument requeridAction) {
		boolean result =debitNote.getRequeridAction().remove(requeridAction);	
		return result;
	}

}
