package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.MeasureRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to describe an environmental emission.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:50 a. m.
 */
public class EnvironmentalEmissionRepresentation {

    /**
     * Text describing this environmental emission.
     */
    private TextRepresentation description;
    /**
     * A code specifying the type of environmental emission.
     */
    private CodeRepresentation environmentalEmissionTypeCode;
    /**
     * A value measurement for the environmental emission.
     */
    private MeasureRepresentation valueMeasure;
    private List<EmissionCalculationMethodRepresentation> emissionCalculationMethods = new ArrayList<>();

}
