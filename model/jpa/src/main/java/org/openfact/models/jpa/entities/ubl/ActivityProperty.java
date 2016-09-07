package org.openfact.models.jpa.entities.ubl;

/**
 * A class to define a name/value pair for a property of an inventory planning
 * activity.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:12:36 a. m.
 */
public class ActivityProperty {

    /**
     * The name of this activity property.
     */
    private String name;

    /**
     * The value of this activity property.
     */
    private String value;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value
     *            the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

}