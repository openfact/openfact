package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document used to specify the thresholds for forecast variance, product
 * activity, and performance history beyond which exceptions should be triggered.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:20:34 a. m.
 */
public class ExceptionCriteriaModel{

	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private IndicatorType copyIndicator; 
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private IdentifierType customizationID; 
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
	private IdentifierType UBLVersionID; 
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID; 
	/**
	 * Identifies the current version of this document.
	 */
	private IdentifierType versionID; 
	private CustomerPartyModel buyerCustomerParty; 
	private List<DocumentReferenceModel> documentReferences = new ArrayList<>(); 
	private List<ExceptionCriteriaModel> lineExceptionCriteriaLines = new ArrayList<>(); 
	private PartyModel receiverParty; 
	private PartyModel senderParty; 
	private PeriodModel validityPeriod; 
	private List<SignatureModel> signatures = new ArrayList<>(); 
	private SupplierPartyModel sellerSupplierParty; 

}