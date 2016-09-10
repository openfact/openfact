package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.openfact.models.ubl.type.*;

/**
 * A class that refers to a phase of work. Used for instance to specify what
 * part of the contract the billing is referring to.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:19:01 a. m.
 */
public class WorkPhaseReferenceModel {

    /**
     * The date on which this phase of work ends.
     */
    private LocalDate endDate;
    /**
     * An identifier for this phase of work.
     */
    private IdentifierType ID;
    /**
     * The progress percentage of the work phase.
     */
    private BigDecimal progressPercent;
    /**
     * The date on which this phase of work begins.
     */
    private LocalDate startDate;
    /**
     * Text describing this phase of work.
     */
    private TextType workPhase;
    /**
     * A code signifying this phase of work.
     */
    private CodeType workPhaseCode;
    private DocumentReferenceModel workOrderDocumentReference;

}
