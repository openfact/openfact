package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.QuantityType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class to describe a tendering framework agreement.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:22 a. m.
 */
public class FrameworkAgreementEntity {

    /**
     * The number of economic operators expected to participate in this
     * framework agreement.
     */
    private QuantityType ExpectedOperatorQuantity;
    /**
     * Text describing the frequency with which subsequent contracts will be
     * awarded.
     */
    private TextType Frequency;
    /**
     * Text describing the justification for this framework agreement.
     */
    private TextType Justification;
    /**
     * The maximum number of economic operators allowed to participate in this
     * framework agreement.
     */
    private QuantityType MaximumOperatorQuantity;
    private PeriodEntity DurationPeriod;
    private TenderRequirementEntity SubsequentProcessTenderRequirement;

}
