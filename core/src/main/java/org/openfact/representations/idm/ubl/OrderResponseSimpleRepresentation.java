package org.openfact.representations.idm.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A document used to indicate simple acceptance or rejection of an entire
 * Order.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:04 a. m.
 */
public class OrderResponseSimpleRepresentation {

    /**
     * Indicates whether the OrderRepresentation is accepted (true) or rejected
     * (false).
     */
    private boolean acceptedIndicator;
    /**
     * An accounting cost code applied to the order as a whole, expressed as
     * text.
     */
    private TextRepresentation accountingCost;
    /**
     * An accounting cost code applied to the order as a whole.
     */
    private CodeRepresentation accountingCostCode;
    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private boolean copyIndicator;
    /**
     * A supplementary reference for the transaction (e.g., when using a
     * purchasing card).
     */
    private TextRepresentation customerReference;
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
     * The reason for rejection if the order was not accepted.
     */
    private TextRepresentation rejectionNote;
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
    private CustomerPartyRepresentation accountingCustomerParty;
    private CustomerPartyRepresentation originatorCustomerParty;
    private CustomerPartyRepresentation buyerCustomerParty;
    private DocumentReferenceRepresentation additionalDocumentReference;
    private List<OrderReferenceRepresentation> orderReferences = new ArrayList<>();
    private List<SignatureRepresentation> signatures = new ArrayList<>();
    private SupplierPartyRepresentation accountingSupplierParty;
    private SupplierPartyRepresentation sellerSupplierParty;

}
