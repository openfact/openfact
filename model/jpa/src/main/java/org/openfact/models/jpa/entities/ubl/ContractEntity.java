package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.TextType;
import org.openfact.models.jpa.entities.ublType.TimeType;

/**
 * A class to describe a contract.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:59 a. m.
 */
public class ContractEntity {

    /**
     * The type of this contract, expressed as text, such as "Cost plus award
     * fee" and "Cost plus fixed fee" from UNCEFACT ContractEntity Type code
     * list.
     */
    private TextType contractType;
    /**
     * The type of this contract, expressed as a code, such as "Cost plus award
     * fee" and "Cost plus fixed fee" from UNCEFACT ContractEntity Type code
     * list.
     */
    private CodeType contractTypeCode;
    /**
     * Text describing this contract.
     */
    private TextType description;
    /**
     * An identifier for this contract.
     */
    private IdentifierType ID;
    /**
     * The date on which this contract was issued.
     */
    private DateType issueDate;
    /**
     * The time at which this contract was issued.
     */
    private TimeType issueTime;
    /**
     * In a transportation contract, the deadline date by which the services
     * referred to in the transport execution plan have to be booked. For
     * example, if this service is a carrier service scheduled for Wednesday 16
     * February 2011 at 10 a.m. CET, the nomination
     */
    private DateType nominationDate;
    /**
     * In a transportation contract, the deadline time by which the services
     * referred to in the transport execution plan have to be booked. For
     * example, if this service is a carrier service scheduled for Wednesday 16
     * February 2011 at 10 a.m. CET, the nomination
     */
    private TimeType nominationTime;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextType note;
    /**
     * An identifier for the current version of this contract.
     */
    private IdentifierType versionID;
    private DeliveryEntity contractualDelivery;
    private DocumentReferenceEntity contractDocumentReference;
    private PeriodEntity validityPeriod;
    private PeriodEntity nominationPeriod;

}
