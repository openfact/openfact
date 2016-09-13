package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

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
    private CodeRepresentation actionCode;
    /**
     * Text describing the transaction conditions.
     */
    private TextRepresentation description;
    /**
     * An identifier for conditions of the transaction, typically purchase/sales
     * conditions.
     */
    private IdentifierRepresentation ID;
    private List<DocumentReferenceRepresentation> documentReferences = new ArrayList<>();

}
