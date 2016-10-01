package org.openfact.services.resources.admin;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.jboss.logging.Logger;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.openfact.common.ClientConnection;
import org.openfact.models.AdminRoles;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.representatios.idm.catalog.CodeCatalogRepresentation;
import org.openfact.services.ErrorResponse;
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

    public static final CacheControl noCache = new CacheControl();

    static {
        noCache.setNoCache(true);
    }

    @Override
    public CodeCatalogAdminResource getDocumentAdmin(String codeCatalogId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Response createCodeCatalog(CodeCatalogRepresentation rep) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CodeCatalogRepresentation> getCodesCatalog(String locale, String type, String code,
            String description) {
        // TODO Auto-generated method stub
        return null;
    }

     

}
