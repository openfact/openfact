package org.openfact.models.jpa.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.CurrencyModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.CreditNoteEntity;
import org.openfact.models.jpa.entities.ubl.common.BillingReferenceEntity;
import org.openfact.models.jpa.entities.ubl.common.CreditNoteLineEntity;
import org.openfact.models.jpa.entities.ubl.common.DocumentReferenceEntity;
import org.openfact.models.jpa.entities.ubl.common.PeriodEntity;
import org.openfact.models.jpa.entities.ubl.common.ResponseEntity;
import org.openfact.models.jpa.entities.ubl.common.SignatureEntity;
import org.openfact.models.jpa.entities.ubl.common.TaxCategoryEntity;
import org.openfact.models.jpa.ubl.common.BillingReferenceAdapter;
import org.openfact.models.jpa.ubl.common.CountryAdapter;
import org.openfact.models.jpa.ubl.common.DocumentReferenceAdapter;
import org.openfact.models.jpa.ubl.common.OrderReferenceAdapter;
import org.openfact.models.jpa.ubl.common.PeriodAdapter;
import org.openfact.models.jpa.ubl.common.ResponseAdapter;
import org.openfact.models.jpa.ubl.common.SignatureAdapter;
import org.openfact.models.jpa.ubl.common.TaxCategoryAdapter;
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

public class CreditNoteAdapter implements CreditNoteModel, JpaModel<CreditNoteEntity> {

	protected static final Logger logger = Logger.getLogger(CreditNoteAdapter.class);

	protected OrganizationModel organization;
	protected CreditNoteEntity creditNote;
	protected EntityManager em;
	protected OpenfactSession session;

	public CreditNoteAdapter(OrganizationModel organization, OpenfactSession session, EntityManager em,
			CreditNoteEntity invoice) {
		this.organization = organization;
		this.session = session;
		this.em = em;
		this.creditNote = invoice;
	}

	@Override
	public CreditNoteEntity getEntity() {
		return creditNote;
	}

	@Override
	public UBLExtensionsModel getUBLExtensions() {
		return new UBLExtensionsAdapter(session, em, creditNote.getUBLExtensions());

	}

	@Override
	public void setUBLExtensions(UBLExtensionsModel value) {
		creditNote.setUBLExtensions(UBLExtensionsAdapter.toEntity(value, em));
	}

	@Override
	public String getUBLVersionID() {
		return creditNote.getUBLVersionID();
	}

	@Override
	public void setUBLVersionID(String value) {
		creditNote.setUBLVersionID(value);
	}

	@Override
	public String getCustomizationID() {
		return creditNote.getCustomizationID();
	}

	@Override
	public void setCustomizationID(String value) {
		creditNote.setCustomizationID(value);
	}

	@Override
	public String getProfileID() {
		return creditNote.getProfileID();
	}

	@Override
	public void setProfileID(String value) {
		creditNote.setProfileID(value);
	}

	@Override
	public String getID() {
		return creditNote.getID();
	}

	@Override
	public void setID(String value) {
		creditNote.setID(value);
	}

	@Override
	public boolean getCopyIndicator() {
		return creditNote.getCopyIndicator();
	}

	@Override
	public void setCopyIndicator(boolean value) {
		creditNote.setCopyIndicator(value);
	}

	@Override
	public String getUUID() {
		return creditNote.getUUID();
	}

	@Override
	public void setUUID(String value) {
		creditNote.setUUID(value);
	}

	@Override
	public LocalDate getIssueDate() {
		return creditNote.getIssueDate();
	}

	@Override
	public void setIssueDate(LocalDate value) {
		creditNote.setIssueDate(value);
	}

	@Override
	public LocalTime getIssueTime() {
		return creditNote.getIssueTime();
	}

	@Override
	public void setIssueTime(LocalTime value) {
		creditNote.setIssueTime(value);
	}

