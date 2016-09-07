package org.openfact.models.jpa.entities.ubl;

/**
 * A class to describe the consumption of a utility.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:45 a. m.
 */
public class Consumption {

    /**
     * A code identifying the type of the Utility Statement required for this
     * consumption. Explains the kind of utility the statement is about, e.g..
     * "gas", "electricity", "telephone"
     */
    private String UtilityStatementTypeCode;
    private Allowance Charge
    m_Allowance Charge;
    private Energy Water
    Supply m_Energy
    Water Supply;
    private Monetary Total
    Legal Monetary Total;
    private Period Main Period;
    private Tax Total
    m_Tax Total;
    private Telecommunications Supply
    m_Telecommunications Supply;

    public Consumption() {

    }

    public void finalize() throws Throwable {

    }

    public Allowance Charge

    getAllowance Charge(){
		return m_Allowance Charge;
	}

    public Energy Water
    Supply getEnergy

    Water Supply(){
		return m_Energy Water Supply;
	}

    public Monetary Total
    getLegal Monetary

    Total(){
		return Legal Monetary Total;
	}

    public Period getMain

    Period(){
		return Main Period;
	}

    public Tax Total

    getTax Total(){
		return m_Tax Total;
	}

    public Telecommunications Supply

    getTelecommunications Supply(){
		return m_Telecommunications Supply;
	}

    public String getUtilityStatementTypeCode() {
        return UtilityStatementTypeCode;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setAllowance

    Charge(Allowance Charge newVal){
		m_Allowance Charge = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setEnergy

    Water Supply(Energy Water Supply newVal){
		m_Energy Water Supply = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setLegal

    Monetary Total(Monetary Total newVal){
		Legal Monetary Total = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setMain

    Period(Period newVal){
		Main Period = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setTax

    Total(Tax Total newVal){
		m_Tax Total = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setTelecommunications

    Supply(Telecommunications Supply newVal){
		m_Telecommunications Supply = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setUtilityStatementTypeCode(String newVal) {
        UtilityStatementTypeCode = newVal;
    }
}// end Consumption