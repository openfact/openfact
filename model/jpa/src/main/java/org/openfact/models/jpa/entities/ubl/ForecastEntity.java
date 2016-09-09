package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import org.openfact.models.jpa.entities.ublType.*;

/**
 * A document used to forecast sales or orders.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:20:35 a. m.
 */
public class ForecastEntity {

	/**
	 * Indicates whether the ForecastEntity is based on consensus (true) or not
	 * (false).
	 */
	private boolean basedOnConsensusIndicator;
	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private boolean copyIndicator;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private IdentifierType customizationID;
	/**
	 * A code signifying the purpose of the ForecastEntity document.
	 */
	private CodeType forecastPurposeCode;
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
	 * Free-form text pertinent to this document, conveying information that is
	 * not contained explicitly in other structures.
	 */
	private TextType note;
	/**
	 * Identifies an instance of executing a profile, to associate all
	 * transactions in a collaboration.
	 */
	private IdentifierType profileExecutionID;
	/**
	 * Identifies a user-defined profile of the customization of UBL being used.
	 */
	private IdentifierType profileID;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document
	 * type that defines all of the elements that might be encountered in the
	 * current instance.
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
	private CustomerPartyEntity buyerCustomerParty;
	private DocumentReferenceEntity additionalDocumentReference;
	private List<ForecastLineEntity> forecastLines = new ArrayList<>();
	private PartyEntity receiverParty;
	private PartyEntity senderParty;
	private PeriodEntity forecastPeriod;
	private List<SignatureEntity> signatures = new ArrayList<>();
	private SupplierPartyEntity sellerSupplierParty;

}
