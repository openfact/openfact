package org.openfact.models.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to define a classification scheme, such as a taxonomy for classifying
 * goods or services.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:33 a. m.
 */
public class ClassificationSchemeModel {

    /**
     * An identifier for the agency that maintains this classification scheme.
     */
    private IdentifierModel agencyID;
    /**
     * The name of the agency that maintains the classification scheme.
     */
    private TextModel agencyName;
    /**
     * Text describing this classification scheme.
     */
    private TextModel description;
    /**
     * An identifier for this classification scheme.
     */
    private IdentifierModel ID;
    /**
     * An identifier for the language of this classification scheme.
     */
    private IdentifierModel languageID;
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
    private NameModel name;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextModel note;
    /**
     * The Uniform Resource Identifier (URI) of this classification scheme.
     */
    private IdentifierModel schemeURIID;
    /**
     * The Uniform Resource Identifier (URI) of the documentation for this
     * classification scheme.
     */
    private IdentifierModel URIID;
    /**
     * A universally unique identifier for this classification scheme.
     */
    private IdentifierModel UUID;
    /**
     * An identifier for the version of this classification scheme.
     */
    private IdentifierModel versionID;
    private List<ClassificationCategoryModel> classificationCategories = new ArrayList<>();

}