	@Override
	public LocalDate getTaxPointDate() {
		return creditNote.getTaxPointDate();
	}

	@Override
	public void setTaxPointDate(LocalDate value) {
		creditNote.setTaxPointDate(value);
	}

	@Override
	public List<String> getNote() {
		return creditNote.getNote();
	}

	@Override
	public void setNote(List<String> note) {
		creditNote.setNote(note);
	}

	@Override
	public String getDocumentCurrencyCode() {
		return creditNote.getDocumentCurrencyCode();
	}

	@Override
	public void setDocumentCurrencyCode(String value) {
		creditNote.setDocumentCurrencyCode(value);
	}

	@Override
	public String getTaxCurrencyCode() {
		return creditNote.getTaxCurrencyCode();
	}

	@Override
	public void setTaxCurrencyCode(String value) {
		creditNote.setTaxCurrencyCode(value);
	}

	@Override
	public String getPricingCurrencyCode() {
		// TODO Auto-generated method stub
		return creditNote.getPricingCurrencyCode();
	}

	@Override
	public void setPricingCurrencyCode(String value) {
		// TODO Auto-generated method stub
		creditNote.setPricingCurrencyCode(value);
	}

	@Override
	public String getPaymentCurrencyCode() {
		// TODO Auto-generated method stub
		return creditNote.getPaymentCurrencyCode();
	}

	@Override
	public void setPaymentCurrencyCode(String value) {
		// TODO Auto-generated method stub
		creditNote.setPaymentCurrencyCode(value);
	}

	@Override
	public String getPaymentAlternativeCurrencyCode() {
		// TODO Auto-generated method stub
		return creditNote.getPaymentAlternativeCurrencyCode();
	}

	@Override
	public void setPaymentAlternativeCurrencyCode(String value) {
		// TODO Auto-generated method stub
		creditNote.setPaymentAlternativeCurrencyCode(value);
	}

	@Override
	public String getAccountingCostCode() {
		// TODO Auto-generated method stub
		return creditNote.getAccountingCostCode();
	}

	@Override
	public void setAccountingCostCode(String value) {
		// TODO Auto-generated method stub
		creditNote.setAccountingCostCode(value);
	}

	@Override
	public String getAccountingCost() {
		// TODO Auto-generated method stub
		return creditNote.getAccountingCost();
	}

	@Override
	public void setAccountingCost(String value) {
		// TODO Auto-generated method stub
		creditNote.setAccountingCost(value);
	}

	@Override
	public BigDecimal getLineCountNumeric() {
		// TODO Auto-generated method stub
		return creditNote.getLineCountNumeric();
	}

	@Override
	public void setLineCountNumeric(BigDecimal value) {
		// TODO Auto-generated method stub
		creditNote.setLineCountNumeric(value);
	}

