package org.openfact.services.resources.admin;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.jboss.logging.Logger;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.openfact.common.ClientConnection;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.TaxTypeModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.models.utils.RepresentationToModel;
import org.openfact.representations.idm.TaxTypeRepresentation;
import org.openfact.services.ErrorResponse;

public class TaxTypesAdminResourceImpl implements TaxTypesAdminResource {

	private static final Logger logger = Logger.getLogger(TaxTypesAdminResourceImpl.class);

	protected OrganizationAuth auth;

	protected OrganizationModel organization;

	@Context
	protected UriInfo uriInfo;

	@Context
	protected OpenfactSession session;

	@Context
	protected ClientConnection clientConnection;

	public TaxTypesAdminResourceImpl(OrganizationModel organization, OrganizationAuth auth) {
		this.organization = organization;
		this.auth = auth;
		auth.init(OrganizationAuth.Resource.INVOICE);
	}

	public static final CacheControl noCache = new CacheControl();

	static {
		noCache.setNoCache(true);
	}

    @Override
    public TaxTypeAdminResource getTaxTypeAdmin(String taxTypeId) {
        TaxTypeModel taxType = organization.getTaxTypeById(taxTypeId);
        TaxTypeAdminResource clientResource = new TaxTypeAdminResourceImpl(auth, organization, taxType);
        ResteasyProviderFactory.getInstance().injectProperties(clientResource);
        return clientResource;
    }

    @Override
    public List<TaxTypeRepresentation> getTaxTypes() {
        auth.requireView();

        List<TaxTypeRepresentation> rep = new ArrayList<>();
        List<TaxTypeModel> taxTypes = organization.getTaxTypes();

        boolean view = auth.hasView();
        for (TaxTypeModel taxType : taxTypes) {
            if (view) {
                rep.add(ModelToRepresentation.toRepresentation(taxType));
            } else {
                TaxTypeRepresentation client = new TaxTypeRepresentation();
                client.setId(taxType.getId());
                client.setName(taxType.getName());
                client.setValue(taxType.getValue());
                rep.add(client);
            }
        }
        return rep;
    }

    @Override
    public Response createTaxType(TaxTypeRepresentation rep) {
        auth.requireManage();

        try {
            TaxTypeModel clientModel = RepresentationToModel.createTaxType(session, organization, rep);

            return Response.created(uriInfo.getAbsolutePathBuilder().path(clientModel.getId()).build()).build();
        } catch (ModelDuplicateException e) {
            return ErrorResponse.exists("Client Template " + rep.getName() + " already exists");
        }
    }

	

}
