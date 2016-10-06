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
