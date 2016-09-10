package org.openfact.representations.idm.ubl;

import org.openfact.representations.idm.ubl.type.NameType;
import org.openfact.representations.idm.ubl.type.TextType;

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
    private TextType codeValue;
    /**
     * Text describing this category.
     */
    private TextType description;
    /**
     * The name of this category within the classification scheme.
     */
    private NameType name;
    private ClassificationCategoryRepresentation categorizesClassificationCategory;

}
