package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

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
    private List<Clause> clauses = new ArrayList<>();
    private DocumentReference ContractDocumentReference;
    private List<DocumentReference> documentReferences = new ArrayList<>();
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
     * @return the clauses
     */
    public List<Clause> getClauses() {
        return clauses;
    }

    /**
     * @param clauses
     *            the clauses to set
     */
    public void setClauses(List<Clause> clauses) {
        this.clauses = clauses;
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
     * @return the documentReferences
     */
    public List<DocumentReference> getDocumentReferences() {
        return documentReferences;
    }

    /**
     * @param documentReferences
     *            the documentReferences to set
     */
    public void setDocumentReferences(List<DocumentReference> documentReferences) {
        this.documentReferences = documentReferences;
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