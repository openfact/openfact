package org.openfact.models.jpa.entities.ubl;
import java.math.BigDecimal;

/**
 * A class to define a reference to a transaction line in a billing document.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:09 a. m.
 */
public class BillingReferenceLine {

	private BigDecimal Amount;
	private String ID;
	private AllowanceCharge m_AllowanceCharge;


	/**
	 * The monetary amount of the transaction line, including any allowances and
	 * charges but excluding taxes.
	 */
	public BigDecimal getAmount() {
		return Amount;
	}

	public void setAmount(BigDecimal amount) {
		Amount = amount;
	}

	/**
	 * An identifier for this transaction line in a billing document.
	 */
	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}


	public AllowanceCharge getM_AllowanceCharge() {
		return m_AllowanceCharge;
	}

	public void setM_AllowanceCharge(AllowanceCharge m_AllowanceCharge) {
		this.m_AllowanceCharge = m_AllowanceCharge;
	}
}//end BillingReference Line