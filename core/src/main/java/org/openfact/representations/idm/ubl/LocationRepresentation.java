package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.NameRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to describe a location.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:16:00 a. m.
 */
public class LocationRepresentation {

    /**
     * Free-form text describing the physical conditions of the location.
     */
    private TextRepresentation conditions;
    /**
     * A territorial division of a country, such as a county or state, expressed
     * as text.
     */
    private TextRepresentation countrySubentity;
    /**
     * A territorial division of a country, such as a county or state, expressed
     * as a code.
     */
    private CodeRepresentation countrySubentityCode;
    /**
     * Text describing this location.
     */
    private TextRepresentation description;
    /**
     * An identifier for this location, e.g., the EAN LocationRepresentation
     * Number, GLN.
     */
    private IdentifierRepresentation ID;
    /**
     * The Uniform Resource Identifier (URI) of a document providing information
     * about this location.
     */
    private IdentifierRepresentation informationURIID;
    /**
     * A code signifying the type of location.
     */
    private CodeRepresentation locationTypeCode;
    /**
     * The name of this location.
     */
    private NameRepresentation name;
    private List<AddressRepresentation> addresses = new ArrayList<>();
    private PeriodRepresentation validityPeriod;
    private List<LocationCoordinateRepresentation> locationCoordinates = new ArrayList<>();
    private LocationRepresentation subsidiaryLocation;

}
