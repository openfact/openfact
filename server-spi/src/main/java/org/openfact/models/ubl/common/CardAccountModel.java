package org.openfact.models.ubl.common;

public interface CardAccountModel {

    String getPrimaryAccountNumberID();

    void setPrimaryAccountNumberID(String value);

    String getNetworkID();

    void setNetworkID(String value);

    String getCardModelCode();

    void setCardModelCode(String value);

    ValidityStartDateModel getValidityStartDate();

    void setValidityStartDate(ValidityStartDateModel value);

    ExpiryDateModel getExpiryDate();

    void setExpiryDate(ExpiryDateModel value);

    String getIssuerID();

    void setIssuerID(String value);

    String getIssueNumberID();

    void setIssueNumberID(String value);

    String getCV2ID();

    void setCV2ID(String value);

    String getCardChipCode();

    void setCardChipCode(String value);

    String getChipApplicationID();

    void setChipApplicationID(String value);

    String getHolderName();

    void setHolderName(String value);

    String getId();

    void setId(String value);

}
