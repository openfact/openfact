package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.openfact.representations.idm.ubl.common.AllowanceChargeRepresentation;
import org.openfact.representations.idm.ubl.common.BillingReferenceRepresentation;
import org.openfact.representations.idm.ubl.common.CustomerPartyRepresentation;
import org.openfact.representations.idm.ubl.common.DeliveryRepresentation;
import org.openfact.representations.idm.ubl.common.DeliveryTermsRepresentation;
import org.openfact.representations.idm.ubl.common.DocumentReferenceRepresentation;
import org.openfact.representations.idm.ubl.common.ExchangeRateRepresentation;
import org.openfact.representations.idm.ubl.common.InvoiceLineRepresentation;
import org.openfact.representations.idm.ubl.common.MonetaryTotalRepresentation;
import org.openfact.representations.idm.ubl.common.OrderReferenceRepresentation;
import org.openfact.representations.idm.ubl.common.PartyRepresentation;
import org.openfact.representations.idm.ubl.common.PaymentMeansRepresentation;
import org.openfact.representations.idm.ubl.common.PaymentRepresentation;
import org.openfact.representations.idm.ubl.common.PaymentTermsRepresentation;
import org.openfact.representations.idm.ubl.common.PeriodRepresentation;
import org.openfact.representations.idm.ubl.common.SignatureRepresentation;
import org.openfact.representations.idm.ubl.common.SupplierPartyRepresentation;
import org.openfact.representations.idm.ubl.common.TaxTotalRepresentation;
import org.openfact.representations.idm.ubl.common.UBLExtensionsRepresentation;

public class InvoiceRepresentation {
	private UBLExtensionsRepresentation UBLExtensions;
	private String UBLVersionID;
	private String customizationID;
	private String profileID;
	private String ID;
	private boolean copyIndicator;
	private String UUID;
	private LocalDate issueDate;
	private LocalTime issueTime;
	private String invoiceRepresentationCode;
	private List<String> note;
	private LocalDate taxPointDate;
	private String documentCurrencyCode;
	private String taxCurrencyCode;
	private String pricingCurrencyCode;
	private String paymentCurrencyCode;
	private String paymentAlternativeCurrencyCode;
	private String accountingCostCode;
	private String accountingCost;
	private BigDecimal lineCountNumeric;
	private List<PeriodRepresentation> invoicePeriod;
	private OrderReferenceRepresentation orderReference;
	private List<BillingReferenceRepresentation> billingReference;
	private List<DocumentReferenceRepresentation> despatchDocumentReference;
	private List<DocumentReferenceRepresentation> receiptDocumentReference;
	private List<DocumentReferenceRepresentation> originatorDocumentReference;
	private List<DocumentReferenceRepresentation> contractDocumentReference;
	private List<DocumentReferenceRepresentation> additionalDocumentReference;
	private List<SignatureRepresentation> signature;
	private SupplierPartyRepresentation accountingSupplierParty;
	private CustomerPartyRepresentation accountingCustomerParty;
	private PartyRepresentation payeeParty;
	private CustomerPartyRepresentation buyerCustomerParty;
	private SupplierPartyRepresentation sellerSupplierParty;
	private PartyRepresentation taxRepresentativeParty;
	private List<DeliveryRepresentation> delivery;
	private DeliveryTermsRepresentation deliveryTerms;
	private List<PaymentMeansRepresentation> paymentMeans;
	private List<PaymentTermsRepresentation> paymentTerms;
	private List<PaymentRepresentation> prepaidPayment;
	private List<AllowanceChargeRepresentation> allowanceCharge;
	private ExchangeRateRepresentation taxExchangeRate;
	private ExchangeRateRepresentation pricingExchangeRate;
	private ExchangeRateRepresentation paymentExchangeRate;
	private ExchangeRateRepresentation paymentAlternativeExchangeRate;
	private List<TaxTotalRepresentation> taxTotal;
	private MonetaryTotalRepresentation legalMonetaryTotal;
	private List<InvoiceLineRepresentation> invoiceLine;
	private String id;

