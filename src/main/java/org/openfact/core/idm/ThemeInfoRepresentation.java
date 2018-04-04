package org.openfact.core.idm;

public class ThemeInfoRepresentation {

    private String name;
    private String[] locales;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getLocales() {
        return locales;
    }

    public void setLocales(String[] locales) {
        this.locales = locales;
    }
}