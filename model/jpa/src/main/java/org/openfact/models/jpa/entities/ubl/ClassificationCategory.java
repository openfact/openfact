package org.openfact.models.jpa.entities.ubl;

/**
 * A class to define a category within a classification scheme.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:31 a. m.
 */
public class ClassificationCategory {

    /**
     * The value of a code used to identify this category within the
     * classification scheme.
     */
    private String CodeValue;
    /**
     * Text describing this category.
     */
    private String Description;
    /**
     * The name of this category within the classification scheme.
     */
    private String Name;
    private ClassificationCategory CategorizesClassificationCategory;

    public ClassificationCategory() {

    }

    public void finalize() throws Throwable {

    }

    public String getCodeValue() {
        return CodeValue;
    }

    public String getDescription() {
        return Description;
    }

    public String getName() {
        return Name;
    }

    /**
     * @return the categorizesClassificationCategory
     */
    public ClassificationCategory getCategorizesClassificationCategory() {
        return CategorizesClassificationCategory;
    }

    /**
     * 
     * @param newVal
     */
    public void setCategorizesClassificationCategory(ClassificationCategory newVal) {
        CategorizesClassificationCategory = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setCodeValue(String newVal) {
        CodeValue = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setDescription(String newVal) {
        Description = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setName(String newVal) {
        Name = newVal;
    }
}// end Classification Category