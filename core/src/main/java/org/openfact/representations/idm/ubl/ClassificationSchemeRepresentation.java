package org.openfact.representations.idm.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.NameRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to define a classification scheme, such as a taxonomy for classifying
 * goods or services.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:33 a. m.
 */
public class ClassificationSchemeRepresentation {

    /**
     * An identifier for the agency that maintains this classification scheme.
     */
    private IdentifierRepresentation agencyID;
    /**
     * The name of the agency that maintains the classification scheme.
     */
    private TextRepresentation agencyName;
    /**
     * Text describing this classification scheme.
     */
    private TextRepresentation description;
    /**
     * An identifier for this classification scheme.
     */
    private IdentifierRepresentation ID;
    /**
     * An identifier for the language of this classification scheme.
     */
    private IdentifierRepresentation languageID;
    /**
     * The date on which this classification scheme was last revised.
     */
    private LocalDate lastRevisionDate;
    /**
     * The time at which this classification scheme was last revised.
     */
    private LocalTime lastRevisionTime;
    /**
     * The name of this classification scheme.
     */
    private NameRepresentation name;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextRepresentation note;
    /**
     * The Uniform Resource Identifier (URI) of this classification scheme.
     */
    private IdentifierRepresentation schemeURIID;
    /**
     * The Uniform Resource Identifier (URI) of the documentation for this
     * classification scheme.
     */
    private IdentifierRepresentation URIID;
    /**
     * A universally unique identifier for this classification scheme.
     */
    private IdentifierRepresentation UUID;
    /**
     * An identifier for the version of this classification scheme.
     */
    private IdentifierRepresentation versionID;
    private List<ClassificationCategoryRepresentation> classificationCategories = new ArrayList<>();

}
