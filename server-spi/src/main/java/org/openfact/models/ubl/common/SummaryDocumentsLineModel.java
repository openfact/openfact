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

public interface SummaryDocumentsLineModel {

    String getLineID();

    void setLineID(String value);

    String getDocumentTypeCode();

    void setDocumentTypeCode(String value);

    String getDocumentSerialID();

    void setDocumentSerialID(String value);

    String getStartDocumentNumberID();

    void setStartDocumentNumberID(String value);

    String getEndDocumentNumberID();

    void setEndDocumentNumberID(String value);

    BigDecimal getTotalAmount();

    void setTotalAmount(BigDecimal value);

    List<PaymentModel> getBillingPayment();

    void setBillingPayment(List<PaymentModel> billingPayment);

    List<AllowanceChargeModel> getAllowanceCharge();

    void setAllowanceCharge(List<AllowanceChargeModel> allowanceCharge);

    List<TaxTotalModel> getTaxTotal();

    void setTaxTotal(List<TaxTotalModel> taxTotal);

    String getId();


}
