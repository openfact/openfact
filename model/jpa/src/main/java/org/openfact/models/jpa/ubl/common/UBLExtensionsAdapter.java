package org.openfact.models.jpa.ubl.common;

import java.util.List;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.ubl.common.UBLExtensionModel;
import org.openfact.models.ubl.common.UBLExtensionsModel;

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

    @Override
    public List<UBLExtensionModel> getUBLExtension() {
        return this.uBLExtensions.getUBLExtension();
    }

    @Override
    public void setUBLExtension(List<UBLExtensionAdapter> ublExtension) {
        this.uBLExtensions.setUBLExtension(ublExtension);
    }

    @Override
    public String getId() {
        return this.uBLExtensions.getId();
    }

    @Override
    public void setId(String value) {
        this.uBLExtensions.setId(value);
    }

}
