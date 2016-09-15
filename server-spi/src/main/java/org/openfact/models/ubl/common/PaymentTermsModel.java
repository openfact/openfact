package org.openfact.models.ubl.common;

import java.util.List;

public interface PaymentTermsModel {

    IDModel getID();

    void setID(IDModel value);

    PaymentMeansIDModel getPaymentMeansID();

    void setPaymentMeansID(PaymentMeansIDModel value);

    PrepaidPaymentReferenceIDModel getPrepaidPaymentReferenceID();

    void setPrepaidPaymentReferenceID(PrepaidPaymentReferenceIDModel value);

    List<NoteModel> getNote();

    void setNote(List<NoteModel> note);

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
