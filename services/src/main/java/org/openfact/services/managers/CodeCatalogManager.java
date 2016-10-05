package org.openfact.services.managers;

import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.catalog.CodeCatalogModel;
import org.openfact.models.catalog.CodeCatalogProvider;
import org.openfact.models.utils.RepresentationToModel;
import org.openfact.representations.idm.catalog.CodeCatalogRepresentation;

public class CodeCatalogManager {

    protected OpenfactSession session;
    protected CodeCatalogProvider model;
    protected String contextPath = "";

    public CodeCatalogManager(OpenfactSession session) {
        this.session = session;
        this.model = session.codesCatalog();
    }

    public CodeCatalogModel getCodeCatalogById(String id) {
        return model.getCodeCatalogById(id);
    }

    public CodeCatalogModel importCodeCatalog(CodeCatalogRepresentation rep) {
        CodeCatalogModel codeCatalog = model.addCodeCatalog(rep.getLocale(), rep.getType(), rep.getCode(), rep.getDescription());
        codeCatalog.setAttributes(rep.getAttributes());

        RepresentationToModel.importCodeCatalog(session, rep, codeCatalog);
        return codeCatalog;
    }

    public boolean removeCodeCatalog(CodeCatalogModel codeCatalog) {
        if (model.removeCodeCatalog(codeCatalog)) {
            return true;
        }
        return false;
    }

}
