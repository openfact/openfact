package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;
import java.util.List;

public class PaymentTermsModel {
    protected String ID;
    protected String PaymentMeansID;
    protected String PrepaidPaymentReferenceID;
    protected List<String> Note;
    protected String ReferenceEventCode;
    protected BigDecimal SettlementDiscountPercent;
    protected BigDecimal PenaltySurchargePercent;
    protected BigDecimal Amount;
    protected PeriodModel SettlementPeriod;
    protected PeriodModel PenaltyPeriod;
    protected String Id;
}