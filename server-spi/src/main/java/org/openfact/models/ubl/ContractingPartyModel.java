package org.openfact.models.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe an individual, a group, or a body having a procurement
 * role in a tendering process.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:06 a. m.
 */
public class ContractingPartyModel {

    /**
     * The buyer profile is typically located on a web site where the
     * contracting party publishes its procurement opportunities
     */
    private IdentifierType buyerProfileURIID;
    private List<ContractingActivityModel> contractingActivities = new ArrayList<>();
    private List<ContractingPartyModel> typeContractingPartyTypes = new ArrayList<>();
    private List<PartyModel> parties = new ArrayList<>();

}
