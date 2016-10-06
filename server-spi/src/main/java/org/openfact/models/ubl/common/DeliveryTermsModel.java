package org.openfact.models.ubl.common;

public interface DeliveryTermsModel {

    String getID();

    void setID(String value);

    String getSpecialTerms();

    void setSpecialTerms(String value);

    String getLossRiskResponsibilityCode();

    void setLossRiskResponsibilityCode(String value);

    String getLossRisk();

    void setLossRisk(String value);

    LocationCommAggModel getDeliveryLocation();

    void setDeliveryLocation(LocationCommAggModel value);

    AllowanceChargeModel getAllowanceCharge();

    void setAllowanceCharge(AllowanceChargeModel value);

    String getId();

    

}
