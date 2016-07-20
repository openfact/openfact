package org.openfact.models.enums;

/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 14/07/2016.
 */
public enum FileExtensionType {
    ZIP(".zip"), GZ(".gz"), RAR(".rar"), XML(".xml");

    private final String value;

    FileExtensionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
