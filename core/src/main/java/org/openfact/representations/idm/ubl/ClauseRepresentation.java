package org.openfact.representations.idm.ubl;

import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to define a clause (a distinct article or provision) in a contract,
 * treaty, will, or other formal or legal written document requiring compliance.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:35 a. m.
 */
public class ClauseRepresentation {

    /**
     * The text of this clause.
     */
    private TextRepresentation content;
    /**
     * An identifier for this clause.
     */
    private IdentifierRepresentation ID;

}
