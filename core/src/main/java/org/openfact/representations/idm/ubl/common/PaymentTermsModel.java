package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;
import java.util.List;

public interface PaymentTermsModel {

    String getID();

    void setID(String value);

    String getPaymentMeansID();

    void setPaymentMeansID(String value);

    String getPrepaidPaymentReferenceID();

    void setPrepaidPaymentReferenceID(String value);

    List<String> getNote();

    void setNote(List<String> note);

    String getReferenceEventCode();

    void setReferenceEventCode(String value);

    BigDecimal getSettlementDiscountPercent();

    void setSettlementDiscountPercent(BigDecimal value);

    BigDecimal getPenaltySurchargePercent();

    void setPenaltySurchargePercent(BigDecimal value);

    BigDecimal getAmount();

    void setAmount(BigDecimal value);

    PeriodModel getSettlementPeriod();

    void setSettlementPeriod(PeriodModel value);

    PeriodModel getPenaltyPeriod();

    void setPenaltyPeriod(PeriodModel value);

    String getId();

    void setId(String value);

}
