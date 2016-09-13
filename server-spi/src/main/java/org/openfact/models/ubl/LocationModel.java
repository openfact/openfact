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
    private TextModel conditions;
    /**
     * A territorial division of a country, such as a county or state, expressed
     * as text.
     */
    private TextModel countrySubentity;
    /**
     * A territorial division of a country, such as a county or state, expressed
     * as a code.
     */
    private CodeModel countrySubentityCode;
    /**
     * Text describing this location.
     */
    private TextModel description;
    /**
     * An identifier for this location, e.g., the EAN LocationModel Number, GLN.
     */
    private IdentifierModel ID;
    /**
     * The Uniform Resource Identifier (URI) of a document providing information
     * about this location.
     */
    private IdentifierModel informationURIID;
    /**
     * A code signifying the type of location.
     */
    private CodeModel locationTypeCode;
    /**
     * The name of this location.
     */
    private NameModel name;
    private List<AddressModel> addresses = new ArrayList<>();
    private PeriodModel validityPeriod;
    private List<LocationCoordinateModel> locationCoordinates = new ArrayList<>();
    private LocationModel subsidiaryLocation;

}
