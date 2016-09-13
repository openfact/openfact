package org.openfact.representations.idm.ubl;

import org.openfact.representations.idm.ubl.type.QuantityRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to describe a tendering framework agreement.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:22 a. m.
 */
public class FrameworkAgreementRepresentation {

    /**
     * The number of economic operators expected to participate in this
     * framework agreement.
     */
    private QuantityRepresentation expectedOperatorQuantity;
    /**
     * Text describing the frequency with which subsequent contracts will be
     * awarded.
     */
    private TextRepresentation frequency;
    /**
     * Text describing the justification for this framework agreement.
     */
    private TextRepresentation justification;
    /**
     * The maximum number of economic operators allowed to participate in this
     * framework agreement.
     */
    private QuantityRepresentation maximumOperatorQuantity;
    private PeriodRepresentation durationPeriod;
    private TenderRequirementRepresentation subsequentProcessTenderRequirement;

}
