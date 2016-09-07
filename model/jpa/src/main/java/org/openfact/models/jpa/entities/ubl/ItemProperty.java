package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;

/**
 * A class to describe a specific property of an item.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:50 a. m.
 */
public class ItemProperty {

    /**
     * An identifier for this property of an item.
     */
    private String ID;
    /**
     * A code signifying the importance of this property in using it to describe
     * a related Item.
     */
    private String importanceCode;
    /**
     * The value expressed as a text in case the property is a value in a list.
     * For example, a colour.
     */
    private String listValue;
    /**
     * The name of this item property.
     */
    private String name;
    /**
     * The name of this item property, expressed as a code.
     */
    private String nameCode;
    /**
     * The method of testing the value of this item property.
     */
    private String testMethod;
    /**
     * The value of this item property, expressed as text.
     */
    private String value;
    /**
     * Text qualifying the value of the property.
     */
    private String valueQualifier;
    /**
     * The value of this item property, expressed as a quantity.
     */
    private BigDecimal valueQuantity;
    private Dimension rangeDimension;
    private ItemPropertyGroup m_ItemPropertyGroup;
    private ItemPropertyRange m_ItemPropertyRange;
    private Period usabilityPeriod;

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

    public String getListValue() {
        return listValue;
    }

    public void setListValue(String listValue) {
        this.listValue = listValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameCode() {
        return nameCode;
    }

    public void setNameCode(String nameCode) {
        this.nameCode = nameCode;
    }

    public String getTestMethod() {
        return testMethod;
    }

    public void setTestMethod(String testMethod) {
        this.testMethod = testMethod;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValueQualifier() {
        return valueQualifier;
    }

    public void setValueQualifier(String valueQualifier) {
        this.valueQualifier = valueQualifier;
    }

    public BigDecimal getValueQuantity() {
        return valueQuantity;
    }

    public void setValueQuantity(BigDecimal valueQuantity) {
        this.valueQuantity = valueQuantity;
    }

    public Dimension getRangeDimension() {
        return rangeDimension;
    }

    public void setRangeDimension(Dimension rangeDimension) {
        this.rangeDimension = rangeDimension;
    }

    public ItemPropertyGroup getM_ItemPropertyGroup() {
        return m_ItemPropertyGroup;
    }

    public void setM_ItemPropertyGroup(ItemPropertyGroup m_ItemPropertyGroup) {
        this.m_ItemPropertyGroup = m_ItemPropertyGroup;
    }

    public ItemPropertyRange getM_ItemPropertyRange() {
        return m_ItemPropertyRange;
    }

    public void setM_ItemPropertyRange(ItemPropertyRange m_ItemPropertyRange) {
        this.m_ItemPropertyRange = m_ItemPropertyRange;
    }

    public Period getUsabilityPeriod() {
        return usabilityPeriod;
    }

    public void setUsabilityPeriod(Period usabilityPeriod) {
        this.usabilityPeriod = usabilityPeriod;
    }
}// end Item Property