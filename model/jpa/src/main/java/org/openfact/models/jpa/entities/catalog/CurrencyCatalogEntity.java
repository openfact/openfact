package org.openfact.models.jpa.entities.catalog;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "CURRENCY_CATALOG")
public class CurrencyCatalogEntity {

    @Id
    @Access(AccessType.PROPERTY)
    @Column(name = "ID", length = 36)
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    protected String id;

    @Column(name = "ENTITY_NAME")
    protected String entityName;

    @Column(name = "CURRENCY")
    protected String currency;

    @Column(name = "ALPHABETIC_CODE")
    protected String alphabetic;

    @Column(name = "NUMERIC_CODE")
    protected String numericCode;

    @Column(name = "MINOR_UNIT")
    protected int minorUnit;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAlphabetic() {
        return alphabetic;
    }

    public void setAlphabetic(String alphabetic) {
        this.alphabetic = alphabetic;
    }

    public String getNumericCode() {
        return numericCode;
    }

    public void setNumericCode(String numericCode) {
        this.numericCode = numericCode;
    }

    public int getMinorUnit() {
        return minorUnit;
    }

    public void setMinorUnit(int minorUnit) {
        this.minorUnit = minorUnit;
    }

}
