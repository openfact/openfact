package org.openfact.representations.idm.ubl;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.NameRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to describe an action or statement required of an economic operator
 * participating in a tendering process.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:26 a. m.
 */
public class TendererRequirementRepresentation {

    /**
     * Text describing this requirement.
     */
    private TextRepresentation description;
    /**
     * The legal reference of the exclusion criterion.
     */
    private TextRepresentation legalReference;
    /**
     * A name of this tenderer requirement.
     */
    private NameRepresentation name;
    /**
     * A code signifying this requirement.
     */
    private CodeRepresentation tendererRequirementTypeCode;
    private EvidenceRepresentation suggestedEvidence;

}
