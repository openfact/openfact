package org.openfact.services.resources.admin;

import org.openfact.jose.jws.AlgorithmType;
import org.openfact.keys.RsaKeyMetadata;
import org.openfact.models.KeyManager;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.representations.idm.KeysMetadataRepresentation;
import org.openfact.services.managers.OrganizationManager;
import org.openfact.services.resource.security.OrganizationAuth;
import org.openfact.services.resource.security.SecurityContextProvider;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Stateless
@Path("/admin/organizations/{organization}/keys")
public class KeyResource {

    @Context
    private OpenfactSession session;

    @Inject
    private SecurityContextProvider securityContext;

    @Inject
    private OrganizationManager organizationManager;

    @Inject
    private KeyManager keystore;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public KeysMetadataRepresentation getKeyMetadata(@PathParam("organization") String organizationName) {
        OrganizationModel organization = AdminUtil.initOrganization(organizationName, organizationManager);
        OrganizationAuth auth = AdminUtil.initAuth(session, securityContext, organizationManager, organization);

        auth.requireView();

        KeysMetadataRepresentation keys = new KeysMetadataRepresentation();

        Map<String, String> active = new HashMap<>();
        active.put(AlgorithmType.RSA.name(), keystore.getActiveRsaKey(organization).getKid());
        keys.setActive(active);

        List<KeysMetadataRepresentation.KeyMetadataRepresentation> l = new LinkedList<>();
        for (RsaKeyMetadata m : keystore.getRsaKeys(organization, true)) {
            KeysMetadataRepresentation.KeyMetadataRepresentation r = new KeysMetadataRepresentation.KeyMetadataRepresentation();
            r.setProviderId(m.getProviderId());
            r.setProviderPriority(m.getProviderPriority());
            r.setKid(m.getKid());
            r.setStatus(m.getStatus() != null ? m.getStatus().name() : null);
            r.setType(AlgorithmType.RSA.name());
            r.setPublicKey(org.keycloak.common.util.PemUtils.encodeKey(m.getPublicKey()));
            r.setCertificate(org.keycloak.common.util.PemUtils.encodeCertificate(m.getCertificate()));
            l.add(r);
        }

        keys.setKeys(l);

        return keys;
    }

}
