package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.NameType;

/**
 * A class to describe a branch or a division of an organization.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:13:10 a. m.
 */
public class BranchEntity {

    /**
     * An identifier for this branch or division of an organization.
     */
    private IdentifierType ID;
    /**
     * The name of this branch or division of an organization.
     */
    private NameType Name;
    private List<AddressEntity> Addresses = new ArrayList<>();
    private List<FinancialInstitutionEntity> FinancialInstitutions = new ArrayList<>();

}
