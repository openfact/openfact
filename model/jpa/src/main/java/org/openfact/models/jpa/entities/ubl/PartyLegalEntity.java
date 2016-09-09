package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.AmountType;
import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.IndicatorType;
import org.openfact.models.jpa.entities.ublType.NameType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class to describe a party as a legal entity.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:28 a. m.
 */
public class PartyLegalEntity {

    /**
     * An identifier for the party as registered within a company registration
     * scheme.
     */
    private IdentifierType CompanyID;
    /**
     * The company legal status, expressed as a text.
     */
    private TextType CompanyLegalForm;
    /**
     * A code signifying the party's legal status.
     */
    private CodeType CompanyLegalFormCode;
    /**
     * A code signifying the party's liquidation status.
     */
    private CodeType CompanyLiquidationStatusCode;
    /**
     * The number of shares in the capital stock of a corporation.
     */
    private AmountType CorporateStockAmount;
    /**
     * An indicator that all shares of corporate stock have been paid by
     * shareholders (true) or not (false).
     */
    private IndicatorType FullyPaidSharesIndicator;
    /**
     * The registration date of the CompanyID.
     */
    private DateType RegistrationDate;
    /**
     * The date upon which a registration expires (e.g., registration for an
     * import/export license).
     */
    private DateType RegistrationExpirationDate;
    /**
     * The name of the party as registered with the relevant legal authority.
     */
    private NameType RegistrationName;
    /**
     * An indicator that the company is owned and controlled by one person
     * (true) or not (false).
     */
    private IndicatorType SoleProprietorshipIndicator;
    private AddressEntity RegistrationAddress;
    private List<CorporateRegistrationSchemeEntity> CorporateRegistrationSchemes = new ArrayList<>();
    private PartyEntity HeadOfficeParty;
    private List<ShareholderPartyEntity> ShareholderParties = new ArrayList<>();

}
