package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document used to forecast sales or orders.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:20:35 a. m.
 */
public class ForecastAdapter{

	/**
	 * Indicates whether the ForecastAdapter is based on consensus (true) or not (false).
	 */
	private IndicatorType basedOnConsensusIndicator;
	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private IndicatorType copyIndicator;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private IdentifierType customizationID;
	/**
	 * A code signifying the purpose of the ForecastAdapter document.
	 */
	private CodeType forecastPurposeCode;
	/**
	 * An identifier for this document, assigned by the sender.
	 */
	private IdentifierType ID;
	/**
	 * The date, assigned by the sender, on which this document was issued.
	 */
	private DateType issueDate;
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private TimeType issueTime;
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType note;
	/**
	 * Identifies an instance of executing a profile, to associate all transactions in
	 * a collaboration.
	 */
	private IdentifierType profileExecutionID;
	/**
	 * Identifies a user-defined profile of the customization of UBL being used.
	 */
	private IdentifierType profileID;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private IdentifierType UBLversionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID;
	/**
	 * Identifies the current version of this document.
	 */
	private IdentifierType versionID;
	private CustomerPartyAdapter buyerCustomerParty;
	private DocumentReferenceAdapter additionalDocumentReference;
	private List<ForecastLineAdapter> forecastLines = new ArrayList<>();
	private PartyAdapter receiverParty;
	private PartyAdapter senderParty;
	private PeriodAdapter forecastPeriod;
	private List<SignatureAdapter> signatures = new ArrayList<>();
	private SupplierPartyAdapter sellerSupplierParty;

}
