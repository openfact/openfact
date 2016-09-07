package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;

/**
 * A class to describe the distribution of a document to an interested party.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:32 a. m.
 */
public class DocumentDistribution {

	/**
	 * The maximum number of printed copies of the document that the interested party
	 * is allowed to make.
	 */
	private BigDecimal MaximumCopiesNumeric;
	/**
	 * Text describing the interested party's distribution rights.
	 */
	private String PrintQualifier;
	private Party m_Party;

	public Document Distribution(){

	}

	public void finalize() throws Throwable {

	}
	public BigDecimal getMaximumCopiesNumeric(){
		return MaximumCopiesNumeric;
	}

	public Party getParty(){
		return m_Party;
	}

	public String getPrintQualifier(){
		return PrintQualifier;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMaximumCopiesNumeric(BigDecimal newVal){
		MaximumCopiesNumeric = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setParty(Party newVal){
		m_Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPrintQualifier(String newVal){
		PrintQualifier = newVal;
	}
}//end Document Distribution