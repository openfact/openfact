package org.openfact.models.ubl.common;

public interface CardAccountType {

    PrimaryAccountNumberIDType getPrimaryAccountNumberID();

    void setPrimaryAccountNumberID(PrimaryAccountNumberIDType value);

    NetworkIDType getNetworkID();

    void setNetworkID(NetworkIDType value);

    CardTypeCodeType getCardTypeCode();

    void setCardTypeCode(CardTypeCodeType value);

    ValidityStartDateType getValidityStartDate();

    void setValidityStartDate(ValidityStartDateType value);

    ExpiryDateType getExpiryDate();

    void setExpiryDate(ExpiryDateType value);

    IssuerIDType getIssuerID();

    void setIssuerID(IssuerIDType value);

    IssueNumberIDType getIssueNumberID();

    void setIssueNumberID(IssueNumberIDType value);

    CV2IDType getCV2ID();

    void setCV2ID(CV2IDType value);

    CardChipCodeType getCardChipCode();

    void setCardChipCode(CardChipCodeType value);

    ChipApplicationIDType getChipApplicationID();

    void setChipApplicationID(ChipApplicationIDType value);

    HolderNameType getHolderName();

    void setHolderName(HolderNameType value);

    String getId();

    void setId(String value);

}
