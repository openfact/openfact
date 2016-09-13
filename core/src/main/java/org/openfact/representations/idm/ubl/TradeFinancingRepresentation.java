package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;

/**
 * A class to describe a trade financing instrument.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:31 a. m.
 */
public class TradeFinancingRepresentation {

    /**
     * A code signifying the type of this financing instrument.
     */
    private CodeRepresentation financingInstrumentCode;
    /**
     * An identifier for this trade financing instrument.
     */
    private IdentifierRepresentation ID;
    private List<ClauseRepresentation> clauses = new ArrayList<>();
    private List<DocumentReferenceRepresentation> contractDocumentReference = new ArrayList<>();
    private List<DocumentReferenceRepresentation> documentReferences = new ArrayList<>();
    private FinancialAccountRepresentation financingFinancialAccount;
    private PartyRepresentation financingParty;

}
