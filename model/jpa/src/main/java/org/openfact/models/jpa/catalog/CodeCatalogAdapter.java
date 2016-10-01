package org.openfact.models.jpa.catalog;

import java.util.Map;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.catalog.CodeCatalogModel;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.catalog.CodeCatalogEntity;;

public class CodeCatalogAdapter implements CodeCatalogModel, JpaModel<CodeCatalogEntity> {

    protected static final Logger logger = Logger.getLogger(CodeCatalogAdapter.class);
    protected CodeCatalogEntity additionalAccountIdCatalog;
    protected EntityManager em;
    protected OpenfactSession session;

    public CodeCatalogAdapter(CodeCatalogEntity additionalAccountIdCatalog, EntityManager em,
            OpenfactSession session) {
        this.additionalAccountIdCatalog = additionalAccountIdCatalog;
        this.em = em;
        this.session = session;
    }

    @Override
    public CodeCatalogEntity getEntity() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getId() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getType() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setType(String type) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getCode() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setCode(String code) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setDescription(String description) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getLocale() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setLocale(String locale) {
        // TODO Auto-generated method stub

    }

    @Override
    public Map<String, String> getAttributes() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setAttributes(Map<String, String> attributes) {
        // TODO Auto-generated method stub

    }

}
