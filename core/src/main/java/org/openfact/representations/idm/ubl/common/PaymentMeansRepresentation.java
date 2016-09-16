package org.openfact.representations.idm.ubl.common;

import java.time.LocalDate;
import java.util.List;

public class PaymentMeansRepresentation {
    private String ID;
    private String paymentMeansCode;
    private LocalDate paymentDueDate;
    private String paymentChannelCode;
    private String instructionID;
    private List<String> instructionNote;
    private List<String> paymentID;
    private CardAccountRepresentation cardAccount;
    private FinancialAccountRepresentation payerFinancialAccount;
    private FinancialAccountRepresentation payeeFinancialAccount;
    private CreditAccountRepresentation creditAccount;
    private String id;
}
