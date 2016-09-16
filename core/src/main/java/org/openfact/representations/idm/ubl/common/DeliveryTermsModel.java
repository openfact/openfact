package org.openfact.representations.idm.ubl.common;

public interface DeliveryTermsModel {

    String getID();

    void setID(String value);

    String getSpecialTerms();

    void setSpecialTerms(String value);

    String getLossRiskResponsibilityCode();

    void setLossRiskResponsibilityCode(String value);

    String getLossRisk();

    void setLossRisk(String value);

    LocationModelCommAgg getDeliveryLocation();

    void setDeliveryLocation(LocationModelCommAgg value);

    AllowanceChargeModel getAllowanceCharge();

    void setAllowanceCharge(AllowanceChargeModel value);

    String getId();

    void setId(String value);

}
