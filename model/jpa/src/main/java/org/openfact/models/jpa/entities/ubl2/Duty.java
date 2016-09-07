package org.openfact.models.jpa.entities.ubl2;

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
    private Amount.Type Amount;
    /**
     * Text describing this duty.
     */
    private Text.Type Duty;
    /**
     * The type of this charge rate, expressed as a code.
     */
    private Code.Type DutyCode;
    private Tax Category
    m_Tax Category;

    public Duty() {

    }

    public void finalize() throws Throwable {

    }

    public Amount.Type getAmount() {
        return Amount;
    }

    public Text.Type getDuty() {
        return Duty;
    }

    public Code.Type getDutyCode() {
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
    public void setAmount(Amount.Type newVal) {
        Amount = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setDuty(Text.Type newVal) {
        Duty = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setDutyCode(Code.Type newVal) {
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