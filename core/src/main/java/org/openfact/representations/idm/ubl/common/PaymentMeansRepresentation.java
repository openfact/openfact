package org.openfact.representations.idm.ubl.common;

import java.time.LocalDate;
import java.util.List;

public class PaymentMeansRepresentation {
    private String ID;
    private String PaymentMeansCode;
    private LocalDate PaymentDueDate;
    private String PaymentChannelCode;
    private String InstructionID;
    private List<String> InstructionNote;
    private List<String> PaymentID;
    private CardAccountRepresentation CardAccount;
    private FinancialAccountRepresentation PayerFinancialAccount;
    private FinancialAccountRepresentation PayeeFinancialAccount;
    private CreditAccountRepresentation CreditAccount;
    private String Id;
}