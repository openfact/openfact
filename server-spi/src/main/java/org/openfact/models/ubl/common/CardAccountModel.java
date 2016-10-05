package org.openfact.models.ubl.common;

import java.time.LocalDate;

public interface CardAccountModel {

    String getPrimaryAccountNumberID();

    void setPrimaryAccountNumberID(String value);

    String getNetworkID();

    void setNetworkID(String value);

    String getCardCode();

    void setCardCode(String value);

    LocalDate getValidityStartDate();

    void setValidityStartDate(LocalDate value);

    LocalDate getExpiryDate();

    void setExpiryDate(LocalDate value);

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

    

}
