package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to describe a party contracting to provide services, such as
 * transportation, finance, etc.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:41 a. m.
 */
public class ServiceProviderPartyRepresentation {

    /**
     * An identifier for this service provider.
     */
    private IdentifierRepresentation ID;
    /**
     * The type of service provided, expressed as text.
     */
    private TextRepresentation serviceType;
    /**
     * The type of service provided, expressed as a code.
     */
    private CodeRepresentation serviceTypeCode;
    private ContactRepresentation sellerContact;
    private List<PartyRepresentation> parties = new ArrayList<>();

}
