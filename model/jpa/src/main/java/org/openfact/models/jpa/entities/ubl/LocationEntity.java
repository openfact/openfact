package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.NameType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class to describe a location.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:16:00 a. m.
 */
public class LocationEntity {

    /**
     * Free-form text describing the physical conditions of the location.
     */
    private TextType Conditions;
    /**
     * A territorial division of a country, such as a county or state, expressed
     * as text.
     */
    private TextType CountrySubentity;
    /**
     * A territorial division of a country, such as a county or state, expressed
     * as a code.
     */
    private CodeType CountrySubentityCode;
    /**
     * Text describing this location.
     */
    private TextType Description;
    /**
     * An identifier for this location, e.g., the EAN LocationEntity Number,
     * GLN.
     */
    private IdentifierType ID;
    /**
     * The Uniform Resource Identifier (URI) of a document providing information
     * about this location.
     */
    private IdentifierType InformationURIID;
    /**
     * A code signifying the type of location.
     */
    private CodeType LocationTypeCode;
    /**
     * The name of this location.
     */
    private NameType Name;
    private List<AddressEntity> Addresses = new ArrayList<>();
    private PeriodEntity ValidityPeriod;
    private List<LocationCoordinateEntity> LocationCoordinates = new ArrayList<>();
    private LocationEntity SubsidiaryLocation;

}
