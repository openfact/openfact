package org.openfact.representations.idm.ubl;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.NameRepresentation;

/**
 * A class to describe a language.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:15:54 a. m.
 */
public class LanguageRepresentation {

    /**
     * An identifier for this language.
     */
    private IdentifierRepresentation ID;
    /**
     * A code signifying the locale in which this language is used.
     */
    private CodeRepresentation localeCode;
    /**
     * The name of this language.
     */
    private NameRepresentation name;

}
