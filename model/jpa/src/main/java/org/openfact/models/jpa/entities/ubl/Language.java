package org.openfact.models.jpa.entities.ubl;

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
    private String ID;
    /**
     * A code signifying the locale in which this language is used.
     */
    private String LocaleCode;
    /**
     * The name of this language.
     */
    private String Name;

    public Language() {

    }

    public void finalize() throws Throwable {

    }

    public String getID() {
        return ID;
    }

    public String getLocaleCode() {
        return LocaleCode;
    }

    public String getName() {
        return Name;
    }

    /**
     * 
     * @param newVal
     */
    public void setID(String newVal) {
        ID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setLocaleCode(String newVal) {
        LocaleCode = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setName(String newVal) {
        Name = newVal;
    }
}// end Language