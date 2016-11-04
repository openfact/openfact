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
package org.openfact.models.ubl.common;

import java.math.BigDecimal;
import java.util.List;

public interface StatementLineModel {

    String getID();

    void setID(String value);

    String getNote();

    void setNote(String value);

    String getUUID();

    void setUUID(String value);

    boolean getBalanceBroughtForwardIndicator();

    void setBalanceBroughtForwardIndicator(boolean value);

    BigDecimal getDebitLineAmount();

    void setDebitLineAmount(BigDecimal value);

    BigDecimal getCreditLineAmount();

    void setCreditLineAmount(BigDecimal value);

    BigDecimal getBalanceAmount();

    void setBalanceAmount(BigDecimal value);

    PaymentMeansModel getPaymentMeans();

    void setPaymentMeans(PaymentMeansModel value);

    List<PaymentTermsModel> getPaymentTerms();

    void setPaymentTerms(List<PaymentTermsModel> paymentTerms);

    CustomerPartyModel getBuyerCustomerParty();

    void setBuyerCustomerParty(CustomerPartyModel value);

    SupplierPartyModel getSellerSupplierParty();

    void setSellerSupplierParty(SupplierPartyModel value);

    CustomerPartyModel getOriginatorCustomerParty();

    void setOriginatorCustomerParty(CustomerPartyModel value);

    CustomerPartyModel getAccountingCustomerParty();

    void setAccountingCustomerParty(CustomerPartyModel value);

    SupplierPartyModel getAccountingSupplierParty();

    void setAccountingSupplierParty(SupplierPartyModel value);

    PartyModel getPayeeParty();

    void setPayeeParty(PartyModel value);

    List<PeriodModel> getInvoicePeriod();

    void setInvoicePeriod(List<PeriodModel> invoicePeriod);

    List<BillingReferenceModel> getBillingReference();

    void setBillingReference(List<BillingReferenceModel> billingReference);

    List<DocumentReferenceModel> getDocumentReference();

    void setDocumentReference(List<DocumentReferenceModel> documentReference);

    ExchangeRateModel getExchangeRate();

    void setExchangeRate(ExchangeRateModel value);

    String getId();


}
