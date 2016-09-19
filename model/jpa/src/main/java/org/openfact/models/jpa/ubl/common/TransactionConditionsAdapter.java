package org.openfact.models.jpa.ubl.common;

import java.util.List;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.ubl.common.DocumentReferenceModel;
import org.openfact.models.ubl.common.TransactionConditionsModel;

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

    @Override
    public String getID() {
        return this.transactionConditions.getID();
    }

    @Override
    public void setID(String value) {
        this.transactionConditions.setID(value);
    }

    @Override
    public String getActionCode() {
        return this.transactionConditions.getActionCode();
    }

    @Override
    public void setActionCode(String value) {
        this.transactionConditions.setActionCode(value);
    }

    @Override
    public List<String> getDescription() {
        return this.transactionConditions.getDescription();
    }

    @Override
    public void setDescription(List<String> description) {
        this.transactionConditions.setDescription(description);
    }

    @Override
    public List<DocumentReferenceModel> getDocumentReference() {
        return this.transactionConditions.getDocumentReference();
    }

    @Override
    public void setDocumentReference(List<DocumentReferenceAdapter> documentReference) {
        this.transactionConditions.setDocumentReference(documentReference);
    }

    @Override
    public String getId() {
        return this.transactionConditions.getId();
    }

    @Override
    public void setId(String value) {
        this.transactionConditions.setId(value);
    }

}
