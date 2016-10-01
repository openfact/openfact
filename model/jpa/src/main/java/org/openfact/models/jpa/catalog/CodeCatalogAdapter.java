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
    protected CodeCatalogEntity codeCatalog;
    protected EntityManager em;
    protected OpenfactSession session;

    public CodeCatalogAdapter(OpenfactSession session, EntityManager em, CodeCatalogEntity codeCatalog) {
        this.codeCatalog = codeCatalog;
        this.em = em;
        this.session = session;
    }

    @Override
    public CodeCatalogEntity getEntity() {
        return codeCatalog;
    }

    @Override
    public String getId() {
        return codeCatalog.getId();
    }

    @Override
    public String getType() {
        return codeCatalog.getType();
    }

    @Override
    public void setType(String type) {
        codeCatalog.setType(type);
    }

    @Override
    public String getCode() {
        return codeCatalog.getCode();
    }

    @Override
    public void setCode(String code) {
        codeCatalog.setCode(code);
    }

    @Override
    public String getDescription() {
        return codeCatalog.getDescription();
    }

    @Override
    public void setDescription(String description) {
        codeCatalog.setDescription(description);
    }

    @Override
    public String getLocale() {
        return codeCatalog.getLocale();
    }

    @Override
    public void setLocale(String locale) {
        codeCatalog.setLocale(locale);
    }

    @Override
    public Map<String, String> getAttributes() {
        return codeCatalog.getAttributes();
    }

    @Override
    public void setAttributes(Map<String, String> attributes) {
        codeCatalog.setAttributes(attributes);
    }

}
