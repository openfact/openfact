package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.QuantityType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class to define a line in a Performance History.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:42 a. m.
 */
public class PerformanceDataLineEntity {

    /**
     * An identifier for this performance data line.
     */
    private IdentifierType ID;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextType note;
    /**
     * A code signifying the measure of performance applicable to the reported
     * attribute.
     */
    private CodeType performanceMetricTypeCode;
    /**
     * The value of the reported attribute.
     */
    private QuantityType performanceValueQuantity;
    private List<ItemEntity> items = new ArrayList<>();
    private List<PeriodEntity> periods = new ArrayList<>();

}
