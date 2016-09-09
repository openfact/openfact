package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A supplement to an Invoice or CreditNote, containing information on the
 * consumption ofservicesprovidedbyutilitysupplierstoprivateandpublic
 * customers, including electricity, gas, water, and telephone services.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:50 a. m.
 */
public class UtilityStatement{

	/**
	 * The buyer's accounting cost code, applied to the UtilityStatement, expressed as
	 * text.
	 */
	private TextType AccountingCost;
	/**
	 * The buyer's accounting cost code, applied to the UtilityStatement.
	 */
	private CodeType AccountingCostCode;
	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private boolean CopyIndicator;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private IdentifierType CustomizationID;
	/**
	 * A code signifying the default currency for this document.
	 */
	private CurrencyCodeType CodeTypeDocumentCurrencyCode;
	/**
	 * An identifier for this document, assigned by the sender.
	 */
	private IdentifierType ID;
	/**
	 * The date, assigned by the sender, on which this document was issued.
	 */
	private LocalDate IssueDate;
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private LocalTime IssueTime;
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
	 * A code signifying the type of UtilityStatement.
	 */
	private CodeType UtilityStatementTypeCode;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID;
	private List<CustomerParty> CustomerParties = new ArrayList<>();
	private DocumentReference ParentDocumentReference;
	private DocumentReference AdditionalDocumentReference;
	private OnAccountPayment MainOnAccountPayment;
	private Party ReceiverParty;
	private Party SubscriberParty;
	private Party SenderParty;
	private List<Signature> Signatures = new ArrayList<>();
	private List<SubscriberConsumption> SubscriberConsumptions = new ArrayList<>();

}
