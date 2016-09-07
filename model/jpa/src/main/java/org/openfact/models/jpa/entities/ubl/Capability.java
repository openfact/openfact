package org.openfact.models.jpa.entities.ubl;

/**
 * A class to describe a specific capability of an organization.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:15 a. m.
 */
public class Capability {

    /**
     * This class can be used as Financial or Technical capabilities. For
     * instance, "Turnover" or "Qualified Engineers" are two possible codes.
     */
    private String CapabilityTypeCode;
    /**
     * Text describing this capability.
     */
    private String Description;
    /**
     * A monetary amount as a measure of this capability.
     */
    private BigDecimal ValueAmount;
    /**
     * A quantity as a measure of this capability.
     */
    private Quantity.Type ValueQuantity;
    private Evidence Supplied
    m_Evidence Supplied;
    private Period Validity Period;

    public Capability() {

    }

    public void finalize() throws Throwable {

    }

    public String getCapabilityTypeCode() {
        return CapabilityTypeCode;
    }

    public String getDescription() {
        return Description;
    }

    public Evidence Supplied

    getEvidence Supplied(){
		return m_Evidence Supplied;
	}

    public Period getValidity

    Period(){
		return Validity Period;
	}

    public BigDecimal getValueAmount() {
        return ValueAmount;
    }

    public Quantity.Type getValueQuantity() {
        return ValueQuantity;
    }

    /**
     * 
     * @param newVal
     */
    public void setCapabilityTypeCode(String newVal) {
        CapabilityTypeCode = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setDescription(String newVal) {
        Description = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setEvidence

    Supplied(Evidence Supplied newVal){
		m_Evidence Supplied = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setValidity

    Period(Period newVal){
		Validity Period = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setValueAmount(BigDecimal newVal) {
        ValueAmount = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setValueQuantity(Quantity.Type newVal) {
        ValueQuantity = newVal;
    }
}// end Capability