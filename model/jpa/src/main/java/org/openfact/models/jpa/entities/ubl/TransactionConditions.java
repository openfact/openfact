package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe purchasing, sales, or payment conditions.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:35 a. m.
 */
public class TransactionConditions {

    /**
     * A code signifying a type of action relating to sales or payment
     * conditions.
     */
    private String actionCode;
    /**
     * Text describing the transaction conditions.
     */
    private String description;
    /**
     * An identifier for conditions of the transaction, typically purchase/sales
     * conditions.
     */
    private String id;
    private List<DocumentReference> documentReferences = new ArrayList<>();

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<DocumentReference> getDocumentReferences() {
        return documentReferences;
    }

    public void setDocumentReferences(List<DocumentReference> documentReferences) {
        this.documentReferences = documentReferences;
    }
}// end Transaction Conditions