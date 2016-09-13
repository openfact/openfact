package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to define an application for a CertificateRepresentation of Origin
 * (CoO).
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:30 a. m.
 */
public class CertificateOfOriginApplicationRepresentation {

    /**
     * A code signifying the status of the application (revision, replacement,
     * etc.).
     */
    private CodeRepresentation applicationStatusCode;
    /**
     * The type of CoO being applied for (Ordinary, Re-export, Commonwealth
     * Preferential, etc.).
     */
    private TextRepresentation certificateType;
    /**
     * The latest job number given to the CoO application. This is used by the
     * system to keep track of amendments to or cancellation of any earlier
     * applications.
     */
    private IdentifierRepresentation originalJobID;
    /**
     * An identifier for the previous job used in case the application requires
     * query or change.
     */
    private IdentifierRepresentation previousJobID;
    /**
     * An identifier for a reference as part of the CoO application.
     */
    private IdentifierRepresentation referenceID;
    /**
     * remarks by the applicant for the CoO.
     */
    private TextRepresentation remarks;
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
