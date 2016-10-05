package org.openfact.services.resources.admin;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.jboss.logging.Logger;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.openfact.common.ClientConnection;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.catalog.CodeCatalogModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.representations.idm.catalog.CodeCatalogRepresentation;
import org.openfact.services.ErrorResponse;
import org.openfact.services.managers.CodeCatalogManager;
import org.openfact.services.managers.OrganizationManager;
import org.openfact.services.resources.OpenfactApplication;

public class CodesCatalogAdminResourceImpl implements CodesCatalogAdminResource {

    private static final Logger logger = Logger.getLogger(CodesCatalogAdminResourceImpl.class);

    protected AdminAuth auth;
    
    @Context
    protected OpenfactSession session;

    @Context
    protected OpenfactApplication openfact;

    @Context
    protected ClientConnection clientConnection;

    public CodesCatalogAdminResourceImpl(AdminAuth auth) {
        this.auth = auth;
    }

    @Override
    public CodeCatalogAdminResource getDocumentAdmin(String codeCatalogId) {
        CodeCatalogManager catalogManager = new CodeCatalogManager(session);
        CodeCatalogModel codeCatalog = catalogManager.getCodeCatalogById(codeCatalogId);
        if (codeCatalog == null) throw new NotFoundException("Code Catalog not found.");

        OrganizationAuth organizationAuth = new OrganizationAuth(auth);
        
        CodeCatalogAdminResource adminResource = new CodeCatalogAdminResourceImpl(organizationAuth, codeCatalog);
        ResteasyProviderFactory.getInstance().injectProperties(adminResource);
        //resourceContext.initResource(adminResource);
        return adminResource;
    }

    @Override
    public Response createCodeCatalog(UriInfo uriInfo, CodeCatalogRepresentation rep) {
        CodeCatalogManager codeCatalogManager = new CodeCatalogManager(session);
        
        logger.debugv("importCodeCatalog: {0}", rep.getDescription());

        try {
            CodeCatalogModel codeCatalog = codeCatalogManager.importCodeCatalog(rep);            

            URI location = AdminRootImpl.organizationsUrl(uriInfo).path(codeCatalog.getId()).build();
            logger.debugv("imported organization success, sending back: {0}", location.toString());

            return Response.created(location).build();
        } catch (ModelDuplicateException e) {
            return ErrorResponse.exists("Organization with same name exists");
        }
    }

    @Override
    public List<CodeCatalogRepresentation> getCodesCatalog(String filterText, String locale, String type, String code, String description, Integer firstResult, Integer maxResults) {
        OrganizationManager organizationManager = new OrganizationManager(session);
        List<CodeCatalogRepresentation> reps = new ArrayList<>();
        

        firstResult = firstResult != null ? firstResult : -1;
        maxResults = maxResults != null ? maxResults : -1;

        List<CodeCatalogModel> codesCatalog;
        if (filterText != null) {
            codesCatalog = session.codesCatalog().searchForCodeCatalog(filterText.trim(), firstResult, maxResults);                        
        } else if (locale != null || type != null || code != null || description != null) {
            Map<String, String> attributes = new HashMap<String, String>();
            if (locale != null) {
                attributes.put(CodeCatalogModel.LOCALE, locale);
            }
            if (type != null) {
                attributes.put(CodeCatalogModel.TYPE, type);
            }
            if (code != null) {
                attributes.put(CodeCatalogModel.CODE, code);
            }
            if (description != null) {
                attributes.put(CodeCatalogModel.DESCRIPTION, description);
            }
            codesCatalog = session.codesCatalog().searchForCodeCatalog(attributes, firstResult, maxResults);
        } else {            
            codesCatalog = session.codesCatalog().getCodeCatalogs(firstResult, maxResults);
        }
               
        if (auth.getOrganization().equals(organizationManager.getOpenfactAdminstrationOrganization())) {
            reps = codesCatalog.stream().map(f -> ModelToRepresentation.toRepresentation(f, true)).collect(Collectors.toList());
        } else {            
            reps = codesCatalog.stream().map(f -> ModelToRepresentation.toRepresentation(f, false)).collect(Collectors.toList());
        }        
        
        logger.debug(("getCodeCatalogs()"));
        return reps;
    }

}
