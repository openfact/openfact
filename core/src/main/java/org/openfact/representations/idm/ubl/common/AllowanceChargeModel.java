package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;
import java.util.List;

public class AllowanceChargeModel {
    protected String ID;
    protected boolean ChargeIndicator;
    protected String AllowanceChargeReasonCode;
    protected String AllowanceChargeReason;
    protected BigDecimal MultiplierFactorNumeric;
    protected boolean PrepaidIndicator;
    protected BigDecimal SequenceNumeric;
    protected BigDecimal Amount;
    protected BigDecimal BaseAmount;
    protected String AccountingCostCode;
    protected String AccountingCost;
    protected List<TaxCategoryModel> TaxCategory;
    protected TaxTotalModel TaxTotal;
    protected List<PaymentMeansModel> PaymentMeans;
    protected String Id;
}