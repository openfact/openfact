package org.openfact.models.ubl.common;

public interface DocumentDistributionModel {

    PrintQualifierModel getPrintQualifier();

    void setPrintQualifier(PrintQualifierModel value);

    MaximumCopiesNumericModel getMaximumCopiesNumeric();

    void setMaximumCopiesNumeric(MaximumCopiesNumericModel value);

    PartyModel getParty();

    void setParty(PartyModel value);

    String getId();

    void setId(String value);

}
