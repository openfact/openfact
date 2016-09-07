package org.openfact.models.jpa.entities.ubl2;

/**
 * A class to describe a country.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:11 a. m.
 */
public class Country {

    /**
	 * A code signifying this country.
	 */
	private Country Identification_
    Code.Type IdentificationCode;
    /**
     * The name of this country.
     */
    private Name.Type Name;

    public Country() {

    }

    public void finalize() throws Throwable {

    }

    public Country Identification_

    Code.Type getIdentificationCode() {
        return IdentificationCode;
    }

    public Name.Type getName() {
        return Name;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setIdentificationCode(Country Identification_ Code. Type newVal){
		IdentificationCode = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setName(Name.Type newVal) {
        Name = newVal;
    }
}// end Country