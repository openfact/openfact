package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class that refers to a phase of work. Used for instance to specify what
 * part of the contract the billing is referring to.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:19:01 a. m.
 */
public class WorkPhaseReferenceRepresentation {

    /**
     * The date on which this phase of work ends.
     */
    private LocalDate endDate;
    /**
     * An identifier for this phase of work.
     */
    private IdentifierRepresentation ID;
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
    private TextRepresentation workPhase;
    /**
     * A code signifying this phase of work.
     */
    private CodeRepresentation workPhaseCode;
    private DocumentReferenceRepresentation workOrderDocumentReference;

}
