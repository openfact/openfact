package org.openfact.models.jpa.entities.ubl;


import java.math.BigDecimal;

/**
 * A class to provide information about the preselection of a short list of
 * economic operators for consideration as possible candidates in a tendering
 * process.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:41 a. m.
 */
public class EconomicOperatorShortList {

	/**
	 * The number of economic operators expected to be on the short list.
	 */
	private BigDecimal expectedQuantity;
	/**
	 * Text describing the criteria used to restrict the number of candidates.
	 */
	private String limitationDescription;
	/**
	 * The maximum number of economic operators on the short list.
	 */
	private BigDecimal maximumQuantity;
	/**
	 * The minimum number of economic operators on the short list.
	 */
	private BigDecimal minimumQuantity;
	private Party preSelectedParty;

	public BigDecimal getExpectedQuantity() {
		return expectedQuantity;
	}

	public void setExpectedQuantity(BigDecimal expectedQuantity) {
		this.expectedQuantity = expectedQuantity;
	}

	public String getLimitationDescription() {
		return limitationDescription;
	}

	public void setLimitationDescription(String limitationDescription) {
		this.limitationDescription = limitationDescription;
	}

	public BigDecimal getMaximumQuantity() {
		return maximumQuantity;
	}

	public void setMaximumQuantity(BigDecimal maximumQuantity) {
		this.maximumQuantity = maximumQuantity;
	}

	public BigDecimal getMinimumQuantity() {
		return minimumQuantity;
	}

	public void setMinimumQuantity(BigDecimal minimumQuantity) {
		this.minimumQuantity = minimumQuantity;
	}

	public Party getPreSelectedParty() {
		return preSelectedParty;
	}

	public void setPreSelectedParty(Party preSelectedParty) {
		this.preSelectedParty = preSelectedParty;
	}
}//end EconomicOperatorShortList