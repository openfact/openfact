package org.openfact.models.jpa.ubl.common;

import java.util.List;

public class UBLExtensionsAdapter implements UBLExtensionsModel, JpaModel<UBLExtensionsEntity> {

    protected static final Logger logger = Logger.getLogger(UBLExtensionsAdapter.class);
    protected UBLExtensionsEntity uBLExtensions;
    protected EntityManager em;
    protected OpenfactSession session;

    public UBLExtensionsAdapter(OpenfactSession session, EntityManager em,
            UBLExtensionsEntity uBLExtensions) {
        this.session = session;
        this.em = em;
        this.uBLExtensions = uBLExtensions;
    }

    List<UBLExtensionAdapter> getUBLExtension() {
        return this.uBLExtensions.getUBLExtension();
    }

    void setUBLExtension(List<UBLExtensionAdapter> ublExtension) {
        this.uBLExtensions.setUBLExtension(ublExtension);
    }

    String getId() {
        return this.uBLExtensions.getId();
    }

    void setId(String value) {
        this.uBLExtensions.setId(value);
    }

}
