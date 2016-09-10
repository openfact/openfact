package org.openfact.models.ubl;

import org.openfact.models.ubl.type.*;

/**
 * A class to define a clause (a distinct article or provision) in a contract,
 * treaty, will, or other formal or legal written document requiring compliance.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:35 a. m.
 */
public class ClauseModel {

    /**
     * The text of this clause.
     */
    private TextType content;
    /**
     * An identifier for this clause.
     */
    private IdentifierType ID;

}
