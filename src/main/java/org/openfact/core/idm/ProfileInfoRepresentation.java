package org.openfact.core.idm;

public class ProfileInfoRepresentation {

    private String name;
    private boolean previewEnabled;

    public static ProfileInfoRepresentation create() {
        ProfileInfoRepresentation info = new ProfileInfoRepresentation();
        info.setName("Openfact Name");
        info.setPreviewEnabled(false);
        return info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPreviewEnabled() {
        return previewEnabled;
    }

    public void setPreviewEnabled(boolean previewEnabled) {
        this.previewEnabled = previewEnabled;
    }

}

