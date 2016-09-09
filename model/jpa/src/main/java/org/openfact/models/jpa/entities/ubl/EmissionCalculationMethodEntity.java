package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.CodeType;

/**
 * A class to define how an environmental emission is calculated.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:43 a. m.
 */
public class EmissionCalculationMethodEntity {

    /**
     * A code signifying the method used to calculate the emission.
     */
    private CodeType calculationMethodCode;
    /**
     * A code signifying whether a piece of transport equipment is full,
     * partially full, or empty. This indication is used as a parameter when
     * calculating the environmental emission.
     */
    private CodeType fullnessIndicationCode;
    private LocationEntity measurementToLocation;
    private LocationEntity measurementFromLocation;

}
