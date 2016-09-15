package org.openfact.models.ubl.common;

public interface DocumentDistributionModel {

    String getPrintQualifier();

    void setPrintQualifier(String value);

    MaximumCopiesNumericModel getMaximumCopiesNumeric();

    void setMaximumCopiesNumeric(MaximumCopiesNumericModel value);

    PartyModel getParty();

    void setParty(PartyModel value);

    String getId();

    void setId(String value);

}
