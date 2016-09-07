package org.openfact.models.jpa.entities.ubl;

/**
 * The charging rate used for both call charging and time dependent charging
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:38 a. m.
 */
public class Duty {

    /**
     * The amount of this duty.
     */
    private BigDecimal Amount;
    /**
     * Text describing this duty.
     */
    private String Duty;
    /**
     * The type of this charge rate, expressed as a code.
     */
    private String DutyCode;
    private Tax Category
    m_Tax Category;

    public Duty() {

    }

    public void finalize() throws Throwable {

    }

    public BigDecimal getAmount() {
        return Amount;
    }

    public String getDuty() {
        return Duty;
    }

    public String getDutyCode() {
        return DutyCode;
    }

    public Tax Category

    getTax Category(){
		return m_Tax Category;
	}

    /**
     * 
     * @param newVal
     */
    public void setAmount(BigDecimal newVal) {
        Amount = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setDuty(String newVal) {
        Duty = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setDutyCode(String newVal) {
        DutyCode = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setTax

    Category(Tax Category newVal){
		m_Tax Category = newVal;
	}
}// end Duty