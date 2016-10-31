package org.openfact.services.resources.admin;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.cache.NoCache;
import org.openfact.common.util.PemUtils;
import org.openfact.keys.KeyMetadata;
import org.openfact.models.KeyManager;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.representations.idm.KeysMetadataRepresentation;

public class KeyResource {

    private OrganizationModel organization;
    private OpenfactSession session;
    private OrganizationAuth auth;

    public KeyResource(OrganizationModel organization, OpenfactSession session, OrganizationAuth auth) {
        this.organization = organization;
        this.session = session;
        this.auth = auth;
    }

    @GET
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public KeysMetadataRepresentation getKeyMetadata() {
        auth.requireView();

        KeyManager keystore = session.keys();

        KeysMetadataRepresentation keys = new KeysMetadataRepresentation();
        keys.setActive(Collections.singletonMap(KeyMetadata.Type.RSA.name(),
                keystore.getActiveKey(organization).getKid()));

        List<KeysMetadataRepresentation.KeyMetadataRepresentation> l = new LinkedList<>();
        for (KeyMetadata m : session.keys().getKeys(organization, true)) {
            KeysMetadataRepresentation.KeyMetadataRepresentation r = new KeysMetadataRepresentation.KeyMetadataRepresentation();
            r.setProviderId(m.getProviderId());
            r.setProviderPriority(m.getProviderPriority());
            r.setKid(m.getKid());
            r.setStatus(m.getStatus() != null ? m.getStatus().name() : null);
            r.setType(m.getType() != null ? m.getType().name() : null);
            r.setPublicKey(PemUtils.encodeKey(m.getPublicKey()));
            r.setCertificate(PemUtils.encodeCertificate(m.getCertificate()));
            l.add(r);
        }

        keys.setKeys(l);

        return keys;
    }

}
