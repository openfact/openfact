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

public interface MonetaryTotalModel {

    BigDecimal getLineExtensionAmount();

    void setLineExtensionAmount(BigDecimal value);

    BigDecimal getTaxExclusiveAmount();

    void setTaxExclusiveAmount(BigDecimal value);

    BigDecimal getTaxInclusiveAmount();

    void setTaxInclusiveAmount(BigDecimal value);

    BigDecimal getAllowanceTotalAmount();

    void setAllowanceTotalAmount(BigDecimal value);

    BigDecimal getChargeTotalAmount();

    void setChargeTotalAmount(BigDecimal value);

    BigDecimal getPrepaidAmount();

    void setPrepaidAmount(BigDecimal value);

    BigDecimal getPayableRoundingAmount();

    void setPayableRoundingAmount(BigDecimal value);

    BigDecimal getPayableAmount();

    void setPayableAmount(BigDecimal value);

    String getId();


}
