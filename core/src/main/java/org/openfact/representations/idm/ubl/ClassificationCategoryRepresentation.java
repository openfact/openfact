package org.openfact.representations.idm.ubl;

import org.openfact.representations.idm.ubl.type.NameRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to define a category within a classification scheme.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:31 a. m.
 */
public class ClassificationCategoryRepresentation {

    /**
     * The value of a code used to identify this category within the
     * classification scheme.
     */
    private TextRepresentation codeValue;
    /**
     * Text describing this category.
     */
    private TextRepresentation description;
    /**
     * The name of this category within the classification scheme.
     */
    private NameRepresentation name;
    private ClassificationCategoryRepresentation categorizesClassificationCategory;

}
