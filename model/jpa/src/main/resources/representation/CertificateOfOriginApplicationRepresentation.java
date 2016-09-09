package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define an application for a CertificateRepresentation of Origin (CoO).
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:30 a. m.
 */
public class CertificateOfOriginApplicationRepresentation{

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
	private List<DocumentDistributionRepresentation> documentDistributions = new ArrayList<>(); 
	private DocumentReferenceRepresentation supportingDocumentReference; 
	private List<EndorserPartyRepresentation> endorserParties = new ArrayList<>(); 
	private PartyRepresentation preparationParty; 
	private PartyRepresentation exporterParty; 
	private PartyRepresentation issuerParty; 
	private PartyRepresentation importerParty; 
	private List<ShipmentRepresentation> shipments = new ArrayList<>(); 
	private List<SignatureRepresentation> signatures = new ArrayList<>(); 
	private CountryRepresentation issuingCountry; 

}
