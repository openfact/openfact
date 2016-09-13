package org.openfact.models.ubl;

import java.time.LocalDate;
import java.time.LocalTime;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe a contract.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:59 a. m.
 */
public class ContractModel {

    /**
     * The type of this contract, expressed as text, such as "Cost plus award
     * fee" and "Cost plus fixed fee" from UNCEFACT ContractModel Type code
     * list.
     */
    private TextModel contractType;
    /**
     * The type of this contract, expressed as a code, such as "Cost plus award
     * fee" and "Cost plus fixed fee" from UNCEFACT ContractModel Type code
     * list.
     */
    private CodeModel contractTypeCode;
    /**
     * Text describing this contract.
     */
    private TextModel description;
    /**
     * An identifier for this contract.
     */
    private IdentifierModel ID;
    /**
     * The date on which this contract was issued.
     */
    private LocalDate issueDate;
    /**
     * The time at which this contract was issued.
     */
    private LocalTime issueTime;
    /**
     * In a transportation contract, the deadline date by which the services
     * referred to in the transport execution plan have to be booked. For
     * example, if this service is a carrier service scheduled for Wednesday 16
     * February 2011 at 10 a.m. CET, the nomination
     */
    private LocalDate nominationDate;
    /**
     * In a transportation contract, the deadline time by which the services
     * referred to in the transport execution plan have to be booked. For
     * example, if this service is a carrier service scheduled for Wednesday 16
     * February 2011 at 10 a.m. CET, the nomination
     */
    private LocalTime nominationTime;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextModel note;
    /**
     * An identifier for the current version of this contract.
     */
    private IdentifierModel versionID;
    private DeliveryModel contractualDelivery;
    private DocumentReferenceModel contractDocumentReference;
    private PeriodModel validityPeriod;
    private PeriodModel nominationPeriod;

}