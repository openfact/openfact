package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;
import java.util.List;

public class AllowanceChargeRepresentation {
    private String ID;
    private boolean chargeIndicator;
    private String allowanceChargeReasonCode;
    private String allowanceChargeReason;
    private BigDecimal multiplierFactorNumeric;
    private boolean prepaidIndicator;
    private BigDecimal sequenceNumeric;
    private BigDecimal amount;
    private BigDecimal baseAmount;
    private String accountingCostCode;
    private String accountingCost;
    private List<TaxCategoryRepresentation> taxCategory;
    private TaxTotalRepresentation taxTotal;
    private List<PaymentMeansRepresentation> paymentMeans;
    private String id;
}
