package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.NameRepresentation;

/**
 * A class to describe a financial institution.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:15:14 a. m.
 */
public class FinancialInstitutionRepresentation {

    /**
     * An identifier for this financial institution. It is recommended that the
     * ISO 9362 Bank Identification Code (BIC) be used as the ID.
     */
    private IdentifierRepresentation ID;
    /**
     * The name of this financial institution.
     */
    private NameRepresentation name;
    private List<AddressRepresentation> addresses = new ArrayList<>();

}
