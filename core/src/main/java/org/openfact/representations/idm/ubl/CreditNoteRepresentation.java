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

public class CreditNoteRepresentation {
    private String id;
    private String xml;
    private List<String> requiredActions;

    private UBLExtensionsRepresentation ublExtensions;
    private String ublVersionID;
    private String customizationID;
    private String profileID;
    private String idUbl;
    private Boolean copyIndicator;
    private String uuid;
    private LocalDateTime issueDateTime;
    private LocalDate taxPointDate;
    private List<String> note;
    private String documentCurrencyCode;
    private String taxCurrencyCode;
    private String pricingCurrencyCode;
    private String paymentCurrencyCode;
    private String paymentAlternativeCurrencyCode;
    private String accountingCostCode;
    private String accountingCost;
    private BigDecimal lineCountNumeric;
    private List<PeriodRepresentation> invoicePeriod;
    private List<ResponseRepresentation> discrepancyResponse;
    private OrderReferenceRepresentation orderReference;
    private List<BillingReferenceRepresentation> billingReference;
    private List<DocumentReferenceRepresentation> despatchDocumentReference;
    private List<DocumentReferenceRepresentation> receiptDocumentReference;
    private List<DocumentReferenceRepresentation> contractDocumentReference;
    private List<DocumentReferenceRepresentation> additionalDocumentReference;
    private List<SignatureRepresentation> signature;
    private SupplierPartyRepresentation accountingSupplierParty;
    private CustomerPartyRepresentation accountingCustomerParty;
    private PartyRepresentation payeeParty;
    private PartyRepresentation taxRepresentativeParty;
    private ExchangeRateRepresentation taxExchangeRate;
    private ExchangeRateRepresentation pricingExchangeRate;
    private ExchangeRateRepresentation paymentExchangeRate;
    private ExchangeRateRepresentation paymentAlternativeExchangeRate;
    private List<AllowanceChargeRepresentation> allowanceCharge;
    private List<TaxTotalRepresentation> taxTotal;
    private MonetaryTotalRepresentation legalMonetaryTotal;
    private List<CreditNoteLineRepresentation> creditNoteLine;

    /**
     * Custom methods
     */
    public void addSignature(SignatureRepresentation representation) {
        if (signature == null) {
            signature = new ArrayList<>();
        }
        signature.add(representation);
    }

    public void addDiscrepancyResponse(ResponseRepresentation representation) {
        if (discrepancyResponse == null) {
            discrepancyResponse = new ArrayList<>();
        }
        discrepancyResponse.add(representation);
    }

    public void addCreditNoteLine(CreditNoteLineRepresentation representation) {
        if (creditNoteLine == null) {
            creditNoteLine = new ArrayList<>();
        }
        creditNoteLine.add(representation);
    }

    public void addTaxTotal(TaxTotalRepresentation representation) {
        if (taxTotal == null) {
            taxTotal = new ArrayList<>();
        }
        taxTotal.add(representation);
    }

    public void addBillingReference(BillingReferenceRepresentation representation) {
        if (billingReference == null) {
            billingReference = new ArrayList<>();
        }
        billingReference.add(representation);
    }

    public void addDespatchDocumentReference(DocumentReferenceRepresentation representation) {
        if (despatchDocumentReference == null) {
            despatchDocumentReference = new ArrayList<>();
        }
        despatchDocumentReference.add(representation);
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

    public LocalDate getTaxPointDate() {
        return taxPointDate;
    }

    public void setTaxPointDate(LocalDate taxPointDate) {
        this.taxPointDate = taxPointDate;
    }

    public List<String> getNote() {
        return note;
    }

    public void setNote(List<String> note) {
        this.note = note;
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

    public List<ResponseRepresentation> getDiscrepancyResponse() {
        return discrepancyResponse;
    }

    public void setDiscrepancyResponse(List<ResponseRepresentation> discrepancyResponse) {
        this.discrepancyResponse = discrepancyResponse;
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

    public PartyRepresentation getTaxRepresentativeParty() {
        return taxRepresentativeParty;
    }

    public void setTaxRepresentativeParty(PartyRepresentation taxRepresentativeParty) {
        this.taxRepresentativeParty = taxRepresentativeParty;
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

    public List<AllowanceChargeRepresentation> getAllowanceCharge() {
        return allowanceCharge;
    }

    public void setAllowanceCharge(List<AllowanceChargeRepresentation> allowanceCharge) {
        this.allowanceCharge = allowanceCharge;
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

    public List<CreditNoteLineRepresentation> getCreditNoteLine() {
        return creditNoteLine;
    }

    public void setCreditNoteLine(List<CreditNoteLineRepresentation> creditNoteLine) {
        this.creditNoteLine = creditNoteLine;
    }

}