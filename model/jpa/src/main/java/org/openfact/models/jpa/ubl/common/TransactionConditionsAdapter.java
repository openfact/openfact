package org.openfact.models.jpa.ubl.common;

import java.util.List;

public class TransactionConditionsAdapter
        implements TransactionConditionsModel, JpaModel<TransactionConditionsEntity> {

    protected static final Logger logger = Logger.getLogger(TransactionConditionsAdapter.class);
    protected TransactionConditionsEntity transactionConditions;
    protected EntityManager em;
    protected OpenfactSession session;

    public TransactionConditionsAdapter(OpenfactSession session, EntityManager em,
            TransactionConditionsEntity transactionConditions) {
        this.session = session;
        this.em = em;
        this.transactionConditions = transactionConditions;
    }

    String getID() {
        return this.transactionConditions.getID();
    }

    void setID(String value) {
        this.transactionConditions.setID(value);
    }

    String getActionCode() {
        return this.transactionConditions.getActionCode();
    }

    void setActionCode(String value) {
        this.transactionConditions.setActionCode(value);
    }

    List<String> getDescription() {
        return this.transactionConditions.getDescription();
    }

    void setDescription(List<String> description) {
        this.transactionConditions.setDescription(description);
    }

    List<DocumentReferenceAdapter> getDocumentReference() {
        return this.transactionConditions.getDocumentReference();
    }

    void setDocumentReference(List<DocumentReferenceAdapter> documentReference) {
        this.transactionConditions.setDocumentReference(documentReference);
    }

    String getId() {
        return this.transactionConditions.getId();
    }

    void setId(String value) {
        this.transactionConditions.setId(value);
    }

}