	/***/
	public void addInvoiceLine(InvoiceLineRepresentation representation) {
		if (invoiceLine == null) {
			invoiceLine = new ArrayList<>();
		}
		invoiceLine.add(representation);
	}

	public void addPeriod(PeriodRepresentation representation) {
		if (invoicePeriod == null) {
			invoicePeriod = new ArrayList<>();
		}
		invoicePeriod.add(representation);
	}
	public void addBillingReference(BillingReferenceRepresentation representation) {
		if (billingReference == null) {
			billingReference = new ArrayList<>();
		}
		billingReference.add(representation);
	}
	public void addDocumentReference(DocumentReferenceRepresentation representation) {
		if (despatchDocumentReference == null) {
			despatchDocumentReference = new ArrayList<>();
		}
		despatchDocumentReference.add(representation);
	}

	public void addTaxTotal(TaxTotalRepresentation representation) {
		if (taxTotal == null) {
			taxTotal = new ArrayList<>();
		}
		taxTotal.add(representation);
	}


	/**
	 * Getter and Setters
	 */
	public LocalDate getTaxPointDate() {
		return this.taxPointDate;
	}

	public void setTaxPointDate(LocalDate taxPointDate) {
		this.taxPointDate = taxPointDate;
	}

	public String getID() {
		return this.ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<DocumentReferenceRepresentation> getContractDocumentReference() {
		return this.contractDocumentReference;
	}

	public void setContractDocumentReference(List<DocumentReferenceRepresentation> contractDocumentReference) {
		this.contractDocumentReference = contractDocumentReference;
	}

	public DeliveryTermsRepresentation getDeliveryTerms() {
		return this.deliveryTerms;
	}

	public void setDeliveryTerms(DeliveryTermsRepresentation deliveryTerms) {
		this.deliveryTerms = deliveryTerms;
	}

	public PartyRepresentation getPayeeParty() {
		return this.payeeParty;
	}

	public void setPayeeParty(PartyRepresentation payeeParty) {
		this.payeeParty = payeeParty;
	}

	public String getPricingCurrencyCode() {
		return this.pricingCurrencyCode;
	}

	public void setPricingCurrencyCode(String pricingCurrencyCode) {
		this.pricingCurrencyCode = pricingCurrencyCode;
	}

	public SupplierPartyRepresentation getSellerSupplierParty() {
		return this.sellerSupplierParty;
	}

	public void setSellerSupplierParty(SupplierPartyRepresentation sellerSupplierParty) {
		this.sellerSupplierParty = sellerSupplierParty;
	}

	public String getTaxCurrencyCode() {
		return this.taxCurrencyCode;
	}

	public void setTaxCurrencyCode(String taxCurrencyCode) {
		this.taxCurrencyCode = taxCurrencyCode;
	}

	public CustomerPartyRepresentation getBuyerCustomerParty() {
		return this.buyerCustomerParty;
	}

	public void setBuyerCustomerParty(CustomerPartyRepresentation buyerCustomerParty) {
		this.buyerCustomerParty = buyerCustomerParty;
	}

	public MonetaryTotalRepresentation getLegalMonetaryTotal() {
		return this.legalMonetaryTotal;
	}

	public void setLegalMonetaryTotal(MonetaryTotalRepresentation legalMonetaryTotal) {
		this.legalMonetaryTotal = legalMonetaryTotal;
	}

	public List<PaymentTermsRepresentation> getPaymentTerms() {
		return this.paymentTerms;
	}

	public void setPaymentTerms(List<PaymentTermsRepresentation> paymentTerms) {
		this.paymentTerms = paymentTerms;
	}

	public ExchangeRateRepresentation getPricingExchangeRate() {
		return this.pricingExchangeRate;
	}

	public void setPricingExchangeRate(ExchangeRateRepresentation pricingExchangeRate) {
		this.pricingExchangeRate = pricingExchangeRate;
	}

	public ExchangeRateRepresentation getPaymentExchangeRate() {
		return this.paymentExchangeRate;
	}

	public void setPaymentExchangeRate(ExchangeRateRepresentation paymentExchangeRate) {
		this.paymentExchangeRate = paymentExchangeRate;
	}

	public PartyRepresentation getTaxRepresentativeParty() {
		return this.taxRepresentativeParty;
	}

	public void setTaxRepresentativeParty(PartyRepresentation taxRepresentativeParty) {
		this.taxRepresentativeParty = taxRepresentativeParty;
	}

	public List<PeriodRepresentation> getInvoicePeriod() {
		return this.invoicePeriod;
	}

	public void setInvoicePeriod(List<PeriodRepresentation> invoicePeriod) {
		this.invoicePeriod = invoicePeriod;
	}

	public BigDecimal getLineCountNumeric() {
		return this.lineCountNumeric;
	}

	public void setLineCountNumeric(BigDecimal lineCountNumeric) {
		this.lineCountNumeric = lineCountNumeric;
	}

	public List<DocumentReferenceRepresentation> getOriginatorDocumentReference() {
		return this.originatorDocumentReference;
	}

	public void setOriginatorDocumentReference(List<DocumentReferenceRepresentation> originatorDocumentReference) {
		this.originatorDocumentReference = originatorDocumentReference;
	}

	public ExchangeRateRepresentation getPaymentAlternativeExchangeRate() {
		return this.paymentAlternativeExchangeRate;
	}

	public void setPaymentAlternativeExchangeRate(ExchangeRateRepresentation paymentAlternativeExchangeRate) {
		this.paymentAlternativeExchangeRate = paymentAlternativeExchangeRate;
	}

	public String getUUID() {
		return this.UUID;
	}

	public void setUUID(String UUID) {
		this.UUID = UUID;
	}

	public SupplierPartyRepresentation getAccountingSupplierParty() {
		return this.accountingSupplierParty;
	}

	public void setAccountingSupplierParty(SupplierPartyRepresentation accountingSupplierParty) {
		this.accountingSupplierParty = accountingSupplierParty;
	}

	public List<SignatureRepresentation> getSignature() {
		return this.signature;
	}

	public void setSignature(List<SignatureRepresentation> signature) {
		this.signature = signature;
	}

	public String getCustomizationID() {
		return this.customizationID;
	}

	public void setCustomizationID(String customizationID) {
		this.customizationID = customizationID;
	}

	public List<DocumentReferenceRepresentation> getAdditionalDocumentReference() {
		return this.additionalDocumentReference;
	}

	public void setAdditionalDocumentReference(List<DocumentReferenceRepresentation> additionalDocumentReference) {
		this.additionalDocumentReference = additionalDocumentReference;
	}

	public List<DeliveryRepresentation> getDelivery() {
		return this.delivery;
	}

	public void setDelivery(List<DeliveryRepresentation> delivery) {
		this.delivery = delivery;
	}

	public List<String> getNote() {
		return this.note;
	}

	public void setNote(List<String> note) {
		this.note = note;
	}

	public List<DocumentReferenceRepresentation> getDespatchDocumentReference() {
		return this.despatchDocumentReference;
	}

	public void setDespatchDocumentReference(List<DocumentReferenceRepresentation> despatchDocumentReference) {
		this.despatchDocumentReference = despatchDocumentReference;
	}

	public String getDocumentCurrencyCode() {
		return this.documentCurrencyCode;
	}

	public void setDocumentCurrencyCode(String documentCurrencyCode) {
		this.documentCurrencyCode = documentCurrencyCode;
	}

	public String getPaymentCurrencyCode() {
		return this.paymentCurrencyCode;
	}

	public void setPaymentCurrencyCode(String paymentCurrencyCode) {
		this.paymentCurrencyCode = paymentCurrencyCode;
	}

	public String getAccountingCostCode() {
		return this.accountingCostCode;
	}

	public void setAccountingCostCode(String accountingCostCode) {
		this.accountingCostCode = accountingCostCode;
	}

	public String getAccountingCost() {
		return this.accountingCost;
	}

	public void setAccountingCost(String accountingCost) {
		this.accountingCost = accountingCost;
	}

	public List<BillingReferenceRepresentation> getBillingReference() {
		return this.billingReference;
	}

	public void setBillingReference(List<BillingReferenceRepresentation> billingReference) {
		this.billingReference = billingReference;
	}

	public List<AllowanceChargeRepresentation> getAllowanceCharge() {
		return this.allowanceCharge;
	}

	public void setAllowanceCharge(List<AllowanceChargeRepresentation> allowanceCharge) {
		this.allowanceCharge = allowanceCharge;
	}

	public List<InvoiceLineRepresentation> getInvoiceLine() {
		return this.invoiceLine;
	}

	public void setInvoiceLine(List<InvoiceLineRepresentation> invoiceLine) {
		this.invoiceLine = invoiceLine;
	}

	public LocalTime getIssueTime() {
		return this.issueTime;
	}

	public void setIssueTime(LocalTime issueTime) {
		this.issueTime = issueTime;
	}

	public OrderReferenceRepresentation getOrderReference() {
		return this.orderReference;
	}

	public void setOrderReference(OrderReferenceRepresentation orderReference) {
		this.orderReference = orderReference;
	}

	public String getInvoiceCodeRepresentation() {
		return this.invoiceRepresentationCode;
	}

	public void setInvoiceRepresentationCode(String invoiceRepresentationCode) {
		this.invoiceRepresentationCode = invoiceRepresentationCode;
	}

	public List<PaymentMeansRepresentation> getPaymentMeans() {
		return this.paymentMeans;
	}

	public void setPaymentMeans(List<PaymentMeansRepresentation> paymentMeans) {
		this.paymentMeans = paymentMeans;
	}

	public ExchangeRateRepresentation getTaxExchangeRate() {
		return this.taxExchangeRate;
	}

	public void setTaxExchangeRate(ExchangeRateRepresentation taxExchangeRate) {
		this.taxExchangeRate = taxExchangeRate;
	}

	public String getUBLVersionID() {
		return this.UBLVersionID;
	}

	public void setUBLVersionID(String UBLVersionID) {
		this.UBLVersionID = UBLVersionID;
	}

	public List<TaxTotalRepresentation> getTaxTotal() {
		return this.taxTotal;
	}

	public void setTaxTotal(List<TaxTotalRepresentation> taxTotal) {
		this.taxTotal = taxTotal;
	}

	public String getPaymentAlternativeCurrencyCode() {
		return this.paymentAlternativeCurrencyCode;
	}

	public void setPaymentAlternativeCurrencyCode(String paymentAlternativeCurrencyCode) {
		this.paymentAlternativeCurrencyCode = paymentAlternativeCurrencyCode;
	}

	public UBLExtensionsRepresentation getUBLExtensions() {
		return this.UBLExtensions;
	}

	public void setUBLExtensions(UBLExtensionsRepresentation UBLExtensions) {
		this.UBLExtensions = UBLExtensions;
	}

	public String getProfileID() {
		return this.profileID;
	}

	public void setProfileID(String profileID) {
		this.profileID = profileID;
	}

	public CustomerPartyRepresentation getAccountingCustomerParty() {
		return this.accountingCustomerParty;
	}

	public void setAccountingCustomerParty(CustomerPartyRepresentation accountingCustomerParty) {
		this.accountingCustomerParty = accountingCustomerParty;
	}

	public LocalDate getIssueDate() {
		return this.issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public List<PaymentRepresentation> getPrepaidPayment() {
		return this.prepaidPayment;
	}

	public void setPrepaidPayment(List<PaymentRepresentation> prepaidPayment) {
		this.prepaidPayment = prepaidPayment;
	}

	public boolean getCopyIndicator() {
		return this.copyIndicator;
	}

	public void setCopyIndicator(boolean copyIndicator) {
		this.copyIndicator = copyIndicator;
	}

	public List<DocumentReferenceRepresentation> getReceiptDocumentReference() {
		return this.receiptDocumentReference;
	}

	public void setReceiptDocumentReference(List<DocumentReferenceRepresentation> receiptDocumentReference) {
		this.receiptDocumentReference = receiptDocumentReference;
	}

}