package org.openfact.pe.services;

import org.jboss.logging.Logger;
import org.openfact.core.models.OrganizationModel;
import org.openfact.core.models.OrganizationProvider;
import org.openfact.core.models.PermissionType;
import org.openfact.core.security.ISecurityContext;
import org.openfact.pe.NotasResource;
import org.openfact.pe.managers.TypeManager;
import org.openfact.pe.models.NotaModel;
import org.openfact.pe.models.NotaProvider;
import org.openfact.pe.models.utils.ModelToRepresentation;
import org.openfact.pe.representations.idm.NotaRepresentation;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

@Transactional
@ApplicationScoped
public class DefaultNotasResource implements NotasResource {

    private static final Logger logger = Logger.getLogger(DefaultNotasResource.class);

    @Inject
    private ISecurityContext securityContext;

    @Inject
    private TypeManager typeManager;

    @Inject
    private NotaProvider notaProvider;

    @Inject
    private ResourceManager resourceManager;


    @Inject
    private OrganizationProvider organizationProvider;

    @Override
    public List<NotaRepresentation> getNotas(String organizationId, String filterText, int offset, int limit) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.document_view, organizationId)) {
            throw new ForbiddenException();
        }

        OrganizationModel organization = organizationProvider.getOrganization(organizationId).orElseThrow(NotFoundException::new);
        return notaProvider.buscarNota(organization, filterText, offset, limit)
                .stream()
                .map(f -> ModelToRepresentation.toRepresentation(f, true))
                .collect(Collectors.toList());
    }

    @Override
    public NotaRepresentation crearNota(String organizationId, Boolean async, NotaRepresentation rep) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.document_manage, organizationId)) {
            throw new ForbiddenException();
        }

        NotaModel nota = resourceManager.crearNota(organizationId, rep);
        Future<NotaModel> future = typeManager.buildNota(nota.getId());
        if (!async) {
            try {
                nota = future.get();
            } catch (InterruptedException | ExecutionException e) {
                logger.error(e);
            }
        }

        return ModelToRepresentation.toRepresentation(nota, true);
    }

    @Override
    public NotaRepresentation getNota(String organizationId, String idDocumento) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.document_view, organizationId)) {
            throw new ForbiddenException();
        }

        OrganizationModel organization = organizationProvider.getOrganization(organizationId).orElseThrow(NotFoundException::new);
        NotaModel nota = notaProvider.getNota(organization, idDocumento).orElseThrow(NotFoundException::new);
        return ModelToRepresentation.toRepresentation(nota, true);
    }

    @Override
    public NotaRepresentation actualizarNota(String organizationId, String idDocumento, Boolean async, NotaRepresentation rep) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.document_manage, organizationId)) {
            throw new ForbiddenException();
        }

        NotaModel nota = resourceManager.actualizarNota(organizationId, idDocumento, rep);
        Future<NotaModel> future = typeManager.buildNota(nota.getId());
        if (!async) {
            try {
                nota = future.get();
            } catch (InterruptedException | ExecutionException e) {
                logger.error(e);
            }
        }

        return ModelToRepresentation.toRepresentation(nota, true);
    }

    @Override
    public void eliminarNota(String organizacionId, String idDocumento) {
        throw new ForbiddenException();
    }
}
