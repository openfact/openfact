package org.openfact.models.jpa.entities.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.CodeType;
import org.openfact.models.ubl.type.IdentifierType;
import org.openfact.models.ubl.type.TextType;

/**
 * A class to define a reference to an Order.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:18 a. m.
 */
public class OrderReferenceEntity {

    /**
     * Indicates whether the referenced OrderEntity is a copy (true) or the
     * original (false).
     */
    private boolean copyIndicator;
    /**
     * Text used for tagging purchasing card transactions.
     */
    private TextType customerReference;
    /**
     * An identifier for this order reference, assigned by the buyer.
     */
    private IdentifierType ID;
    /**
     * The date on which the referenced OrderEntity was issued.
     */
    private LocalDate issueDate;
    /**
     * The time at which the referenced OrderEntity was issued.
     */
    private LocalTime issueTime;
    /**
     * A code signifying the type of the referenced Order.
     */
    private CodeType orderTypeCode;
    /**
     * An identifier for this order reference, assigned by the seller.
     */
    private IdentifierType salesOrderID;
    /**
     * A universally unique identifier for this order reference.
     */
    private IdentifierType UUID;
    private List<DocumentReferenceEntity> documentReferences = new ArrayList<>();

}
