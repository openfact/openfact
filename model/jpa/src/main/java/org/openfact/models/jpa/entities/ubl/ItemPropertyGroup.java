package org.openfact.models.jpa.entities.ubl;

/**
 * A class to describe a property group or classification.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:51 a. m.
 */
public class ItemPropertyGroup {

    /**
     * An identifier for this group of item properties.
     */
    private String ID;
    /**
     * A code signifying the importance of this property group in using it to
     * describe a required Item.
     */
    private String importanceCode;
    /**
     * The name of this item property group.
     */
    private String name;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getImportanceCode() {
        return importanceCode;
    }

    public void setImportanceCode(String importanceCode) {
        this.importanceCode = importanceCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}// end Item Property Group