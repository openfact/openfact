package org.openfact.models.ubl.common;

import java.util.List;

public interface PaymentMeansModel {

    IDModel getID();

    void setID(IDModel value);

    PaymentMeansCodeModelCommBas getPaymentMeansCode();

    void setPaymentMeansCode(PaymentMeansCodeModelCommBas value);

    PaymentDueDateModel getPaymentDueDate();

    void setPaymentDueDate(PaymentDueDateModel value);

    PaymentChannelCodeModel getPaymentChannelCode();

    void setPaymentChannelCode(PaymentChannelCodeModel value);

    InstructionIDModel getInstructionID();

    void setInstructionID(InstructionIDModel value);

    List<InstructionNoteModel> getInstructionNote();

    void setInstructionNote(List<InstructionNoteModel> instructionNote);

    List<PaymentIDModel> getPaymentID();

    void setPaymentID(List<PaymentIDModel> paymentID);

    CardAccountModel getCardAccount();

    void setCardAccount(CardAccountModel value);

    FinancialAccountModel getPayerFinancialAccount();

    void setPayerFinancialAccount(FinancialAccountModel value);

    FinancialAccountModel getPayeeFinancialAccount();

    void setPayeeFinancialAccount(FinancialAccountModel value);

    CreditAccountModel getCreditAccount();

    void setCreditAccount(CreditAccountModel value);

    String getId();

    void setId(String value);

}
