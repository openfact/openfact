package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A supplement to an InvoiceModel or CreditNote, containing information on the
* consumption ofservicesprovidedbyutilitysupplierstoprivateandpublic 
 * customers, including electricity, gas, water, and telephone services.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:50 a. m.
 */
public class UtilityStatementModel{

	/**
	 * The buyer's accounting cost code, applied to the UtilityStatement, expressed as
	 * text.
	 */
	private TextType accountingCost; 
	/**
	 * The buyer's accounting cost code, applied to the UtilityStatement.
	 */
	private CodeType accountingCostCode; 
	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private IndicatorType copyIndicator; 
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private IdentifierType customizationID; 
	/**
	 * A code signifying the default currency for this document.
	 */
	private CurrencyCodeType codeTypeDocumentCurrencyCode; 
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
	 * A code signifying the type of UtilityStatement.
	 */
	private CodeType utilityStatementTypeCode; 
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID; 
	private List<CustomerPartyModel> customerParties = new ArrayList<>(); 
	private DocumentReferenceModel parentDocumentReference; 
	private DocumentReferenceModel additionalDocumentReference; 
	private OnAccountPaymentModel mainOnAccountPayment; 
	private PartyModel receiverParty; 
	private PartyModel subscriberParty; 
	private PartyModel senderParty; 
	private List<SignatureModel> signatures = new ArrayList<>(); 
	private List<SubscriberConsumptionModel> subscriberConsumptions = new ArrayList<>(); 

}
