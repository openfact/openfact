package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.CurrencyCodeType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.NameType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class to describe a financial account.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:11 a. m.
 */
public class FinancialAccountEntity {

    /**
     * A code signifying the format of this financial account.
     */
    private CodeType AccountFormatCode;
    /**
     * A code signifying the type of this financial account.
     */
    private CodeType AccountTypeCode;
    /**
     * An alias for the name of this financial account, to be used in place of
     * the actual account name for security reasons.
     */
    private NameType AliasName;
    /**
     * A code signifying the currency in which this financial account is held.
     */
    private CurrencyCodeType CodeTypeCurrencyCode;
    /**
     * The identifier for this financial account; the bank account number.
     */
    private IdentifierType ID;
    /**
     * The name of this financial account.
     */
    private NameType Name;
    /**
     * Free-form text applying to the PaymentEntity for the owner of this
     * account.
     */
    private TextType PaymentNote;
    private BranchEntity FinancialInstitutionBranch;
    private List<CountryEntity> Countries = new ArrayList<>();

}