	@Override
	public List<PeriodModel> getInvoicePeriod() {
		return creditNote.getInvoicePeriod().stream().map(f -> new PeriodAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setInvoicePeriod(List<PeriodModel> invoicePeriod) {
		List<PeriodEntity> entities = invoicePeriod.stream().map(f -> PeriodAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		creditNote.setInvoicePeriod(entities);
	}

	@Override
	public List<ResponseModel> getDiscrepancyResponse() {
		return creditNote.getDiscrepancyResponse().stream().map(f -> new ResponseAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setDiscrepancyResponse(List<ResponseModel> discrepancyResponse) {
		List<ResponseEntity> entities = discrepancyResponse.stream().map(f -> ResponseAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		creditNote.setDiscrepancyResponse(entities);
	}

	@Override
	public OrderReferenceModel getOrderReference() {
		return new OrderReferenceAdapter(session, em, creditNote.getOrderReference());
	}

	@Override
	public void setOrderReference(OrderReferenceModel value) {
		creditNote.setOrderReference(OrderReferenceAdapter.toEntity(value, em));
	}

	@Override
	public List<BillingReferenceModel> getBillingReference() {
		return creditNote.getBillingReference().stream().map(f -> new BillingReferenceAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setBillingReference(List<BillingReferenceModel> billingReference) {
		List<BillingReferenceEntity> entities = billingReference.stream()
				.map(f -> BillingReferenceAdapter.toEntity(f, em)).collect(Collectors.toList());
		creditNote.setBillingReference(entities);
	}

	@Override
	public List<DocumentReferenceModel> getDespatchDocumentReference() {
		return creditNote.getDespatchDocumentReference().stream().map(f -> new DocumentReferenceAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setDespatchDocumentReference(List<DocumentReferenceModel> despatchDocumentReference) {
		List<DocumentReferenceEntity> entities = despatchDocumentReference.stream()
				.map(f -> DocumentReferenceAdapter.toEntity(f, em)).collect(Collectors.toList());
		creditNote.setDespatchDocumentReference(entities);
	}

	@Override
	public List<DocumentReferenceModel> getReceiptDocumentReference() {
		return creditNote.getReceiptDocumentReference().stream().map(f -> new DocumentReferenceAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setReceiptDocumentReference(List<DocumentReferenceModel> receiptDocumentReference) {
		List<DocumentReferenceEntity> entities = receiptDocumentReference.stream()
				.map(f -> DocumentReferenceAdapter.toEntity(f, em)).collect(Collectors.toList());
		creditNote.setReceiptDocumentReference(entities);
	}

	@Override
	public List<DocumentReferenceModel> getContractDocumentReference() {
		return creditNote.getContractDocumentReference().stream().map(f -> new DocumentReferenceAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setContractDocumentReference(List<DocumentReferenceModel> contractDocumentReference) {
		List<DocumentReferenceEntity> entities = contractDocumentReference.stream()
				.map(f -> DocumentReferenceAdapter.toEntity(f, em)).collect(Collectors.toList());
		creditNote.setContractDocumentReference(entities);
	}

	@Override
	public List<DocumentReferenceModel> getAdditionalDocumentReference() {
		return creditNote.getAdditionalDocumentReference().stream()
				.map(f -> new DocumentReferenceAdapter(session, em, f)).collect(Collectors.toList());
	}

	@Override
	public void setAdditionalDocumentReference(List<DocumentReferenceModel> additionalDocumentReference) {
		List<DocumentReferenceEntity> entities = additionalDocumentReference.stream()
				.map(f -> DocumentReferenceAdapter.toEntity(f, em)).collect(Collectors.toList());
		creditNote.setAdditionalDocumentReference(entities);
	}

	@Override
	public List<SignatureModel> getSignature() {
		return creditNote.getSignature().stream().map(f -> new SignatureAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setSignature(List<SignatureModel> signature) {
		List<SignatureEntity> entities = signature.stream().map(f -> SignatureAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		creditNote.setSignature(entities);
	}

	@Override
	public SupplierPartyModel getAccountingSupplierParty() {
		// TODO Auto-generated method stub
		return creditNote.getAccountingSupplierParty();
	}

	@Override
	public void setAccountingSupplierParty(SupplierPartyModel value) {
		// TODO Auto-generated method stub
		creditNote.setAccountingSupplierParty(value);
	}

	@Override
	public CustomerPartyModel getAccountingCustomerParty() {
		// TODO Auto-generated method stub
		return creditNote.getAccountingCustomerParty();
	}

	@Override
	public void setAccountingCustomerParty(CustomerPartyModel value) {
		// TODO Auto-generated method stub
		creditNote.setAccountingCustomerParty(value);
	}

	@Override
	public PartyModel getPayeeParty() {
		// TODO Auto-generated method stub
		return creditNote.getPayeeParty();
	}

	@Override
	public void setPayeeParty(PartyModel value) {
		// TODO Auto-generated method stub
		creditNote.setPayeeParty(value);
	}

	@Override
	public PartyModel getTaxRepresentativeParty() {
		// TODO Auto-generated method stub
		return creditNote.getTaxRepresentativeParty();
	}

	@Override
	public void setTaxRepresentativeParty(PartyModel value) {
		// TODO Auto-generated method stub
		creditNote.setTaxRepresentativeParty(value);
	}

	@Override
	public ExchangeRateModel getTaxExchangeRate() {
		// TODO Auto-generated method stub
		return creditNote.getTaxExchangeRate();
	}

	@Override
	public void setTaxExchangeRate(ExchangeRateModel value) {
		// TODO Auto-generated method stub
		creditNote.setTaxExchangeRate(value);
	}

	@Override
	public ExchangeRateModel getPricingExchangeRate() {
		// TODO Auto-generated method stub
		return creditNote.getPricingExchangeRate();
	}

	@Override
	public void setPricingExchangeRate(ExchangeRateModel value) {
		// TODO Auto-generated method stub
		creditNote.setPricingExchangeRate(value);
	}

	@Override
	public ExchangeRateModel getPaymentExchangeRate() {
		// TODO Auto-generated method stub
		return creditNote.getPaymentExchangeRate();
	}

	@Override
	public void setPaymentExchangeRate(ExchangeRateModel value) {
		// TODO Auto-generated method stub
		creditNote.setPaymentExchangeRate(value);
	}

	@Override
	public ExchangeRateModel getPaymentAlternativeExchangeRate() {
		// TODO Auto-generated method stub
		return creditNote.getPaymentAlternativeExchangeRate();
	}

	@Override
	public void setPaymentAlternativeExchangeRate(ExchangeRateModel value) {
		// TODO Auto-generated method stub
		creditNote.setPaymentAlternativeExchangeRate(value);
	}

	@Override
	public List<AllowanceChargeModel> getAllowanceCharge() {
		// TODO Auto-generated method stub
		return creditNote.getAllowanceCharge();
	}

	@Override
	public void setAllowanceCharge(List<AllowanceChargeModel> allowanceCharge) {
		// TODO Auto-generated method stub
		creditNote.setAllowanceCharge(allowanceCharge);
	}

	@Override
	public List<TaxTotalModel> getTaxTotal() {
		// TODO Auto-generated method stub
		return creditNote.getTaxTotal();
	}

	@Override
	public void setTaxTotal(List<TaxTotalModel> taxTotal) {
		// TODO Auto-generated method stub
		creditNote.setTaxTotal(taxTotal);
	}

	@Override
	public MonetaryTotalModel getLegalMonetaryTotal() {
		// TODO Auto-generated method stub
		return creditNote.getLegalMonetaryTotal();
	}

	@Override
	public void setLegalMonetaryTotal(MonetaryTotalModel value) {
		// TODO Auto-generated method stub
		creditNote.setLegalMonetaryTotal(value);
	}

	@Override
	public List<CreditNoteLineModel> getCreditNoteLine() {
		// TODO Auto-generated method stub
		return creditNote.getCreditNoteLine();
	}

	@Override
	public void setCreditNoteLine(List<CreditNoteLineModel> creditNoteLine) {
		// TODO Auto-generated method stub
		creditNote.setCreditNoteLine(creditNoteLine);
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return creditNote.getId();
	}

	@Override
	public void setId(String value) {
		// TODO Auto-generated method stub
		creditNote.setId(value);
	}

	@Override
	public CreditNoteLineModel addCreditNoteLine() {
		// TODO Auto-generated method stub
		List<CreditNoteModel> creditNoteModels = creditNote.getCreditNoteLine();
		CreditNoteLineEntity creditNoteLineEntity = new CreditNoteLineEntity();

	}

	@Override
	public TaxTotalModel addTaxTotal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseModel addDiscrepancyResponse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentReferenceModel addDespatchDocumentReference() {
		// TODO Auto-generated method stub
		return null;
	}

}
