package org.openfact.models.ubl.common;

public interface DeliveryTermsModel {

    IDModel getID();

    void setID(IDModel value);

    SpecialTermsModel getSpecialTerms();

    void setSpecialTerms(SpecialTermsModel value);

    LossRiskResponsibilityCodeModel getLossRiskResponsibilityCode();

    void setLossRiskResponsibilityCode(LossRiskResponsibilityCodeModel value);

    LossRiskModel getLossRisk();

    void setLossRisk(LossRiskModel value);

    LocationModelCommAgg getDeliveryLocation();

    void setDeliveryLocation(LocationModelCommAgg value);

    AllowanceChargeModel getAllowanceCharge();

    void setAllowanceCharge(AllowanceChargeModel value);

    String getId();

    void setId(String value);

}
