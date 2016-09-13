package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.QuantityRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to define a line in a Performance History.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:42 a. m.
 */
public class PerformanceDataLineRepresentation {

    /**
     * An identifier for this performance data line.
     */
    private IdentifierRepresentation ID;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextRepresentation note;
    /**
     * A code signifying the measure of performance applicable to the reported
     * attribute.
     */
    private CodeRepresentation performanceMetricTypeCode;
    /**
     * The value of the reported attribute.
     */
    private QuantityRepresentation performanceValueQuantity;
    private List<ItemRepresentation> items = new ArrayList<>();
    private List<PeriodRepresentation> periods = new ArrayList<>();

}
