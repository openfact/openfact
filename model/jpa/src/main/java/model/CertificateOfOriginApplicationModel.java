package model;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define an application for a CertificateModel of Origin (CoO).
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:30 a. m.
 */
public class CertificateOfOriginApplicationModel{

	/**
	 * A code signifying the status of the application (revision, replacement, etc.).
	 */
	private CodeType ApplicationStatusCode;
	/**
	 * The type of CoO being applied for (Ordinary, Re-export, Commonwealth
	 * Preferential, etc.).
	 */
	private TextType CertificateType;
	/**
	 * The latest job number given to the CoO application. This is used by the system
	 * to keep track of amendments to or cancellation of any earlier applications.
	 */
	private IdentifierType OriginalJobID;
	/**
	 * An identifier for the previous job used in case the application requires query
	 * or change.
	 */
	private IdentifierType PreviousJobID;
	/**
	 * An identifier for a reference as part of the CoO application.
	 */
	private IdentifierType ReferenceID;
	/**
	 * Remarks by the applicant for the CoO.
	 */
	private TextType Remarks;
	private List<DocumentDistributionModel> DocumentDistributions = new ArrayList<>();
	private DocumentReferenceModel SupportingDocumentReference;
	private List<EndorserPartyModel> EndorserParties = new ArrayList<>();
	private PartyModel PreparationParty;
	private PartyModel ExporterParty;
	private PartyModel IssuerParty;
	private PartyModel ImporterParty;
	private List<ShipmentModel> Shipments = new ArrayList<>();
	private List<SignatureModel> Signatures = new ArrayList<>();
	private CountryModel IssuingCountry;

}
