package org.openfact.models.jpa.entities.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.CodeType;
import org.openfact.models.ubl.type.IdentifierType;
import org.openfact.models.ubl.type.TextType;

/**
 * A document used to revise a Forecast.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:20:37 a. m.
 */
public class ForecastRevisionEntity {

    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private boolean copyIndicator;
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
     * Indicates the purpose of the revision.
     */
    private CodeType purposeCode;
    /**
     * Indicates the revision status of this ForecastRevision.
     */
    private CodeType revisionStatusCode;
    /**
     * A sequence number, to ensure the proper sequencing of revisions.
     */
    private IdentifierType sequenceNumberID;
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
    private CustomerPartyEntity buyerCustomerParty;
    private DocumentReferenceEntity originalDocumentReference;
    private List<ForecastRevisionEntity> lineForecastRevisionLines = new ArrayList<>();
    private PartyEntity senderParty;
    private PartyEntity receiverParty;
    private PeriodEntity forecastPeriod;
    private List<SignatureEntity> signatures = new ArrayList<>();
    private SupplierPartyEntity sellerSupplierParty;

}
