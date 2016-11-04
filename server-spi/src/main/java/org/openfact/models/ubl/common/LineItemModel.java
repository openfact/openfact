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

public interface LineItemModel {

    String getID();

    void setID(String value);

    String getSalesOrderID();

    void setSalesOrderID(String value);

    String getUUID();

    void setUUID(String value);

    String getNote();

    void setNote(String value);

    String getLineStatusCode();

    void setLineStatusCode(String value);

    QuantityModel getQuantity();

    void setQuantity(QuantityModel value);

    BigDecimal getLineExtensionAmount();

    void setLineExtensionAmount(BigDecimal value);

    BigDecimal getTotalTaxAmount();

    void setTotalTaxAmount(BigDecimal value);

    QuantityModel getMinimumQuantity();

    void setMinimumQuantity(QuantityModel value);

    QuantityModel getMaximumQuantity();

    void setMaximumQuantity(QuantityModel value);

    QuantityModel getMinimumBackorderQuantity();

    void setMinimumBackorderQuantity(QuantityModel value);

    QuantityModel getMaximumBackorderQuantity();

    void setMaximumBackorderQuantity(QuantityModel value);

    String getInspectionMethodCode();

    void setInspectionMethodCode(String value);

    boolean getPartialDeliveryIndicator();

    void setPartialDeliveryIndicator(boolean value);

    boolean getBackOrderAllowedIndicator();

    void setBackOrderAllowedIndicator(boolean value);

    String getAccountingCostCode();

    void setAccountingCostCode(String value);

    String getAccountingCost();

    void setAccountingCost(String value);

    List<DeliveryModel> getDelivery();

    void setDelivery(List<DeliveryModel> delivery);

    DeliveryTermsModel getDeliveryTerms();

    void setDeliveryTerms(DeliveryTermsModel value);

    PartyModel getOriginatorParty();

    void setOriginatorParty(PartyModel value);

    List<OrderedShipmentModel> getOrderedShipment();

    void setOrderedShipment(List<OrderedShipmentModel> orderedShipment);

    PricingReferenceModel getPricingReference();

    void setPricingReference(PricingReferenceModel value);

    List<AllowanceChargeModel> getAllowanceCharge();

    void setAllowanceCharge(List<AllowanceChargeModel> allowanceCharge);

    PriceModel getPrice();

    void setPrice(PriceModel value);

    ItemModel getItem();

    void setItem(ItemModel value);

    String getId();


}
