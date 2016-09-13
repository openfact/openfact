package org.openfact.models.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe a trade financing instrument.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:31 a. m.
 */
public class TradeFinancingModel {

    /**
     * A code signifying the type of this financing instrument.
     */
    private CodeModel financingInstrumentCode;
    /**
     * An identifier for this trade financing instrument.
     */
    private IdentifierModel ID;
    private List<ClauseModel> clauses = new ArrayList<>();
    private List<DocumentReferenceModel> contractDocumentReference = new ArrayList<>();
    private List<DocumentReferenceModel> documentReferences = new ArrayList<>();
    private FinancialAccountModel financingFinancialAccount;
    private PartyModel financingParty;

}