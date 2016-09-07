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
	private BigDecimal maximumCopiesNumeric;
	/**
	 * Text describing the interested party's distribution rights.
	 */
	private String printQualifier;
	private Party m_Party;

	public DocumentDistribution(){

	}

	public void finalize() throws Throwable {

	}

	public BigDecimal getMaximumCopiesNumeric() {
		return maximumCopiesNumeric;
	}

	public void setMaximumCopiesNumeric(BigDecimal maximumCopiesNumeric) {
		this.maximumCopiesNumeric = maximumCopiesNumeric;
	}

	public String getPrintQualifier() {
		return printQualifier;
	}

	public void setPrintQualifier(String printQualifier) {
		this.printQualifier = printQualifier;
	}

	public Party getM_Party() {
		return m_Party;
	}

	public void setM_Party(Party m_Party) {
		this.m_Party = m_Party;
	}
}//end Document Distribution