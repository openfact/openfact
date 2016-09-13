package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to describe an endorsement of a document.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:45 a. m.
 */
public class EndorsementRepresentation {

    /**
     * The status of this endorsement.
     */
    private TextRepresentation approvalStatus;
    /**
     * An identifier for this endorsement.
     */
    private IdentifierRepresentation documentID;
    /**
     * remarks provided by the endorsing party.
     */
    private TextRepresentation remarks;
    private List<EndorserPartyRepresentation> endorserParties = new ArrayList<>();
    private List<SignatureRepresentation> signatures = new ArrayList<>();

}
