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

public interface AllowanceChargeModel {

    String getID();

    void setID(String value);

    boolean getChargeIndicator();

    void setChargeIndicator(boolean value);

    String getAllowanceChargeReasonCode();

    void setAllowanceChargeReasonCode(String value);

    String getAllowanceChargeReason();

    void setAllowanceChargeReason(String value);

    BigDecimal getMultiplierFactorNumeric();

    void setMultiplierFactorNumeric(BigDecimal value);

    boolean getPrepaidIndicator();

    void setPrepaidIndicator(boolean value);

    BigDecimal getSequenceNumeric();

    void setSequenceNumeric(BigDecimal value);

    BigDecimal getAmount();

    void setAmount(BigDecimal value);

    BigDecimal getBaseAmount();

    void setBaseAmount(BigDecimal value);

    String getAccountingCostCode();

    void setAccountingCostCode(String value);

    String getAccountingCost();

    void setAccountingCost(String value);

    List<TaxCategoryModel> getTaxCategory();

    void setTaxCategory(List<TaxCategoryModel> taxCategory);

    TaxTotalModel getTaxTotal();

    void setTaxTotal(TaxTotalModel value);

    List<PaymentMeansModel> getPaymentMeans();

    void setPaymentMeans(List<PaymentMeansModel> paymentMeans);

    String getId();


}
