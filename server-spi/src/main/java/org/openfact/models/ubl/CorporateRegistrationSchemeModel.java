package org.openfact.models.ubl;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe a scheme for corporate registration.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:09 a. m.
 */
public class CorporateRegistrationSchemeModel {

    /**
     * A code signifying the type of this registration scheme.
     */
    private CodeType corporateRegistrationTypeCode;
    /**
     * An identifier for this registration scheme.
     */
    private IdentifierType ID;
    /**
     * The name of this registration scheme.
     */
    private NameType name;
    private AddressModel jurisdictionRegionAddress;

}
