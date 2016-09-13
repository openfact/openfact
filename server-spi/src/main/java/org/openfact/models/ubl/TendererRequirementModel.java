package org.openfact.models.ubl;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe an action or statement required of an economic operator
 * participating in a tendering process.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:26 a. m.
 */
public class TendererRequirementModel {

    /**
     * Text describing this requirement.
     */
    private TextModel description;
    /**
     * The legal reference of the exclusion criterion.
     */
    private TextModel legalReference;
    /**
     * A name of this tenderer requirement.
     */
    private NameModel name;
    /**
     * A code signifying this requirement.
     */
    private CodeModel tendererRequirementTypeCode;
    private EvidenceModel suggestedEvidence;

}
