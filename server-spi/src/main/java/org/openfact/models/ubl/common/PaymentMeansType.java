package org.openfact.models.ubl.common;

import java.util.List;

public interface PaymentMeansType {

    IDType getID();

    void setID(IDType value);

    PaymentMeansCodeTypeCommBas getPaymentMeansCode();

    void setPaymentMeansCode(PaymentMeansCodeTypeCommBas value);

    PaymentDueDateType getPaymentDueDate();

    void setPaymentDueDate(PaymentDueDateType value);

    PaymentChannelCodeType getPaymentChannelCode();

    void setPaymentChannelCode(PaymentChannelCodeType value);

    InstructionIDType getInstructionID();

    void setInstructionID(InstructionIDType value);

    List<InstructionNoteType> getInstructionNote();

    void setInstructionNote(List<InstructionNoteType> instructionNote);

    List<PaymentIDType> getPaymentID();

    void setPaymentID(List<PaymentIDType> paymentID);

    CardAccountType getCardAccount();

    void setCardAccount(CardAccountType value);

    FinancialAccountType getPayerFinancialAccount();

    void setPayerFinancialAccount(FinancialAccountType value);

    FinancialAccountType getPayeeFinancialAccount();

    void setPayeeFinancialAccount(FinancialAccountType value);

    CreditAccountType getCreditAccount();

    void setCreditAccount(CreditAccountType value);

    String getId();

    void setId(String value);

}
