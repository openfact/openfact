package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeType;
import org.openfact.representations.idm.ubl.type.MeasureType;
import org.openfact.representations.idm.ubl.type.TextType;

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
    private TextType description;
    /**
     * A code specifying the type of environmental emission.
     */
    private CodeType environmentalEmissionTypeCode;
    /**
     * A value measurement for the environmental emission.
     */
    private MeasureType valueMeasure;
    private List<EmissionCalculationMethodRepresentation> emissionCalculationMethods = new ArrayList<>();

}
