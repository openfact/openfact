package org.openfact.models.jpa.ubl.common;

public class UBLExtensionAdapter implements UBLExtensionModel, JpaModel<UBLExtensionEntity> {

    protected static final Logger logger = Logger.getLogger(UBLExtensionAdapter.class);
    protected UBLExtensionEntity uBLExtension;
    protected EntityManager em;
    protected OpenfactSession session;

    public UBLExtensionAdapter(OpenfactSession session, EntityManager em, UBLExtensionEntity uBLExtension) {
        this.session = session;
        this.em = em;
        this.uBLExtension = uBLExtension;
    }

    String getID() {
        return this.uBLExtension.getID();
    }

    void setID(String value) {
        this.uBLExtension.setID(value);
    }

    String getName() {
        return this.uBLExtension.getName();
    }

    void setName(String value) {
        this.uBLExtension.setName(value);
    }

    String getExtensionAgencyID() {
        return this.uBLExtension.getExtensionAgencyID();
    }

    void setExtensionAgencyID(String value) {
        this.uBLExtension.setExtensionAgencyID(value);
    }

    String getExtensionAgencyName() {
        return this.uBLExtension.getExtensionAgencyName();
    }

    void setExtensionAgencyName(String value) {
        this.uBLExtension.setExtensionAgencyName(value);
    }

    String getExtensionVersionID() {
        return this.uBLExtension.getExtensionVersionID();
    }

    void setExtensionVersionID(String value) {
        this.uBLExtension.setExtensionVersionID(value);
    }

    String getExtensionAgencyURI() {
        return this.uBLExtension.getExtensionAgencyURI();
    }

    void setExtensionAgencyURI(String value) {
        this.uBLExtension.setExtensionAgencyURI(value);
    }

    String getExtensionURI() {
        return this.uBLExtension.getExtensionURI();
    }

    void setExtensionURI(String value) {
        this.uBLExtension.setExtensionURI(value);
    }

    String getExtensionReasonCode() {
        return this.uBLExtension.getExtensionReasonCode();
    }

    void setExtensionReasonCode(String value) {
        this.uBLExtension.setExtensionReasonCode(value);
    }

    String getExtensionReason() {
        return this.uBLExtension.getExtensionReason();
    }

    void setExtensionReason(String value) {
        this.uBLExtension.setExtensionReason(value);
    }

    ExtensionContentAdapter getExtensionContent() {
        return this.uBLExtension.getExtensionContent();
    }

    void setExtensionContent(ExtensionContentAdapter value) {
        this.uBLExtension.setExtensionContent(value);
    }

    String getId() {
        return this.uBLExtension.getId();
    }

    void setId(String value) {
        this.uBLExtension.setId(value);
    }

}
