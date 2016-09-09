package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define an application for a CertificateAdapter of Origin (CoO).
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:30 a. m.
 */
public class CertificateOfOriginApplicationAdapter{

	/**
	 * A code signifying the status of the application (revision, replacement, etc.).
	 */
	private CodeType applicationStatusCode; 
	/**
	 * The type of CoO being applied for (Ordinary, Re-export, Commonwealth
	 * Preferential, etc.).
	 */
	private TextType certificateType; 
	/**
	 * The latest job number given to the CoO application. This is used by the system
	 * to keep track of amendments to or cancellation of any earlier applications.
	 */
	private IdentifierType originalJobID; 
	/**
	 * An identifier for the previous job used in case the application requires query
	 * or change.
	 */
	private IdentifierType previousJobID; 
	/**
	 * An identifier for a reference as part of the CoO application.
	 */
	private IdentifierType referenceID; 
	/**
	 * remarks by the applicant for the CoO.
	 */
	private TextType remarks; 
	private List<DocumentDistributionAdapter> documentDistributions = new ArrayList<>(); 
	private DocumentReferenceAdapter supportingDocumentReference; 
	private List<EndorserPartyAdapter> endorserParties = new ArrayList<>(); 
	private PartyAdapter preparationParty; 
	private PartyAdapter exporterParty; 
	private PartyAdapter issuerParty; 
	private PartyAdapter importerParty; 
	private List<ShipmentAdapter> shipments = new ArrayList<>(); 
	private List<SignatureAdapter> signatures = new ArrayList<>(); 
	private CountryAdapter issuingCountry; 

}
