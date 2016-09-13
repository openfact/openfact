package org.openfact.representations.idm.ubl;

import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to describe access to a web site.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:57 a. m.
 */
public class WebSiteAccessRepresentation {

    /**
     * Text describing login details.
     */
    private TextRepresentation login;
    /**
     * A password to the web site.
     */
    private TextRepresentation password;
    /**
     * The Uniform Resource Identifier (URI) for this web site; i.e., its
     * Uniform Resource Locator (URL).
     */
    private IdentifierRepresentation URIID;

}
