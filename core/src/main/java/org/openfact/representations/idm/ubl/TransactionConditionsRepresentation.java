package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeType;
import org.openfact.representations.idm.ubl.type.IdentifierType;
import org.openfact.representations.idm.ubl.type.TextType;

/**
 * A class to describe purchasing, sales, or payment conditions.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:35 a. m.
 */
public class TransactionConditionsRepresentation {

    /**
     * A code signifying a type of action relating to sales or payment
     * conditions.
     */
    private CodeType actionCode;
    /**
     * Text describing the transaction conditions.
     */
    private TextType description;
    /**
     * An identifier for conditions of the transaction, typically purchase/sales
     * conditions.
     */
    private IdentifierType ID;
    private List<DocumentReferenceRepresentation> documentReferences = new ArrayList<>();

}
