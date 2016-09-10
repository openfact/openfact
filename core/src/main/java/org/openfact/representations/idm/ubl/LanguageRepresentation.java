package org.openfact.representations.idm.ubl;

import org.openfact.representations.idm.ubl.type.CodeType;
import org.openfact.representations.idm.ubl.type.IdentifierType;
import org.openfact.representations.idm.ubl.type.NameType;

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
    private IdentifierType ID;
    /**
     * A code signifying the locale in which this language is used.
     */
    private CodeType localeCode;
    /**
     * The name of this language.
     */
    private NameType name;

}
