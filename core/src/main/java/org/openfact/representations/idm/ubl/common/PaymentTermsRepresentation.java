package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;
import java.util.List;

public class PaymentTermsRepresentation {
    private String ID;
    private String paymentMeansID;
    private String prepaidPaymentReferenceID;
    private List<String> note;
    private String referenceEventCode;
    private BigDecimal settlementDiscountPercent;
    private BigDecimal penaltySurchargePercent;
    private BigDecimal amount;
    private PeriodRepresentation settlementPeriod;
    private PeriodRepresentation penaltyPeriod;
    private String id;
}
