package org.openfact.services.resources.admin;

import org.jboss.logging.Logger;
import org.openfact.common.ClientConnection;
import org.openfact.models.*;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.models.utils.RepresentationToModel;
import org.openfact.representations.idm.CertifiedRepresentation;
import org.openfact.services.ErrorResponse;
import org.openfact.services.managers.CertifiedManager;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 09/08/2016.
 */
public class CertifiedAdminResourceImpl implements CertifiedAdminResource {
    protected static final Logger logger = Logger.getLogger(CertifiedAdminResourceImpl.class);

    protected OrganizationModel organization;
    protected OrganizationAuth auth;
    protected CertifiedModel certified;

    @Context
    protected OpenfactSession session;

    @Context
    protected UriInfo uriInfo;

    @Context
    protected ClientConnection connection;

    public CertifiedAdminResourceImpl(OrganizationAuth auth, OrganizationModel organization, CertifiedModel certified) {
        this.organization = organization;
        this.auth = auth;
        this.certified = certified;
        auth.init(OrganizationAuth.Resource.CERTIFIED);
        auth.requireAny();
    }

    @Override
    public CertifiedRepresentation getCertified() {
        auth.requireView();
        if (certified == null) {
            throw new NotFoundException("Certified not found");
        }
        return ModelToRepresentation.toRepresentation(certified);
    }

    @Override
    public Response updateCertified(CertifiedRepresentation rep) {
        auth.requireManage();
        if (certified == null) {
            throw new NotFoundException("Certified not found");
        }
        try {
            RepresentationToModel.updateCertified(rep, certified);
            return Response.noContent().build();
        } catch (ModelDuplicateException e) {
            return ErrorResponse.exists("Certified exists with same alias and validity");
        } catch (ModelReadOnlyException e) {
            return ErrorResponse.exists("Certified is read only");
        } catch (ModelException e) {
            return ErrorResponse.exists("Could not update certified");
        }
    }

    @Override
    public Response disabledCertified() {
        auth.requireManage();
        if (certified == null) {
            throw new NotFoundException("Certified notfound");
        }
        boolean disabled = new CertifiedManager(session).disabledCertified(organization, certified);
        if (disabled) {
            return Response.noContent().build();
        } else {
            return ErrorResponse.error("Certified couldn't be disabled", Response.Status.BAD_REQUEST);
        }
    }
}
