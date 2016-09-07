package org.openfact.models.jpa.entities.ubl;

import org.apache.bcel.classfile.Code;

/**
 * A class to describe a language.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:15:54 a. m.
 */
public class Language {

    /**
     * An identifier for this language.
     */
    private Identifier.Type ID;
    /**
     * A code signifying the locale in which this language is used.
     */
    private Code.Type LocaleCode;
    /**
     * The name of this language.
     */
    private Name.Type Name;

    public Language() {

    }

    public void finalize() throws Throwable {

    }

    public Identifier.Type getID() {
        return ID;
    }

    public Code.Type getLocaleCode() {
        return LocaleCode;
    }

    public Name.Type getName() {
        return Name;
    }

    /**
     * 
     * @param newVal
     */
    public void setID(Identifier.Type newVal) {
        ID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setLocaleCode(Code.Type newVal) {
        LocaleCode = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setName(Name.Type newVal) {
        Name = newVal;
    }
}// end Language