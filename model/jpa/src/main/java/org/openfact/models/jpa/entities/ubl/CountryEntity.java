package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.ubl.type.CountryIdentificationCodeType;
import org.openfact.models.ubl.type.NameType;

/**
 * A class to describe a country.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:11 a. m.
 */
public class CountryEntity {

    /**
     * A code signifying this country.
     */
    private CountryIdentificationCodeType identificationCode;
    /**
     * The name of this country.
     */
    private NameType name;

}
