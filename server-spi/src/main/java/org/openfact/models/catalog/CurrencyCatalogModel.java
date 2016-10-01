package org.openfact.models.catalog;

public interface CurrencyCatalogModel {

    public String getId();

    public void setId(String id);

    public String getEntityName();

    public void setEntityName(String entity);

    public String getCurrency();

    public void setCurrency(String currency);

    public String getAlphabeticCode();

    public void setAlphabeticCode(String alphabeticCode);

    public String getNumericCode();

    public void setNumericCode(String numericCode);

    public int getMinorUnit();

    public void setMinorUnit(int minorUnit);

}
