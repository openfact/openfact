package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;

/**
 * A class to describe a tendering framework agreement.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:22 a. m.
 */
public class FrameworkAgreement {

    /**
     * The number of economic operators expected to participate in this
     * framework agreement.
     */
    private BigDecimal expectedOperatorQuantity;
    /**
     * Text describing the frequency with which subsequent contracts will be
     * awarded.
     */
    private String frequency;
    /**
     * Text describing the justification for this framework agreement.
     */
    private String justification;
    /**
     * The maximum number of economic operators allowed to participate in this
     * framework agreement.
     */
    private BigDecimal maximumOperatorQuantity;
    private Period durationPeriod;
    private TenderRequirement subsequentProcessTenderRequirement;

    public FrameworkAgreement() {

    }

    public void finalize() throws Throwable {

    }

    public BigDecimal getExpectedOperatorQuantity() {
        return expectedOperatorQuantity;
    }

    public void setExpectedOperatorQuantity(BigDecimal expectedOperatorQuantity) {
        this.expectedOperatorQuantity = expectedOperatorQuantity;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public BigDecimal getMaximumOperatorQuantity() {
        return maximumOperatorQuantity;
    }

    public void setMaximumOperatorQuantity(BigDecimal maximumOperatorQuantity) {
        this.maximumOperatorQuantity = maximumOperatorQuantity;
    }

    public Period getDurationPeriod() {
        return durationPeriod;
    }

    public void setDurationPeriod(Period durationPeriod) {
        this.durationPeriod = durationPeriod;
    }

    public TenderRequirement getSubsequentProcessTenderRequirement() {
        return subsequentProcessTenderRequirement;
    }

    public void setSubsequentProcessTenderRequirement(TenderRequirement subsequentProcessTenderRequirement) {
        this.subsequentProcessTenderRequirement = subsequentProcessTenderRequirement;
    }
}// end FrameworkAgreement