package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a party as a legal entity.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:28 a. m.
 */
public class PartyLegalEntity{

	/**
	 * An identifier for the party as registered within a company registration scheme.
	 */
	private IdentifierType companyID; 
	/**
	 * The company legal status, expressed as a text.
	 */
	private TextType companyLegalForm; 
	/**
	 * A code signifying the party's legal status.
	 */
	private CodeType companyLegalFormCode; 
	/**
	 * A code signifying the party's liquidation status.
	 */
	private CodeType companyLiquidationStatusCode; 
	/**
	 * The number of shares in the capital stock of a corporation.
	 */
	private AmountType corporateStockAmount; 
	/**
	 * An indicator that all shares of corporate stock have been paid by shareholders
	 * (true) or not (false).
	 */
	private IndicatorType fullyPaidSharesIndicator; 
	/**
	 * The registration date of the CompanyID.
	 */
	private DateType registrationDate; 
	/**
	 * The date upon which a registration expires (e.g., registration for an
	 * import/export license).
	 */
	private DateType registrationExpirationDate; 
	/**
	 * The name of the party as registered with the relevant legal authority.
	 */
	private NameType registrationName; 
	/**
	 * An indicator that the company is owned and controlled by one person (true) or
	 * not (false).
	 */
	private IndicatorType soleProprietorshipIndicator; 
	private AddressEntity registrationAddress; 
	private List<CorporateRegistrationSchemeEntity> corporateRegistrationSchemes = new ArrayList<>(); 
	private PartyEntity headOfficeParty; 
	private List<ShareholderPartyEntity> shareholderParties = new ArrayList<>(); 

}
