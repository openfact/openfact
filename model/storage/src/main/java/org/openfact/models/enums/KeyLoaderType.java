package org.openfact.models.enums;

/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 14/07/2016.
 */
public enum KeyLoaderType {
    PRIVATE_KEY_LOADER("public.key"),
    PUBLIC_KEY_LOADER("private.key");

    private final String keyloader;

    private KeyLoaderType(String keyloader) {
        this.keyloader = keyloader;
    }

    public String getKeyLoader() {
        return this.keyloader;
    }
}
