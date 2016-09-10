package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.IdentifierType;
import org.openfact.representations.idm.ubl.type.NameType;

/**
 * A class to describe a branch or a division of an organization.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:13:10 a. m.
 */
public class BranchRepresentation {

    /**
     * An identifier for this branch or division of an organization.
     */
    private IdentifierType ID;
    /**
     * The name of this branch or division of an organization.
     */
    private NameType name;
    private List<AddressRepresentation> addresses = new ArrayList<>();
    private List<FinancialInstitutionRepresentation> financialInstitutions = new ArrayList<>();

}
