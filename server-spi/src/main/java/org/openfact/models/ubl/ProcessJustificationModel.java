package org.openfact.models.ubl;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe a justification for the choice of tendering process.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:02 a. m.
 */
public class ProcessJustificationModel {

    /**
     * Text providing justification for the selection of this process.
     */
    private TextType description;
    /**
     * A code signifying the type of the previous tendering process (which is
     * now being cancelled).
     */
    private CodeType previousCancellationReasonCode;
    /**
     * The reason why the contracting authority has followed a particular
     * tendering procedure for the awarding of a contract, expressed as text.
     */
    private TextType processReason;
    /**
     * The reason why the contracting authority has followed a particular
     * tendering procedure for the awarding of a contract, expressed as a code.
     */
    private CodeType processReasonCode;

}
