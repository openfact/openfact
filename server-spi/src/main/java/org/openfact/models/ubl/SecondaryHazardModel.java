package org.openfact.models.ubl;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe a secondary hazard associated with a hazardous item.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:17:38 a. m.
 */
public class SecondaryHazardModel {

    /**
     * A code signifying the emergency procedures for this secondary hazard.
     */
    private CodeModel emergencyProceduresCode;
    /**
     * Additional information about the hazardous substance, which can be used
     * (for example) to specify the type of regulatory requirements that apply
     * to this secondary hazard.
     */
    private TextModel extension;
    /**
     * An identifier for this secondary hazard.
     */
    private IdentifierModel ID;
    /**
     * Text of the placard endorsement for this secondary hazard that is to be
     * shown on the shipping papers for a hazardous item. Can also be used for
     * the number of the orange placard (lower part) required on the means of
     * transport.
     */
    private TextModel placardEndorsement;
    /**
     * Text of the placard notation corresponding to the hazard class of this
     * secondary hazard. Can also be the hazard identification number of the
     * orange placard (upper part) required on the means of transport.
     */
    private TextModel placardNotation;

}
