package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;

/**
 * A class to describe a trade financing instrument.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:31 a. m.
 */
public class TradeFinancingEntity {

    /**
     * A code signifying the type of this financing instrument.
     */
    private CodeType FinancingInstrumentCode;
    /**
     * An identifier for this trade financing instrument.
     */
    private IdentifierType ID;
    private List<ClauseEntity> Clauses = new ArrayList<>();
    private List<DocumentReferenceEntity> ContractDocumentReference = new ArrayList<>();
    private List<DocumentReferenceEntity> DocumentReferences = new ArrayList<>();
    private FinancialAccountEntity FinancingFinancialAccount;
    private PartyEntity FinancingParty;

}
