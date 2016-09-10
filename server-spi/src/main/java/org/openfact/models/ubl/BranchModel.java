package org.openfact.models.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe a branch or a division of an organization.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:13:10 a. m.
 */
public class BranchModel {

    /**
     * An identifier for this branch or division of an organization.
     */
    private IdentifierType ID;
    /**
     * The name of this branch or division of an organization.
     */
    private NameType name;
    private List<AddressModel> addresses = new ArrayList<>();
    private List<FinancialInstitutionModel> financialInstitutions = new ArrayList<>();

}
