package org.openfact.models.ubl.common;

public interface DeliveryTermsType {

    IDType getID();

    void setID(IDType value);

    SpecialTermsType getSpecialTerms();

    void setSpecialTerms(SpecialTermsType value);

    LossRiskResponsibilityCodeType getLossRiskResponsibilityCode();

    void setLossRiskResponsibilityCode(LossRiskResponsibilityCodeType value);

    LossRiskType getLossRisk();

    void setLossRisk(LossRiskType value);

    LocationTypeCommAgg getDeliveryLocation();

    void setDeliveryLocation(LocationTypeCommAgg value);

    AllowanceChargeType getAllowanceCharge();

    void setAllowanceCharge(AllowanceChargeType value);

    String getId();

    void setId(String value);

}
