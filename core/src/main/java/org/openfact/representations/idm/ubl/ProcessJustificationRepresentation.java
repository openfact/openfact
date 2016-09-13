package org.openfact.representations.idm.ubl;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to describe a justification for the choice of tendering process.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:02 a. m.
 */
public class ProcessJustificationRepresentation {

    /**
     * Text providing justification for the selection of this process.
     */
    private TextRepresentation description;
    /**
     * A code signifying the type of the previous tendering process (which is
     * now being cancelled).
     */
    private CodeRepresentation previousCancellationReasonCode;
    /**
     * The reason why the contracting authority has followed a particular
     * tendering procedure for the awarding of a contract, expressed as text.
     */
    private TextRepresentation processReason;
    /**
     * The reason why the contracting authority has followed a particular
     * tendering procedure for the awarding of a contract, expressed as a code.
     */
    private CodeRepresentation processReasonCode;

}
