package org.openfact.models.jpa.entities.ubl;

/**
 * A class to describe a trade financing instrument.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:31 a. m.
 */
public class TradeFinancing {

    /**
     * A code signifying the type of this financing instrument.
     */
    private String FinancingInstrumentCode;
    /**
     * An identifier for this trade financing instrument.
     */
    private String ID;
    private Clause m_Clause;
    private DocumentReference ContractDocumentReference;
    private DocumentReference m_DocumentReference;
    private FinancialAccount FinancingFinancialAccount;
    private Party FinancingParty;

    /**
     * @return the financingInstrumentCode
     */
    public String getFinancingInstrumentCode() {
        return FinancingInstrumentCode;
    }

    /**
     * @param financingInstrumentCode
     *            the financingInstrumentCode to set
     */
    public void setFinancingInstrumentCode(String financingInstrumentCode) {
        FinancingInstrumentCode = financingInstrumentCode;
    }

    /**
     * @return the iD
     */
    public String getID() {
        return ID;
    }

    /**
     * @param iD
     *            the iD to set
     */
    public void setID(String iD) {
        ID = iD;
    }

    /**
     * @return the m_Clause
     */
    public Clause getM_Clause() {
        return m_Clause;
    }

    /**
     * @param m_Clause
     *            the m_Clause to set
     */
    public void setM_Clause(Clause m_Clause) {
        this.m_Clause = m_Clause;
    }

    /**
     * @return the contractDocumentReference
     */
    public DocumentReference getContractDocumentReference() {
        return ContractDocumentReference;
    }

    /**
     * @param contractDocumentReference
     *            the contractDocumentReference to set
     */
    public void setContractDocumentReference(DocumentReference contractDocumentReference) {
        ContractDocumentReference = contractDocumentReference;
    }

    /**
     * @return the m_DocumentReference
     */
    public DocumentReference getM_DocumentReference() {
        return m_DocumentReference;
    }

    /**
     * @param m_DocumentReference
     *            the m_DocumentReference to set
     */
    public void setM_DocumentReference(DocumentReference m_DocumentReference) {
        this.m_DocumentReference = m_DocumentReference;
    }

    /**
     * @return the financingFinancialAccount
     */
    public FinancialAccount getFinancingFinancialAccount() {
        return FinancingFinancialAccount;
    }

    /**
     * @param financingFinancialAccount
     *            the financingFinancialAccount to set
     */
    public void setFinancingFinancialAccount(FinancialAccount financingFinancialAccount) {
        FinancingFinancialAccount = financingFinancialAccount;
    }

    /**
     * @return the financingParty
     */
    public Party getFinancingParty() {
        return FinancingParty;
    }

    /**
     * @param financingParty
     *            the financingParty to set
     */
    public void setFinancingParty(Party financingParty) {
        FinancingParty = financingParty;
    }

}// end TradeFinancing