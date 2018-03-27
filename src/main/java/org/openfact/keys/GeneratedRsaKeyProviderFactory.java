package org.openfact.keys;

import org.jboss.logging.Logger;
import org.keycloak.common.util.CertificateUtils;
import org.keycloak.common.util.KeyUtils;
import org.keycloak.common.util.PemUtils;
import org.openfact.keys.component.ComponentModel;
import org.openfact.keys.component.ComponentValidationException;
import org.openfact.keys.provider.ConfigurationValidationHelper;
import org.openfact.keys.provider.ProviderConfigProperty;
import org.openfact.keys.qualifiers.ComponentProviderType;
import org.openfact.keys.qualifiers.RsaKeyProviderType;
import org.openfact.keys.qualifiers.RsaKeyType;
import org.openfact.models.CompanyModel;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.interfaces.RSAPrivateKey;
import java.util.List;

@ApplicationScoped
@ComponentProviderType(providerType = KeyProvider.class)
@RsaKeyProviderType(type = RsaKeyType.GENERATED)
public class GeneratedRsaKeyProviderFactory extends AbstractRsaKeyProviderFactory implements RsaKeyProviderFactory {

    private static final Logger logger = Logger.getLogger(GeneratedRsaKeyProviderFactory.class);

    public static final String ID = "rsa-generated";

    private static final String HELP_TEXT = "Generates RSA keys and creates a self-signed certificate";

    private static final List<ProviderConfigProperty> CONFIG_PROPERTIES = AbstractRsaKeyProviderFactory.configurationBuilder()
            .property(Attributes.KEY_SIZE_PROPERTY)
            .build();

    @Override
    public KeyProvider create(CompanyModel organization, ComponentModel model) {
        return new ImportedRsaKeyProvider(organization, model);
    }

    @Override
    public void validateConfiguration(CompanyModel organization, ComponentModel model) throws ComponentValidationException {
        super.validateConfiguration(organization, model);

        ConfigurationValidationHelper.check(model).checkList(Attributes.KEY_SIZE_PROPERTY, false);

        int size = model.get(Attributes.KEY_SIZE_KEY, 2048);

        if (!(model.contains(Attributes.PRIVATE_KEY_KEY) && model.contains(Attributes.CERTIFICATE_KEY))) {
            generateKeys(organization, model, size);

            logger.debugv("Generated keys for {0}", organization.getName());
        } else {
            PrivateKey privateKey = PemUtils.decodePrivateKey(model.get(Attributes.PRIVATE_KEY_KEY));
            int currentSize = ((RSAPrivateKey) privateKey).getModulus().bitLength();
            if (currentSize != size) {
                generateKeys(organization, model, size);

                logger.debugv("Key size changed, generating new keys for {0}", organization.getName());
            }
        }
    }

    private void generateKeys(CompanyModel organization, ComponentModel model, int size) {
        KeyPair keyPair;
        try {
            keyPair = KeyUtils.generateRsaKeyPair(size);
            model.put(Attributes.PRIVATE_KEY_KEY, PemUtils.encodeKey(keyPair.getPrivate()));
        } catch (Throwable t) {
            throw new ComponentValidationException("Failed to generate keys", t);
        }

        generateCertificate(organization, model, keyPair);
    }

    private void generateCertificate(CompanyModel organization, ComponentModel model, KeyPair keyPair) {
        try {
            Certificate certificate = CertificateUtils.generateV1SelfSignedCertificate(keyPair, organization.getName());
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
    public String getId() {
        return ID;
    }
}