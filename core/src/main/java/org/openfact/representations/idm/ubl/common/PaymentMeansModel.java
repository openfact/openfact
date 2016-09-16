package org.openfact.representations.idm.ubl.common;

import java.time.LocalDate;
import java.util.List;

public class PaymentMeansModel {
    protected String ID;
    protected String PaymentMeansCode;
    protected LocalDate PaymentDueDate;
    protected String PaymentChannelCode;
    protected String InstructionID;
    protected List<String> InstructionNote;
    protected List<String> PaymentID;
    protected CardAccountModel CardAccount;
    protected FinancialAccountModel PayerFinancialAccount;
    protected FinancialAccountModel PayeeFinancialAccount;
    protected CreditAccountModel CreditAccount;
    protected String Id;
}