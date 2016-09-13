package org.openfact.representations.idm.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.NameRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A document sent by a transport service provider to announce the availability
 * of a transport service.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:43 a. m.
 */
public class TransportServiceDescriptionRepresentation {

    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private boolean copyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private IdentifierRepresentation customizationID;
    /**
     * An identifier for this document, assigned by the sender.
     */
    private IdentifierRepresentation ID;
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
    private TextRepresentation note;
    /**
     * Identifies an instance of executing a profile, to associate all
     * transactions in a collaboration.
     */
    private IdentifierRepresentation profileExecutionID;
    /**
     * Identifies a user-defined profile of the customization of UBL being used.
     */
    private IdentifierRepresentation profileID;
    /**
     * A code signifying a response related to the TransportServiceDescription.
     */
    private CodeRepresentation responseCode;
    /**
     * A name, assigned by the Transport Service Provider, for the service being
     * announced.
     */
    private NameRepresentation serviceName;
    /**
     * Identifies the earliest version of the UBL 2 schema for this document
     * type that defines all of the elements that might be encountered in the
     * current instance.
     */
    private IdentifierRepresentation UBLVersionID;
    /**
     * A universally unique identifier for an instance of this document.
     */
    private IdentifierRepresentation UUID;
    private DocumentReferenceRepresentation transportServiceDescriptionRequestDocumentReference;
    private PartyRepresentation senderParty;
    private PartyRepresentation receiverParty;
    private PartyRepresentation transportServiceProviderParty;
    private PaymentTermsRepresentation serviceChargePaymentTerms;
    private PeriodRepresentation validityPeriod;
    private List<SignatureRepresentation> signatures = new ArrayList<>();
    private List<TransportationServiceRepresentation> transportationServices = new ArrayList<>();

}
