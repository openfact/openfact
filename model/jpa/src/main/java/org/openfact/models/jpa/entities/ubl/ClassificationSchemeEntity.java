package org.openfact.models.jpa.entities.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.IdentifierType;
import org.openfact.models.ubl.type.NameType;
import org.openfact.models.ubl.type.TextType;

/**
 * A class to define a classification scheme, such as a taxonomy for classifying
 * goods or services.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:33 a. m.
 */
public class ClassificationSchemeEntity {

    /**
     * An identifier for the agency that maintains this classification scheme.
     */
    private IdentifierType agencyID;
    /**
     * The name of the agency that maintains the classification scheme.
     */
    private TextType agencyName;
    /**
     * Text describing this classification scheme.
     */
    private TextType description;
    /**
     * An identifier for this classification scheme.
     */
    private IdentifierType ID;
    /**
     * An identifier for the language of this classification scheme.
     */
    private IdentifierType languageID;
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
    private NameType name;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextType note;
    /**
     * The Uniform Resource Identifier (URI) of this classification scheme.
     */
    private IdentifierType schemeURIID;
    /**
     * The Uniform Resource Identifier (URI) of the documentation for this
     * classification scheme.
     */
    private IdentifierType URIID;
    /**
     * A universally unique identifier for this classification scheme.
     */
    private IdentifierType UUID;
    /**
     * An identifier for the version of this classification scheme.
     */
    private IdentifierType versionID;
    private List<ClassificationCategoryEntity> classificationCategories = new ArrayList<>();

}
