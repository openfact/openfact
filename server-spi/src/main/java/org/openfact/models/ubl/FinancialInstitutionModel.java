package org.openfact.models.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe a financial institution.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:15:14 a. m.
 */
public class FinancialInstitutionModel {

    /**
     * An identifier for this financial institution. It is recommended that the
     * ISO 9362 Bank Identification Code (BIC) be used as the ID.
     */
    private IdentifierType ID;
    /**
     * The name of this financial institution.
     */
    private NameType name;
    private List<AddressModel> addresses = new ArrayList<>();

}
