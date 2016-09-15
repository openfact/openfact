package org.openfact.models.ubl.common;

import java.util.List;

public interface PaymentTermsType {

    IDType getID();

    void setID(IDType value);

    PaymentMeansIDType getPaymentMeansID();

    void setPaymentMeansID(PaymentMeansIDType value);

    PrepaidPaymentReferenceIDType getPrepaidPaymentReferenceID();

    void setPrepaidPaymentReferenceID(PrepaidPaymentReferenceIDType value);

    List<NoteType> getNote();

    void setNote(List<NoteType> note);

    ReferenceEventCodeType getReferenceEventCode();

    void setReferenceEventCode(ReferenceEventCodeType value);

    SettlementDiscountPercentType getSettlementDiscountPercent();

    void setSettlementDiscountPercent(SettlementDiscountPercentType value);

    PenaltySurchargePercentType getPenaltySurchargePercent();

    void setPenaltySurchargePercent(PenaltySurchargePercentType value);

    AmountTypeCommBas getAmount();

    void setAmount(AmountTypeCommBas value);

    PeriodType getSettlementPeriod();

    void setSettlementPeriod(PeriodType value);

    PeriodType getPenaltyPeriod();

    void setPenaltyPeriod(PeriodType value);

    String getId();

    void setId(String value);

}
