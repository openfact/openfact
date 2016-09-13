package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.CurrencyCodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.NameRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to describe a financial account.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:11 a. m.
 */
public class FinancialAccountRepresentation {

    /**
     * A code signifying the format of this financial account.
     */
    private CodeRepresentation accountFormatCode;
    /**
     * A code signifying the type of this financial account.
     */
    private CodeRepresentation accountTypeCode;
    /**
     * An alias for the name of this financial account, to be used in place of
     * the actual account name for security reasons.
     */
    private NameRepresentation aliasName;
    /**
     * A code signifying the currency in which this financial account is held.
     */
    private CurrencyCodeRepresentation codeTypeCurrencyCode;
    /**
     * The identifier for this financial account; the bank account number.
     */
    private IdentifierRepresentation ID;
    /**
     * The name of this financial account.
     */
    private NameRepresentation name;
    /**
     * Free-form text applying to the PaymentRepresentation for the owner of
     * this account.
     */
    private TextRepresentation paymentNote;
    private BranchRepresentation financialInstitutionBranch;
    private List<CountryRepresentation> countries = new ArrayList<>();

}
