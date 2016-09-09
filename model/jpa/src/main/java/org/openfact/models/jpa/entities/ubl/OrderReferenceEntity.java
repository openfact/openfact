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
    private IndicatorType CopyIndicator;
    /**
     * Text used for tagging purchasing card transactions.
     */
    private TextType CustomerReference;
    /**
     * An identifier for this order reference, assigned by the buyer.
     */
    private IdentifierType ID;
    /**
     * The date on which the referenced OrderEntity was issued.
     */
    private DateType IssueDate;
    /**
     * The time at which the referenced OrderEntity was issued.
     */
    private TimeType IssueTime;
    /**
     * A code signifying the type of the referenced Order.
     */
    private CodeType OrderTypeCode;
    /**
     * An identifier for this order reference, assigned by the seller.
     */
    private IdentifierType SalesOrderID;
    /**
     * A universally unique identifier for this order reference.
     */
    private IdentifierType UUID;
    private List<DocumentReferenceEntity> DocumentReferences = new ArrayList<>();

}
