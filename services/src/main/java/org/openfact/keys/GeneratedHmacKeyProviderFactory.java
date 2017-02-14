package org.openfact.keys;

import org.jboss.logging.Logger;
import org.openfact.Config;
import org.openfact.common.util.Base64Url;
import org.openfact.component.ComponentModel;
import org.openfact.component.ComponentValidationException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.models.OrganizationModel;
import org.openfact.models.utils.OpenfactModelUtils;
import org.openfact.provider.ConfigurationValidationHelper;
import org.openfact.provider.ProviderConfigProperty;

import java.util.List;

public class GeneratedHmacKeyProviderFactory extends AbstractHmacKeyProviderFactory {

    private static final Logger logger = Logger.getLogger(GeneratedHmacKeyProviderFactory.class);

    public static final String ID = "hmac-generated";

    private static final String HELP_TEXT = "Generates HMAC secret key";

    private static final List<ProviderConfigProperty> CONFIG_PROPERTIES = AbstractHmacKeyProviderFactory.configurationBuilder()
            .property(Attributes.SECRET_SIZE_PROPERTY)
            .build();

    @Override
    public KeyProvider create(OpenfactSession session, ComponentModel model) {
        return new GeneratedHmacKeyProvider(model);
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
    public void validateConfiguration(OpenfactSession session, OrganizationModel organization, ComponentModel model) throws ComponentValidationException {
        ConfigurationValidationHelper.check(model).checkList(Attributes.SECRET_SIZE_PROPERTY, false);

        int size = model.get(Attributes.SECRET_SIZE_KEY, 32);

        if (!(model.contains(Attributes.SECRET_KEY))) {
            generateSecret(model, size);
            logger.debugv("Generated secret for {0}", organization.getName());
        } else {
            int currentSize = Base64Url.decode(model.get(Attributes.SECRET_KEY)).length;
            if (currentSize != size) {
                generateSecret(model, size);
                logger.debugv("Secret size changed, generating new secret for {0}", organization.getName());
            }
        }
    }

    private void generateSecret(ComponentModel model, int size) {
        try {
            String secret = OpenfactModelUtils.generateSecret(size);
            model.put(Attributes.SECRET_KEY, secret);

            String kid = OpenfactModelUtils.generateId();
            model.put(Attributes.KID_KEY, kid);
        } catch (Throwable t) {
            throw new ComponentValidationException("Failed to generate secret", t);
        }
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
