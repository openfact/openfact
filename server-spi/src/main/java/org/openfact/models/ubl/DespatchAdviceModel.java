package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A document used to describe the despatch or delivery of goods and services.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:20:29 a. m.
 */
public class DespatchAdviceModel {

    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private boolean copyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private IdentifierModel customizationID;
    /**
     * A code signifying the type of the DespatchAdvice.
     */
    private CodeModel despatchAdviceTypeCode;
    /**
     * A code signifying the status of the DespatchAdviceModel with respect to
     * its original state. This code may be used if the document precedes the
     * event and is subsequently found to be incorrect and in need of
     * cancellation or revision.
     */
    private DocumentStatusCodeModel codeTypeDocumentStatusCode;
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
     * The number of despatchLines in this document.
     */
    private BigDecimal lineCountNumeric;
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
    private CustomerPartyModel deliveryCustomerParty;
    private CustomerPartyModel buyerCustomerParty;
    private CustomerPartyModel originatorCustomerParty;
    private List<DespatchLineModel> despatchLines = new ArrayList<>();
    private DocumentReferenceModel additionalDocumentReference;
    private List<OrderReferenceModel> orderReferences = new ArrayList<>();
    private List<ShipmentModel> shipments = new ArrayList<>();
    private List<SignatureModel> signatures = new ArrayList<>();
    private SupplierPartyModel sellerSupplierParty;
    private SupplierPartyModel despatchSupplierParty;

}
