package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A report on the quantities of each item that are, or will be, in stock. This
 * document is sent by a Seller (for example a producer) to a Buyer (for example a
 * retailer).
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:27 a. m.
 */
public class StockAvailabilityReportRepresentation{

	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private boolean copyIndicator; 
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
	private LocalDate issueDate; 
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private LocalTime issueTime; 
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
	private CustomerPartyRepresentation retailerCustomerParty; 
	private List<DocumentReferenceRepresentation> documentReferences = new ArrayList<>(); 
	private PartyRepresentation inventoryReportingParty; 
	private PeriodRepresentation inventoryPeriod; 
	private List<SignatureRepresentation> signatures = new ArrayList<>(); 
	private List<StockAvailabilityReportRepresentation> lineStockAvailabilityReportLines = new ArrayList<>(); 
	private SupplierPartyRepresentation sellerSupplierParty; 

}
