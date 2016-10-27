/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates
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
 */

package org.openfact.keys;

import org.jboss.logging.Logger;
import org.openfact.Config;
import org.openfact.common.util.CertificateUtils;
import org.openfact.common.util.KeyUtils;
import org.openfact.common.util.PemUtils;
import org.openfact.component.ComponentModel;
import org.openfact.component.ComponentValidationException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.models.OrganizationModel;
import org.openfact.provider.ConfigurationValidationHelper;
import org.openfact.provider.ProviderConfigProperty;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.interfaces.RSAPrivateKey;
import java.util.List;

/**
 * @author <a href="mailto:sthorger@redhat.com">Stian Thorgersen</a>
 */
public class GeneratedRsaKeyProviderFactory extends AbstractRsaKeyProviderFactory {

    private static final Logger logger = Logger.getLogger(GeneratedRsaKeyProviderFactory.class);

    public static final String ID = "rsa-generated";

    private static final String HELP_TEXT = "Generates RSA keys and creates a self-signed certificate";

    private static final List<ProviderConfigProperty> CONFIG_PROPERTIES = AbstractRsaKeyProviderFactory.configurationBuilder()
            .property(Attributes.KEY_SIZE_PROPERTY)
            .build();

    @Override
    public KeyProvider create(OpenfactSession session, ComponentModel model) {
        return new RsaKeyProvider(session.getContext().getOrganization(), model);
    }

    @Override
    public void validateConfiguration(OpenfactSession session, ComponentModel model) throws ComponentValidationException {
        super.validateConfiguration(session, model);

        ConfigurationValidationHelper.check(model)
                .checkInt(Attributes.KEY_SIZE_PROPERTY, false);

        int size;
        if (!model.contains(Attributes.KEY_SIZE_KEY)) {
            size = 2048;
            model.put(Attributes.KEY_SIZE_KEY, size);
        } else {
            size = model.get(Attributes.KEY_SIZE_KEY, 2048);
            if (size != 1024 && size != 2048 && size != 4096) {
                throw new ComponentValidationException("Keysize should be 1024, 2048 or 4096");
            }
        }

        if (!(model.contains(Attributes.PRIVATE_KEY_KEY) && model.contains(Attributes.CERTIFICATE_KEY))) {
            OrganizationModel organiaztion = session.organizations().getOrganization(model.getParentId());
            generateKeys(organiaztion, model, size);

            logger.debugv("Generated keys for {0}", organiaztion.getName());
        } else {
            PrivateKey privateKey = PemUtils.decodePrivateKey(model.get(Attributes.PRIVATE_KEY_KEY));
            int currentSize = ((RSAPrivateKey) privateKey).getModulus().bitLength();
            if (currentSize != size) {
                OrganizationModel organiaztion = session.organizations().getOrganization(model.getParentId());
                generateKeys(organiaztion, model, size);

                logger.debugv("Key size changed, generating new keys for {0}", organiaztion.getName());
            }
        }
    }

    private void generateKeys(OrganizationModel organiaztion, ComponentModel model, int size) {
        KeyPair keyPair;
        try {
            keyPair = KeyUtils.generateRsaKeyPair(size);
            model.put(Attributes.PRIVATE_KEY_KEY, PemUtils.encodeKey(keyPair.getPrivate()));
        } catch (Throwable t) {
            throw new ComponentValidationException("Failed to generate keys", t);
        }

        generateCertificate(organiaztion, model, keyPair);
    }

    private void generateCertificate(OrganizationModel organiaztion, ComponentModel model, KeyPair keyPair) {
        try {
            Certificate certificate = CertificateUtils.generateV1SelfSignedCertificate(keyPair, organiaztion.getName());
            model.put(Attributes.CERTIFICATE_KEY, PemUtils.encodeCertificate(certificate));
        } catch (Throwable t) {
            throw new ComponentValidationException("Failed to generate certificate", t);
        }
    }

    @Override
    public String getHelpText() {
        return HELP_TEXT;
    }

    @Override
    public List<ProviderConfigProperty> getConfigProperties() {
        return CONFIG_PROPERTIES;
    }

    @Override
    public void init(Config.Scope config) {
    }

    @Override
    public void postInit(OpenfactSessionFactory factory) {
    }

    @Override
    public void close() {
    }

    @Override
    public String getId() {
        return ID;
    }

}
