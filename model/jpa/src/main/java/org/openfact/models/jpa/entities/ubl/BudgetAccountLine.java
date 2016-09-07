package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;

/**
 * A class to define a budget account line.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:13 a. m.
 */
public class BudgetAccountLine {

    /**
     * An identifier for this budget account line.
     */
    private String ID;
    /**
     * The total monetary amount for this budget account line.
     */
    private BigDecimal TotalAmount;
    private BudgetAccount m_BudgetAccount;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public BigDecimal getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        TotalAmount = totalAmount;
    }

    public BudgetAccount getM_BudgetAccount() {
        return m_BudgetAccount;
    }

    public void setM_BudgetAccount(BudgetAccount m_BudgetAccount) {
        this.m_BudgetAccount = m_BudgetAccount;
    }
}// end BudgetAccountLine