package org.openfact.representations.idm.ubl;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.NameRepresentation;

/**
 * A class to describe a scheme for corporate registration.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:09 a. m.
 */
public class CorporateRegistrationSchemeRepresentation {

    /**
     * A code signifying the type of this registration scheme.
     */
    private CodeRepresentation corporateRegistrationTypeCode;
    /**
     * An identifier for this registration scheme.
     */
    private IdentifierRepresentation ID;
    /**
     * The name of this registration scheme.
     */
    private NameRepresentation name;
    private AddressRepresentation jurisdictionRegionAddress;

}
