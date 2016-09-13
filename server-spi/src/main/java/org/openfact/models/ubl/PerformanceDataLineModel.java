package org.openfact.models.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to define a line in a Performance History.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:42 a. m.
 */
public class PerformanceDataLineModel {

    /**
     * An identifier for this performance data line.
     */
    private IdentifierModel ID;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextModel note;
    /**
     * A code signifying the measure of performance applicable to the reported
     * attribute.
     */
    private CodeModel performanceMetricTypeCode;
    /**
     * The value of the reported attribute.
     */
    private QuantityModel performanceValueQuantity;
    private List<ItemModel> items = new ArrayList<>();
    private List<PeriodModel> periods = new ArrayList<>();

}
