package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document used to forecast sales or orders.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:20:35 a. m.
 */
public class Forecast{

	/**
	 * Indicates whether the Forecast is based on consensus (true) or not (false).
	 */
	private IndicatorType BasedOnConsensusIndicator;
	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private IndicatorType CopyIndicator;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private IdentifierType CustomizationID;
	/**
	 * A code signifying the purpose of the Forecast document.
	 */
	private CodeType ForecastPurposeCode;
	/**
	 * An identifier for this document, assigned by the sender.
	 */
	private IdentifierType ID;
	/**
	 * The date, assigned by the sender, on which this document was issued.
	 */
	private DateType IssueDate;
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private TimeType IssueTime;
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType Note;
	/**
	 * Identifies an instance of executing a profile, to associate all transactions in
	 * a collaboration.
	 */
	private IdentifierType ProfileExecutionID;
	/**
	 * Identifies a user-defined profile of the customization of UBL being used.
	 */
	private IdentifierType ProfileID;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private IdentifierType UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID;
	/**
	 * Identifies the current version of this document.
	 */
	private IdentifierType VersionID;
	private CustomerParty BuyerCustomerParty;
	private DocumentReference AdditionalDocumentReference;
	private List<ForecastLine> ForecastLines = new ArrayList<>();
	private Party ReceiverParty;
	private Party SenderParty;
	private Period ForecastPeriod;
	private List<Signature> Signatures = new ArrayList<>();
	private SupplierParty SellerSupplierParty;

}
