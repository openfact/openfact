package org.openfact.theme;

public class ThemeKey {

    private String name;
    private Theme.Type type;

    public static ThemeKey get(String name, Theme.Type type) {
        return new ThemeKey(name, type);
    }

    private ThemeKey(String name, Theme.Type type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Theme.Type getType() {
        return type;
    }

    public void setType(Theme.Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ThemeKey themeKey = (ThemeKey) o;

        if (name != null ? !name.equals(themeKey.name) : themeKey.name != null) return false;
        if (type != themeKey.type) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

}
