package org.openfact.representations.idm.ubl.common;

public class UBLExtensionRepresentation {
    private String ID;
    private String name;
    private String extensionAgencyID;
    private String extensionAgencyName;
    private String extensionVersionID;
    private String extensionAgencyURI;
    private String extensionURI;
    private String extensionReasonCode;
    private String extensionReason;
    private ExtensionContentRepresentation extensionContent;
    private String id;

    public String getExtensionAgencyName() {
        return this.extensionAgencyName;
    }

    public void setExtensionAgencyName(String extensionAgencyName) {
        this.extensionAgencyName = extensionAgencyName;
    }

    public String getExtensionURI() {
        return this.extensionURI;
    }

    public void setExtensionURI(String extensionURI) {
        this.extensionURI = extensionURI;
    }

    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExtensionReason() {
        return this.extensionReason;
    }

    public void setExtensionReason(String extensionReason) {
        this.extensionReason = extensionReason;
    }

    public ExtensionContentRepresentation getExtensionContent() {
        return this.extensionContent;
    }

    public void setExtensionContent(ExtensionContentRepresentation extensionContent) {
        this.extensionContent = extensionContent;
    }

    public String getExtensionReasonCode() {
        return this.extensionReasonCode;
    }

    public void setExtensionReasonCode(String extensionReasonCode) {
        this.extensionReasonCode = extensionReasonCode;
    }

    public String getExtensionAgencyURI() {
        return this.extensionAgencyURI;
    }

    public void setExtensionAgencyURI(String extensionAgencyURI) {
        this.extensionAgencyURI = extensionAgencyURI;
    }

    public String getExtensionAgencyID() {
        return this.extensionAgencyID;
    }

    public void setExtensionAgencyID(String extensionAgencyID) {
        this.extensionAgencyID = extensionAgencyID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtensionVersionID() {
        return this.extensionVersionID;
    }

    public void setExtensionVersionID(String extensionVersionID) {
        this.extensionVersionID = extensionVersionID;
    }
}