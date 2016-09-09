package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.nameType;

/**
 * A class to describe a language.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:15:54 a. m.
 */
public class LanguageEntity {

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
    private nameType name;

}
