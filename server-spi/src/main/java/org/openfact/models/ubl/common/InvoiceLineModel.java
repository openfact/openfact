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
import java.time.LocalDate;
import java.util.List;

public interface InvoiceLineModel {

    String getID();

    void setID(String value);

    String getUUID();

    void setUUID(String value);

    String getNote();

    void setNote(String value);

    QuantityModel getInvoicedQuantity();

    void setInvoicedQuantity(QuantityModel value);

    BigDecimal getLineExtensionAmount();

    void setLineExtensionAmount(BigDecimal value);

    LocalDate getTaxPointDate();

    void setTaxPointDate(LocalDate value);

    String getAccountingCostCode();

    void setAccountingCostCode(String value);

    String getAccountingCost();

    void setAccountingCost(String value);

    boolean getFreeOfChargeIndicator();

    void setFreeOfChargeIndicator(boolean value);

    List<OrderLineReferenceModel> getOrderLineReference();

    void setOrderLineReference(List<OrderLineReferenceModel> orderLineReference);

    List<LineReferenceModel> getDespatchLineReference();

    void setDespatchLineReference(List<LineReferenceModel> despatchLineReference);

    List<LineReferenceModel> getReceiptLineReference();

    void setReceiptLineReference(List<LineReferenceModel> receiptLineReference);

    List<BillingReferenceModel> getBillingReference();

    void setBillingReference(List<BillingReferenceModel> billingReference);

    List<DocumentReferenceModel> getDocumentReference();

    void setDocumentReference(List<DocumentReferenceModel> documentReference);

    PricingReferenceModel getPricingReference();

    void setPricingReference(PricingReferenceModel value);

    PartyModel getOriginatorParty();

    void setOriginatorParty(PartyModel value);

    List<DeliveryModel> getDelivery();

    void setDelivery(List<DeliveryModel> delivery);

    List<PaymentTermsModel> getPaymentTerms();

    void setPaymentTerms(List<PaymentTermsModel> paymentTerms);

    List<AllowanceChargeModel> getAllowanceCharge();

    void setAllowanceCharge(List<AllowanceChargeModel> allowanceCharge);

    List<TaxTotalModel> getTaxTotal();

    void setTaxTotal(List<TaxTotalModel> taxTotal);

    ItemModel getItem();

    void setItem(ItemModel value);

    PriceModel getPrice();

    void setPrice(PriceModel value);

    DeliveryTermsModel getDeliveryTerms();

    void setDeliveryTerms(DeliveryTermsModel value);

    String getId();


    /**
     * */
    TaxTotalModel addTaxTotal();

    AllowanceChargeModel addAllowanceCharge();

}
