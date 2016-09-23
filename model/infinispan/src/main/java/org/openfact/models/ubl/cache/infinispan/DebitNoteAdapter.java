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

package org.openfact.models.ubl.cache.infinispan;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.cache.CachedDebitNoteModel;
import org.openfact.models.ubl.cache.infinispan.entities.CachedDebitNote;
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

/**
 * @author <a href="mailto:bill@burkecentral.com">Bill Burke</a>
 * @version $Revision: 1 $
 */
public class DebitNoteAdapter implements CachedDebitNoteModel {
    protected DebitNoteModel updated;
    protected CachedDebitNote cached;
    protected DebitNoteCacheSession userProviderCache;
    protected OpenfactSession openfactSession;
    protected OrganizationModel organization;

    public DebitNoteAdapter(CachedDebitNote cached, DebitNoteCacheSession debitNoteProvider,
            OpenfactSession openfactSession, OrganizationModel organization) {
        this.cached = cached;
        this.userProviderCache = debitNoteProvider;
        this.openfactSession = openfactSession;
        this.organization = organization;
    }

    @Override
    public String getId() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public OrganizationModel getOrganization() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UBLExtensionsModel getUBLExtensions() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setUBLExtensions(UBLExtensionsModel value) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getUBLVersionID() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setUBLVersionID(String value) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getCustomizationID() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setCustomizationID(String value) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getProfileID() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setProfileID(String value) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getID() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setID(String value) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean getCopyIndicator() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setCopyIndicator(boolean value) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getUUID() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setUUID(String value) {
        // TODO Auto-generated method stub

    }

    @Override
    public LocalDate getIssueDate() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setIssueDate(LocalDate value) {
        // TODO Auto-generated method stub

    }

    @Override
    public LocalTime getIssueTime() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setIssueTime(LocalTime value) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<String> getNote() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setNote(List<String> note) {
        // TODO Auto-generated method stub

    }

    @Override
    public LocalDate getTaxPointDate() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setTaxPointDate(LocalDate value) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getDocumentCurrencyCode() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setDocumentCurrencyCode(String value) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getTaxCurrencyCode() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setTaxCurrencyCode(String value) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getPricingCurrencyCode() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setPricingCurrencyCode(String value) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getPaymentCurrencyCode() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setPaymentCurrencyCode(String value) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getPaymentAlternativeCurrencyCode() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setPaymentAlternativeCurrencyCode(String value) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getAccountingCostCode() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setAccountingCostCode(String value) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getAccountingCost() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setAccountingCost(String value) {
        // TODO Auto-generated method stub

    }

    @Override
    public BigDecimal getLineCountNumeric() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setLineCountNumeric(BigDecimal value) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<PeriodModel> getInvoicePeriod() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setInvoicePeriod(List<PeriodModel> invoicePeriod) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<ResponseModel> getDiscrepancyResponse() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setDiscrepancyResponse(List<ResponseModel> discrepancyResponse) {
        // TODO Auto-generated method stub

    }

    @Override
    public OrderReferenceModel getOrderReference() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setOrderReference(OrderReferenceModel value) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<BillingReferenceModel> getBillingReference() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setBillingReference(List<BillingReferenceModel> billingReference) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<DocumentReferenceModel> getDespatchDocumentReference() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setDespatchDocumentReference(List<DocumentReferenceModel> despatchDocumentReference) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<DocumentReferenceModel> getReceiptDocumentReference() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setReceiptDocumentReference(List<DocumentReferenceModel> receiptDocumentReference) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<DocumentReferenceModel> getContractDocumentReference() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setContractDocumentReference(List<DocumentReferenceModel> contractDocumentReference) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<DocumentReferenceModel> getAdditionalDocumentReference() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setAdditionalDocumentReference(List<DocumentReferenceModel> additionalDocumentReference) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<SignatureModel> getSignature() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setSignature(List<SignatureModel> signature) {
        // TODO Auto-generated method stub

    }

    @Override
    public SupplierPartyModel getAccountingSupplierParty() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setAccountingSupplierParty(SupplierPartyModel value) {
        // TODO Auto-generated method stub

    }

    @Override
    public CustomerPartyModel getAccountingCustomerParty() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setAccountingCustomerParty(CustomerPartyModel value) {
        // TODO Auto-generated method stub

    }

    @Override
    public PartyModel getPayeeParty() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setPayeeParty(PartyModel value) {
        // TODO Auto-generated method stub

    }

    @Override
    public PartyModel getTaxRepresentativeParty() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setTaxRepresentativeParty(PartyModel value) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<PaymentModel> getPrepaidPayment() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setPrepaidPayment(List<PaymentModel> prepaidPayment) {
        // TODO Auto-generated method stub

    }

    @Override
    public ExchangeRateModel getTaxExchangeRate() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setTaxExchangeRate(ExchangeRateModel value) {
        // TODO Auto-generated method stub

    }

    @Override
    public ExchangeRateModel getPricingExchangeRate() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setPricingExchangeRate(ExchangeRateModel value) {
        // TODO Auto-generated method stub

    }

    @Override
    public ExchangeRateModel getPaymentExchangeRate() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setPaymentExchangeRate(ExchangeRateModel value) {
        // TODO Auto-generated method stub

    }

    @Override
    public ExchangeRateModel getPaymentAlternativeExchangeRate() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setPaymentAlternativeExchangeRate(ExchangeRateModel value) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<TaxTotalModel> getTaxTotal() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setTaxTotal(List<TaxTotalModel> taxTotal) {
        // TODO Auto-generated method stub

    }

    @Override
    public MonetaryTotalModel getRequestedMonetaryTotal() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setRequestedMonetaryTotal(MonetaryTotalModel value) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<DebitNoteLineModel> getDebitNoteLine() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setDebitNoteLine(List<DebitNoteLineModel> debitNoteLine) {
        // TODO Auto-generated method stub

    }

    @Override
    public ResponseModel addDiscrepancyResponse() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DebitNoteLineModel addDebitNoteLine() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TaxTotalModel addTaxTotal() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BillingReferenceModel addBillingReference() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DocumentReferenceModel addDespatchDocumentReference() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void invalidate() {
        // TODO Auto-generated method stub

    }

    @Override
    public long getCacheTimestamp() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ConcurrentHashMap getCachedWith() {
        // TODO Auto-generated method stub
        return null;
    }

}