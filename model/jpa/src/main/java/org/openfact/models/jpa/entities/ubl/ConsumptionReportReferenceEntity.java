package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.QuantityType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class to define a reference to an earlier consumption report (e.g., last
 * year's consumption).
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:56 a. m.
 */
public class ConsumptionReportReferenceEntity {

    /**
     * An identifier for the referenced consumption report.
     */
    private IdentifierType ConsumptionReportID;
    /**
     * The reported consumption type, expressed as text.
     */
    private TextType ConsumptionType;
    /**
     * The reported consumption type, expressed as a code.
     */
    private CodeType ConsumptionTypeCode;
    /**
     * The total quantity consumed during the period of the referenced report.
     */
    private QuantityType TotalConsumedQuantity;
    private List<PeriodEntity> Periods = new ArrayList<>();

}
