package org.openfact.models.ubl;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe a tendering framework agreement.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:22 a. m.
 */
public class FrameworkAgreementModel {

    /**
     * The number of economic operators expected to participate in this
     * framework agreement.
     */
    private QuantityModel expectedOperatorQuantity;
    /**
     * Text describing the frequency with which subsequent contracts will be
     * awarded.
     */
    private TextModel frequency;
    /**
     * Text describing the justification for this framework agreement.
     */
    private TextModel justification;
    /**
     * The maximum number of economic operators allowed to participate in this
     * framework agreement.
     */
    private QuantityModel maximumOperatorQuantity;
    private PeriodModel durationPeriod;
    private TenderRequirementModel subsequentProcessTenderRequirement;

}
