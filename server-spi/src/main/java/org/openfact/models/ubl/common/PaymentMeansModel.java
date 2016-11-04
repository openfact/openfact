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

import java.time.LocalDate;
import java.util.List;

public interface PaymentMeansModel {

    String getID();

    void setID(String value);

    String getPaymentMeansCode();

    void setPaymentMeansCode(String value);

    LocalDate getPaymentDueDate();

    void setPaymentDueDate(LocalDate value);

    String getPaymentChannelCode();

    void setPaymentChannelCode(String value);

    String getInstructionID();

    void setInstructionID(String value);

    List<String> getInstructionNote();

    void setInstructionNote(List<String> instructionNote);

    List<String> getPaymentID();

    void setPaymentID(List<String> paymentID);

    CardAccountModel getCardAccount();

    void setCardAccount(CardAccountModel value);

    FinancialAccountModel getPayerFinancialAccount();

    void setPayerFinancialAccount(FinancialAccountModel value);

    FinancialAccountModel getPayeeFinancialAccount();

    void setPayeeFinancialAccount(FinancialAccountModel value);

    CreditAccountModel getCreditAccount();

    void setCreditAccount(CreditAccountModel value);

    String getId();


}
