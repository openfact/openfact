package org.openfact.models.ubl.common;

public interface CardAccountModel {

    PrimaryAccountNumberIDModel getPrimaryAccountNumberID();

    void setPrimaryAccountNumberID(PrimaryAccountNumberIDModel value);

    NetworkIDModel getNetworkID();

    void setNetworkID(NetworkIDModel value);

    String getCardModelCode();

    void setCardModelCode(String value);

    ValidityStartDateModel getValidityStartDate();

    void setValidityStartDate(ValidityStartDateModel value);

    ExpiryDateModel getExpiryDate();

    void setExpiryDate(ExpiryDateModel value);

    IssuerIDModel getIssuerID();

    void setIssuerID(IssuerIDModel value);

    IssueNumberIDModel getIssueNumberID();

    void setIssueNumberID(IssueNumberIDModel value);

    CV2IDModel getCV2ID();

    void setCV2ID(CV2IDModel value);

    String getCardChipCode();

    void setCardChipCode(String value);

    ChipApplicationIDModel getChipApplicationID();

    void setChipApplicationID(ChipApplicationIDModel value);

    HolderNameModel getHolderName();

    void setHolderName(HolderNameModel value);

    String getId();

    void setId(String value);

}
