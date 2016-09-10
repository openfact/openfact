package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.CodeType;

/**
 * A class to describe the party endorsing a document.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:46 a. m.
 */
public class EndorserPartyEntity {

    /**
     * A code specifying the role of the party providing the endorsement (e.g.,
     * issuer, embassy, insurance, etc.).
     */
    private CodeType roleCode;
    /**
     * A number indicating the order of the endorsement provided by this party
     * in the sequence in which endorsements are to be applied.
     */
    private BigDecimal sequenceNumeric;
    private ContactEntity signatoryContact;
    private List<PartyEntity> parties = new ArrayList<>();

}
