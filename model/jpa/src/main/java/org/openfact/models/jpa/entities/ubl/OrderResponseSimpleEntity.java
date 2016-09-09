package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.IndicatorType;
import org.openfact.models.jpa.entities.ublType.TextType;
import org.openfact.models.jpa.entities.ublType.TimeType;

/**
 * A document used to indicate simple acceptance or rejection of an entire
 * Order.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:04 a. m.
 */
public class OrderResponseSimpleEntity {

    /**
     * Indicates whether the OrderEntity is accepted (true) or rejected (false).
     */
    private IndicatorType AcceptedIndicator;
    /**
     * An accounting cost code applied to the order as a whole, expressed as
     * text.
     */
    private TextType AccountingCost;
    /**
     * An accounting cost code applied to the order as a whole.
     */
    private CodeType AccountingCostCode;
    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private IndicatorType CopyIndicator;
    /**
     * A supplementary reference for the transaction (e.g., when using a
     * purchasing card).
     */
    private TextType CustomerReference;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private IdentifierType CustomizationID;
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
     * The reason for rejection if the order was not accepted.
     */
    private TextType RejectionNote;
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
    private CustomerPartyEntity AccountingCustomerParty;
    private CustomerPartyEntity OriginatorCustomerParty;
    private CustomerPartyEntity BuyerCustomerParty;
    private DocumentReferenceEntity AdditionalDocumentReference;
    private List<OrderReferenceEntity> OrderReferences = new ArrayList<>();
    private List<SignatureEntity> Signatures = new ArrayList<>();
    private SupplierPartyEntity AccountingSupplierParty;
    private SupplierPartyEntity SellerSupplierParty;

}
