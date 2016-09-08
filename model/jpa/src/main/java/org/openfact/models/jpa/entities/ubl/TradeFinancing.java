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
    private String financingInstrumentCode;
    /**
     * An identifier for this trade financing instrument.
     */
    private String id;
    private List<Clause> clauses = new ArrayList<>();
    private DocumentReference contractDocumentReference;
    private List<DocumentReference> documentReferences = new ArrayList<>();
    private FinancialAccount financingFinancialAccount;
    private Party financingParty;

    public String getFinancingInstrumentCode() {
        return financingInstrumentCode;
    }

    public void setFinancingInstrumentCode(String financingInstrumentCode) {
        this.financingInstrumentCode = financingInstrumentCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Clause> getClauses() {
        return clauses;
    }

    public void setClauses(List<Clause> clauses) {
        this.clauses = clauses;
    }

    public DocumentReference getContractDocumentReference() {
        return contractDocumentReference;
    }

    public void setContractDocumentReference(DocumentReference contractDocumentReference) {
        this.contractDocumentReference = contractDocumentReference;
    }

    public List<DocumentReference> getDocumentReferences() {
        return documentReferences;
    }

    public void setDocumentReferences(List<DocumentReference> documentReferences) {
        this.documentReferences = documentReferences;
    }

    public FinancialAccount getFinancingFinancialAccount() {
        return financingFinancialAccount;
    }

    public void setFinancingFinancialAccount(FinancialAccount financingFinancialAccount) {
        this.financingFinancialAccount = financingFinancialAccount;
    }

    public Party getFinancingParty() {
        return financingParty;
    }

    public void setFinancingParty(Party financingParty) {
        this.financingParty = financingParty;
    }
}// end TradeFinancing