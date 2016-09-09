package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.IdentifierType;

/**
 * A class to describe an individual, a group, or a body having a procurement
 * role in a tendering process.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:06 a. m.
 */
public class ContractingPartyEntity {

    /**
     * The buyer profile is typically located on a web site where the
     * contracting party publishes its procurement opportunities
     */
    private IdentifierType BuyerProfileURIID;
    private List<ContractingActivityEntity> ContractingActivities = new ArrayList<>();
    private List<ContractingPartyEntity> TypeContractingPartyTypes = new ArrayList<>();
    private List<PartyEntity> Parties = new ArrayList<>();

}
