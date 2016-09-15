package org.openfact.models.ubl.common;

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

    SettlementDiscountPercentModel getSettlementDiscountPercent();

    void setSettlementDiscountPercent(SettlementDiscountPercentModel value);

    PenaltySurchargePercentModel getPenaltySurchargePercent();

    void setPenaltySurchargePercent(PenaltySurchargePercentModel value);

    AmountModelCommBas getAmount();

    void setAmount(AmountModelCommBas value);

    PeriodModel getSettlementPeriod();

    void setSettlementPeriod(PeriodModel value);

    PeriodModel getPenaltyPeriod();

    void setPenaltyPeriod(PeriodModel value);

    String getId();

    void setId(String value);

}
