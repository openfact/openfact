package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;
import java.util.List;

public class AllowanceChargeRepresentation {
    private String ID;
    private boolean ChargeIndicator;
    private String AllowanceChargeReasonCode;
    private String AllowanceChargeReason;
    private BigDecimal MultiplierFactorNumeric;
    private boolean PrepaidIndicator;
    private BigDecimal SequenceNumeric;
    private BigDecimal Amount;
    private BigDecimal BaseAmount;
    private String AccountingCostCode;
    private String AccountingCost;
    private List<TaxCategoryRepresentation> TaxCategory;
    private TaxTotalRepresentation TaxTotal;
    private List<PaymentMeansRepresentation> PaymentMeans;
    private String Id;
}