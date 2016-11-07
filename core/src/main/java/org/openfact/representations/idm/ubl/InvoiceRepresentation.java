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
package org.openfact.representations.idm.ubl;

import org.openfact.representations.idm.ubl.common.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InvoiceRepresentation {

    private UBLExtensionsRepresentation ublExtensions;
    private String ublVersionID;
    private String customizationID;
    private String profileID;
    private String idUbl;
    private Boolean copyIndicator;
    private String uuid;
    private LocalDateTime issueDateTime;
    private String invoiceTypeCode;
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
    private boolean sendImmediately;

    private String xml;
    protected List<String> requiredActions;

    /**
     * Custom methods
     */
    public void addSignature(SignatureRepresentation representation) {
        if (signature == null) {
            signature = new ArrayList<>();
        }
        signature.add(representation);
    }

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

    public UBLExtensionsRepresentation getUblExtensions() {
        return ublExtensions;
    }

    public void setUblExtensions(UBLExtensionsRepresentation ublExtensions) {
        this.ublExtensions = ublExtensions;
    }

    public String getUblVersionID() {
        return ublVersionID;
    }

    public void setUblVersionID(String ublVersionID) {
        this.ublVersionID = ublVersionID;
    }

    public String getCustomizationID() {
        return customizationID;
    }

    public void setCustomizationID(String customizationID) {
        this.customizationID = customizationID;
    }

    public String getProfileID() {
        return profileID;
    }

    public void setProfileID(String profileID) {
        this.profileID = profileID;
    }

    public String getIdUbl() {
        return idUbl;
    }

    public void setIdUbl(String idUbl) {
        this.idUbl = idUbl;
    }

    public Boolean getCopyIndicator() {
        return copyIndicator;
    }

    public void setCopyIndicator(Boolean copyIndicator) {
        this.copyIndicator = copyIndicator;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public LocalDateTime getIssueDateTime() {
        return issueDateTime;
    }

    public void setIssueDateTime(LocalDateTime issueDateTime) {
        this.issueDateTime = issueDateTime;
    }

    public String getInvoiceTypeCode() {
        return invoiceTypeCode;
    }

    public void setInvoiceTypeCode(String invoiceTypeCode) {
        this.invoiceTypeCode = invoiceTypeCode;
    }

    public List<String> getNote() {
        return note;
    }

    public void setNote(List<String> note) {
        this.note = note;
    }

    public LocalDate getTaxPointDate() {
        return taxPointDate;
    }

    public void setTaxPointDate(LocalDate taxPointDate) {
        this.taxPointDate = taxPointDate;
    }

    public String getDocumentCurrencyCode() {
        return documentCurrencyCode;
    }

    public void setDocumentCurrencyCode(String documentCurrencyCode) {
        this.documentCurrencyCode = documentCurrencyCode;
    }

    public String getTaxCurrencyCode() {
        return taxCurrencyCode;
    }

    public void setTaxCurrencyCode(String taxCurrencyCode) {
        this.taxCurrencyCode = taxCurrencyCode;
    }

    public String getPricingCurrencyCode() {
        return pricingCurrencyCode;
    }

    public void setPricingCurrencyCode(String pricingCurrencyCode) {
        this.pricingCurrencyCode = pricingCurrencyCode;
    }

    public String getPaymentCurrencyCode() {
        return paymentCurrencyCode;
    }

    public void setPaymentCurrencyCode(String paymentCurrencyCode) {
        this.paymentCurrencyCode = paymentCurrencyCode;
    }

    public String getPaymentAlternativeCurrencyCode() {
        return paymentAlternativeCurrencyCode;
    }

    public void setPaymentAlternativeCurrencyCode(String paymentAlternativeCurrencyCode) {
        this.paymentAlternativeCurrencyCode = paymentAlternativeCurrencyCode;
    }

    public String getAccountingCostCode() {
        return accountingCostCode;
    }

    public void setAccountingCostCode(String accountingCostCode) {
        this.accountingCostCode = accountingCostCode;
    }

    public String getAccountingCost() {
        return accountingCost;
    }

    public void setAccountingCost(String accountingCost) {
        this.accountingCost = accountingCost;
    }

    public BigDecimal getLineCountNumeric() {
        return lineCountNumeric;
    }

    public void setLineCountNumeric(BigDecimal lineCountNumeric) {
        this.lineCountNumeric = lineCountNumeric;
    }

    public List<PeriodRepresentation> getInvoicePeriod() {
        return invoicePeriod;
    }

    public void setInvoicePeriod(List<PeriodRepresentation> invoicePeriod) {
        this.invoicePeriod = invoicePeriod;
    }

    public OrderReferenceRepresentation getOrderReference() {
        return orderReference;
    }

    public void setOrderReference(OrderReferenceRepresentation orderReference) {
        this.orderReference = orderReference;
    }

    public List<BillingReferenceRepresentation> getBillingReference() {
        return billingReference;
    }

    public void setBillingReference(List<BillingReferenceRepresentation> billingReference) {
        this.billingReference = billingReference;
    }

    public List<DocumentReferenceRepresentation> getDespatchDocumentReference() {
        return despatchDocumentReference;
    }

    public void setDespatchDocumentReference(
            List<DocumentReferenceRepresentation> despatchDocumentReference) {
        this.despatchDocumentReference = despatchDocumentReference;
    }

    public List<DocumentReferenceRepresentation> getReceiptDocumentReference() {
        return receiptDocumentReference;
    }

    public void setReceiptDocumentReference(List<DocumentReferenceRepresentation> receiptDocumentReference) {
        this.receiptDocumentReference = receiptDocumentReference;
    }

    public List<DocumentReferenceRepresentation> getOriginatorDocumentReference() {
        return originatorDocumentReference;
    }

    public void setOriginatorDocumentReference(
            List<DocumentReferenceRepresentation> originatorDocumentReference) {
        this.originatorDocumentReference = originatorDocumentReference;
    }

    public List<DocumentReferenceRepresentation> getContractDocumentReference() {
        return contractDocumentReference;
    }

    public void setContractDocumentReference(
            List<DocumentReferenceRepresentation> contractDocumentReference) {
        this.contractDocumentReference = contractDocumentReference;
    }

    public List<DocumentReferenceRepresentation> getAdditionalDocumentReference() {
        return additionalDocumentReference;
    }

    public void setAdditionalDocumentReference(
            List<DocumentReferenceRepresentation> additionalDocumentReference) {
        this.additionalDocumentReference = additionalDocumentReference;
    }

    public List<SignatureRepresentation> getSignature() {
        return signature;
    }

    public void setSignature(List<SignatureRepresentation> signature) {
        this.signature = signature;
    }

    public SupplierPartyRepresentation getAccountingSupplierParty() {
        return accountingSupplierParty;
    }

    public void setAccountingSupplierParty(SupplierPartyRepresentation accountingSupplierParty) {
        this.accountingSupplierParty = accountingSupplierParty;
    }

    public CustomerPartyRepresentation getAccountingCustomerParty() {
        return accountingCustomerParty;
    }

    public void setAccountingCustomerParty(CustomerPartyRepresentation accountingCustomerParty) {
        this.accountingCustomerParty = accountingCustomerParty;
    }

    public PartyRepresentation getPayeeParty() {
        return payeeParty;
    }

    public void setPayeeParty(PartyRepresentation payeeParty) {
        this.payeeParty = payeeParty;
    }

    public CustomerPartyRepresentation getBuyerCustomerParty() {
        return buyerCustomerParty;
    }

    public void setBuyerCustomerParty(CustomerPartyRepresentation buyerCustomerParty) {
        this.buyerCustomerParty = buyerCustomerParty;
    }

    public SupplierPartyRepresentation getSellerSupplierParty() {
        return sellerSupplierParty;
    }

    public void setSellerSupplierParty(SupplierPartyRepresentation sellerSupplierParty) {
        this.sellerSupplierParty = sellerSupplierParty;
    }

    public PartyRepresentation getTaxRepresentativeParty() {
        return taxRepresentativeParty;
    }

    public void setTaxRepresentativeParty(PartyRepresentation taxRepresentativeParty) {
        this.taxRepresentativeParty = taxRepresentativeParty;
    }

    public List<DeliveryRepresentation> getDelivery() {
        return delivery;
    }

    public void setDelivery(List<DeliveryRepresentation> delivery) {
        this.delivery = delivery;
    }

    public DeliveryTermsRepresentation getDeliveryTerms() {
        return deliveryTerms;
    }

    public void setDeliveryTerms(DeliveryTermsRepresentation deliveryTerms) {
        this.deliveryTerms = deliveryTerms;
    }

    public List<PaymentMeansRepresentation> getPaymentMeans() {
        return paymentMeans;
    }

    public void setPaymentMeans(List<PaymentMeansRepresentation> paymentMeans) {
        this.paymentMeans = paymentMeans;
    }

    public List<PaymentTermsRepresentation> getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(List<PaymentTermsRepresentation> paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public List<PaymentRepresentation> getPrepaidPayment() {
        return prepaidPayment;
    }

    public void setPrepaidPayment(List<PaymentRepresentation> prepaidPayment) {
        this.prepaidPayment = prepaidPayment;
    }

    public List<AllowanceChargeRepresentation> getAllowanceCharge() {
        return allowanceCharge;
    }

    public void setAllowanceCharge(List<AllowanceChargeRepresentation> allowanceCharge) {
        this.allowanceCharge = allowanceCharge;
    }

    public ExchangeRateRepresentation getTaxExchangeRate() {
        return taxExchangeRate;
    }

    public void setTaxExchangeRate(ExchangeRateRepresentation taxExchangeRate) {
        this.taxExchangeRate = taxExchangeRate;
    }

    public ExchangeRateRepresentation getPricingExchangeRate() {
        return pricingExchangeRate;
    }

    public void setPricingExchangeRate(ExchangeRateRepresentation pricingExchangeRate) {
        this.pricingExchangeRate = pricingExchangeRate;
    }

    public ExchangeRateRepresentation getPaymentExchangeRate() {
        return paymentExchangeRate;
    }

    public void setPaymentExchangeRate(ExchangeRateRepresentation paymentExchangeRate) {
        this.paymentExchangeRate = paymentExchangeRate;
    }

    public ExchangeRateRepresentation getPaymentAlternativeExchangeRate() {
        return paymentAlternativeExchangeRate;
    }

    public void setPaymentAlternativeExchangeRate(ExchangeRateRepresentation paymentAlternativeExchangeRate) {
        this.paymentAlternativeExchangeRate = paymentAlternativeExchangeRate;
    }

    public List<TaxTotalRepresentation> getTaxTotal() {
        return taxTotal;
    }

    public void setTaxTotal(List<TaxTotalRepresentation> taxTotal) {
        this.taxTotal = taxTotal;
    }

    public MonetaryTotalRepresentation getLegalMonetaryTotal() {
        return legalMonetaryTotal;
    }

    public void setLegalMonetaryTotal(MonetaryTotalRepresentation legalMonetaryTotal) {
        this.legalMonetaryTotal = legalMonetaryTotal;
    }

    public List<InvoiceLineRepresentation> getInvoiceLine() {
        return invoiceLine;
    }

    public void setInvoiceLine(List<InvoiceLineRepresentation> invoiceLine) {
        this.invoiceLine = invoiceLine;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    public List<String> getRequiredActions() {
        return requiredActions;
    }

    public void setRequiredActions(List<String> requiredActions) {
        this.requiredActions = requiredActions;
    }

	public boolean isSendImmediately() {
		return sendImmediately;
	}

	public void setSendImmediately(boolean sendImmediately) {
		this.sendImmediately = sendImmediately;
	}

}