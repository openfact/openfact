package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class to define an application for a CertificateEntity of Origin (CoO).
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:30 a. m.
 */
public class CertificateOfOriginApplicationEntity {

    /**
     * A code signifying the status of the application (revision, replacement,
     * etc.).
     */
    private CodeType ApplicationStatusCode;
    /**
     * The type of CoO being applied for (Ordinary, Re-export, Commonwealth
     * Preferential, etc.).
     */
    private TextType CertificateType;
    /**
     * The latest job number given to the CoO application. This is used by the
     * system to keep track of amendments to or cancellation of any earlier
     * applications.
     */
    private IdentifierType OriginalJobID;
    /**
     * An identifier for the previous job used in case the application requires
     * query or change.
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
    private List<DocumentDistributionEntity> DocumentDistributions = new ArrayList<>();
    private DocumentReferenceEntity SupportingDocumentReference;
    private List<EndorserPartyEntity> EndorserParties = new ArrayList<>();
    private PartyEntity PreparationParty;
    private PartyEntity ExporterParty;
    private PartyEntity IssuerParty;
    private PartyEntity ImporterParty;
    private List<ShipmentEntity> Shipments = new ArrayList<>();
    private List<SignatureEntity> Signatures = new ArrayList<>();
    private CountryEntity IssuingCountry;

}
