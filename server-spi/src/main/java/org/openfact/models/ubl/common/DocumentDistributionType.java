package org.openfact.models.ubl.common;

public interface DocumentDistributionType {

    PrintQualifierType getPrintQualifier();

    void setPrintQualifier(PrintQualifierType value);

    MaximumCopiesNumericType getMaximumCopiesNumeric();

    void setMaximumCopiesNumeric(MaximumCopiesNumericType value);

    PartyType getParty();

    void setParty(PartyType value);

    String getId();

    void setId(String value);

}
