package org.openfact.models.ubl.common;

public interface TransportEquipmentSealModel {

    IDModel getID();

    void setID(IDModel value);

    SealIssuerModelCodeModel getSealIssuerModelCode();

    void setSealIssuerModelCode(SealIssuerModelCodeModel value);

    ConditionModel getCondition();

    void setCondition(ConditionModel value);

    SealStatusCodeModel getSealStatusCode();

    void setSealStatusCode(SealStatusCodeModel value);

    SealingPartyModelModel getSealingPartyModel();

    void setSealingPartyModel(SealingPartyModelModel value);

    String getId();

    void setId(String value);

}
