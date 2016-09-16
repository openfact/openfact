package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;
import java.util.List;

public class PaymentTermsRepresentation {
    private String ID;
    private String PaymentMeansID;
    private String PrepaidPaymentReferenceID;
    private List<String> Note;
    private String ReferenceEventCode;
    private BigDecimal SettlementDiscountPercent;
    private BigDecimal PenaltySurchargePercent;
    private BigDecimal Amount;
    private PeriodRepresentation SettlementPeriod;
    private PeriodRepresentation PenaltyPeriod;
    private String Id;
}