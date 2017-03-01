/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openfact.services.resources.admin;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.cache.NoCache;
import org.openfact.keys.RsaKeyMetadata;
import org.openfact.models.KeyManager;
import org.openfact.models.OrganizationModel;
import org.openfact.representations.idm.KeysMetadataRepresentation;
import org.openfact.services.resources.OpenfactSession;

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
        /*auth.requireView();

        KeyManager keystore = session.keys();

        KeysMetadataRepresentation keys = new KeysMetadataRepresentation();

        Map<String, String> active = new HashMap<>();
        active.put(AlgorithmType.RSA.name(), keystore.getActiveRsaKey(organization).getKid());
        active.put(AlgorithmType.HMAC.name(), keystore.getActiveHmacKey(organization).getKid());
        keys.setActive(active);

        List<KeysMetadataRepresentation.KeyMetadataRepresentation> l = new LinkedList<>();
        for (RsaKeyMetadata m : session.keys().getRsaKeys(organization, true)) {
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
        for (HmacKeyMetadata m : session.keys().getHmacKeys(organization, true)) {
            KeysMetadataRepresentation.KeyMetadataRepresentation r = new KeysMetadataRepresentation.KeyMetadataRepresentation();
            r.setProviderId(m.getProviderId());
            r.setProviderPriority(m.getProviderPriority());
            r.setKid(m.getKid());
            r.setStatus(m.getStatus() != null ? m.getStatus().name() : null);
            r.setType(AlgorithmType.HMAC.name());
            l.add(r);
        }

        keys.setKeys(l);

        return keys;*/
        return null;
    }

}
