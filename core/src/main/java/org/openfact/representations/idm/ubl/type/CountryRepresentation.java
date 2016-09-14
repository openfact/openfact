package org.openfact.representations.idm.ubl.type;

/**
 * A class to describe a country.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:11 a. m.
 */
public class CountryRepresentation {

    /**
     * A code signifying this country.
     */
    private String identificationCode;

    /**
     * The name of this country.
     */
    private String name;

    /**
     * @return the identificationCode
     */
    public String getIdentificationCode() {
        return identificationCode;
    }

    /**
     * @param identificationCode
     *            the identificationCode to set
     */
    public void setIdentificationCode(String identificationCode) {
        this.identificationCode = identificationCode;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}
