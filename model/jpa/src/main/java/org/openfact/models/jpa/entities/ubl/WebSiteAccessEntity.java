package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class to describe access to a web site.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:57 a. m.
 */
public class WebSiteAccessEntity {

    /**
     * Text describing login details.
     */
    private TextType login;
    /**
     * A password to the web site.
     */
    private TextType password;
    /**
     * The Uniform Resource Identifier (URI) for this web site; i.e., its
     * Uniform Resource Locator (URL).
     */
    private IdentifierType URIID;

}
