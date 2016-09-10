package org.openfact.models.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe a location.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:16:00 a. m.
 */
public class LocationModel {

    /**
     * Free-form text describing the physical conditions of the location.
     */
    private TextType conditions;
    /**
     * A territorial division of a country, such as a county or state, expressed
     * as text.
     */
    private TextType countrySubentity;
    /**
     * A territorial division of a country, such as a county or state, expressed
     * as a code.
     */
    private CodeType countrySubentityCode;
    /**
     * Text describing this location.
     */
    private TextType description;
    /**
     * An identifier for this location, e.g., the EAN LocationModel Number, GLN.
     */
    private IdentifierType ID;
    /**
     * The Uniform Resource Identifier (URI) of a document providing information
     * about this location.
     */
    private IdentifierType informationURIID;
    /**
     * A code signifying the type of location.
     */
    private CodeType locationTypeCode;
    /**
     * The name of this location.
     */
    private NameType name;
    private List<AddressModel> addresses = new ArrayList<>();
    private PeriodModel validityPeriod;
    private List<LocationCoordinateModel> locationCoordinates = new ArrayList<>();
    private LocationModel subsidiaryLocation;

}
