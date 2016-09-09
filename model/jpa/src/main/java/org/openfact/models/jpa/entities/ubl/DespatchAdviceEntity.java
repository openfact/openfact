package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.DocumentStatusCodeType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.IndicatorType;
import org.openfact.models.jpa.entities.ublType.NumericType;
import org.openfact.models.jpa.entities.ublType.TextType;
import org.openfact.models.jpa.entities.ublType.TimeType;

/**
 * A document used to describe the despatch or delivery of goods and services.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:20:29 a. m.
 */
public class DespatchAdviceEntity {

    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private IndicatorType CopyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private IdentifierType CustomizationID;
    /**
     * A code signifying the type of the DespatchAdvice.
     */
    private CodeType DespatchAdviceTypeCode;
    /**
     * A code signifying the status of the DespatchAdviceEntity with respect to
     * its original state. This code may be used if the document precedes the
     * event and is subsequently found to be incorrect and in need of
     * cancellation or revision.
     */
    private DocumentStatusCodeType CodeTypeDocumentStatusCode;
    /**
     * An identifier for this document, assigned by the sender.
     */
    private IdentifierType ID;
    /**
     * The date, assigned by the sender, on which this document was issued.
     */
    private DateType IssueDate;
    /**
     * The time, assigned by the sender, at which this document was issued.
     */
    private TimeType IssueTime;
    /**
     * The number of DespatchLines in this document.
     */
    private NumericType LineCountNumeric;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private TextType Note;
    /**
     * Identifies an instance of executing a profile, to associate all
     * transactions in a collaboration.
     */
    private IdentifierType ProfileExecutionID;
    /**
     * Identifies a user-defined profile of the customization of UBL being used.
     */
    private IdentifierType ProfileID;
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
    private CustomerPartyEntity DeliveryCustomerParty;
    private CustomerPartyEntity BuyerCustomerParty;
    private CustomerPartyEntity OriginatorCustomerParty;
    private List<DespatchLineEntity> DespatchLines = new ArrayList<>();
    private DocumentReferenceEntity AdditionalDocumentReference;
    private List<OrderReferenceEntity> OrderReferences = new ArrayList<>();
    private List<ShipmentEntity> Shipments = new ArrayList<>();
    private List<SignatureEntity> Signatures = new ArrayList<>();
    private SupplierPartyEntity SellerSupplierParty;
    private SupplierPartyEntity DespatchSupplierParty;

}
