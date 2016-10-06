package org.openfact.models.ubl.common;

import java.math.BigDecimal;

public interface DocumentDistributionModel {

    String getPrintQualifier();

    void setPrintQualifier(String value);

    BigDecimal getMaximumCopiesNumeric();

    void setMaximumCopiesNumeric(BigDecimal value);

    PartyModel getParty();

    void setParty(PartyModel value);

    String getId();

    

}
