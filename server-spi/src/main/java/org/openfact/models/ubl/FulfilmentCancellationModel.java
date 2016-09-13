package org.openfact.models.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A document used to cancel an entire fulfilment document (DespatchAdviceModel
 * or ReceiptAdvice).
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:20:42 a. m.
 */
public class FulfilmentCancellationModel {

    /**
     * The reason for cancellation of the referenced document.
     */
    private TextModel cancellationNote;
    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private boolean copyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private IdentifierModel customizationID;
    /**
     * An identifier for this document, assigned by the sender.
     */
    private IdentifierModel ID;
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
    private TextModel note;
    /**
     * Identifies an instance of executing a profile, to associate all
     * transactions in a collaboration.
     */
    private IdentifierModel profileExecutionID;
    /**
     * Identifies a user-defined profile of the customization of UBL being used.
     */
    private IdentifierModel profileID;
    /**
     * Identifies the earliest version of the UBL 2 schema for this document
     * type that defines all of the elements that might be encountered in the
     * current instance.
     */
    private IdentifierModel UBLVersionID;
    /**
     * A universally unique identifier for an instance of this document.
     */
    private IdentifierModel UUID;
    private List<ContractModel> contracts = new ArrayList<>();
    private CustomerPartyModel buyerCustomerParty;
    private CustomerPartyModel originatorCustomerParty;
    private CustomerPartyModel deliveryCustomerParty;
    private DocumentReferenceModel additionalDocumentReference;
    private DocumentReferenceModel receiptDocumentReference;
    private DocumentReferenceModel despatchDocumentReference;
    private List<OrderReferenceModel> orderReferences = new ArrayList<>();
    private List<SignatureModel> signatures = new ArrayList<>();
    private SupplierPartyModel despatchSupplierParty;
    private SupplierPartyModel sellerSupplierParty;

}
