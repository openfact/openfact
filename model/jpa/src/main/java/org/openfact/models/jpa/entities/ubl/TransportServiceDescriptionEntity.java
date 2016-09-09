package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document sent by a transport service provider to announce the availability of
 * a transport service.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:43 a. m.
 */
public class TransportServiceDescriptionEntity{

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
	 * A code signifying a response related to the TransportServiceDescription.
	 */
	private CodeType responseCode; 
	/**
	 * A name, assigned by the Transport Service Provider, for the service being
	 * announced.
	 */
	private NameType serviceName; 
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private IdentifierType UBLVersionID; 
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID; 
	private DocumentReferenceEntity transportServiceDescriptionRequestDocumentReference; 
	private PartyEntity senderParty; 
	private PartyEntity receiverParty; 
	private PartyEntity transportServiceProviderParty; 
	private PaymentTermsEntity serviceChargePaymentTerms; 
	private PeriodEntity validityPeriod; 
	private List<SignatureEntity> signatures = new ArrayList<>(); 
	private List<TransportationServiceEntity> transportationServices = new ArrayList<>(); 

}
