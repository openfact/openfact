package org.openfact.services.managers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.deltaspike.core.api.literal.DefaultLiteral;
import org.apache.deltaspike.core.util.metadata.builder.AnnotatedTypeBuilder;
import org.jboss.dmr.ModelNode;
import org.jboss.logging.Logger;
import org.openfact.Config;
import org.openfact.common.util.SystemEnvProperties;
import org.openfact.OpenfactConfigResolver;
import org.openfact.provider.SingleProviderType;
import org.openfact.services.util.JsonConfigProvider;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.inject.spi.BeforeBeanDiscovery;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessAnnotatedType;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.ServiceLoader;

public class OpenfactExtension implements Extension {

    protected static final Logger logger = Logger.getLogger(OpenfactExtension.class);

    public static final String OPENFACT_CONFIG_PARAM_NAME = "org.openfact.server-subsystem.Config";

    public void beforeBeanDiscovery(@Observes BeforeBeanDiscovery event) {
        loadConfig();
    }

    public <X> void processAnnotatedType(@Observes ProcessAnnotatedType<X> event) {
        AnnotatedType<X> origin = event.getAnnotatedType();
        if (origin.isAnnotationPresent(SingleProviderType.class)) {

            SingleProviderType singleProviderType = origin.getAnnotation(SingleProviderType.class);

            String provider = Config.getProvider(singleProviderType.provider());
            if (singleProviderType.value().equals(provider)) {
                AnnotatedType<X> updated = new AnnotatedTypeBuilder<X>()
                        .readFromType(origin, true)
                        .addToClass(new DefaultLiteral())
                        .create();
                event.setAnnotatedType(updated);
            }
        }
    }

    private void loadConfig() {
        try {
            JsonNode node = null;

            String dmrConfig = loadDmrConfig();
            if (node == null && dmrConfig != null) {
                node = new ObjectMapper().readTree(dmrConfig);
                logger.info("Loading openfact-server.json config from standalone.xml or domain.xml");
            }

            ServiceLoader<OpenfactConfigResolver> loader = ServiceLoader.load(OpenfactConfigResolver.class, getClass().getClassLoader());
            List<OpenfactConfigResolver> configResolvers = new ArrayList<>();
            for (OpenfactConfigResolver configResolver : loader) {
                configResolvers.add(configResolver);
            }
            if (!configResolvers.isEmpty()) {
                if (configResolvers.size() > 1) {
                    logger.error("More than one Config Resolver found");
                    throw new IllegalStateException("More than one Config Resolver found");
                }

                OpenfactConfigResolver configResolver = configResolvers.get(0);
                node = configResolver.getNode();
                logger.info("Loading openfact-server.json config from " + configResolver.getClass().getName());
            }

            String configDir = System.getProperty("jboss.server.config.dir");
            if (node == null && configDir != null) {
                File f = new File(configDir + File.separator + "openfact-server.json");
                if (f.isFile()) {
                    logger.info("Loading openfact-server.json config from " + f.getAbsolutePath());
                    node = new ObjectMapper().readTree(f);
                }
            }

            if (node == null) {
                URL resource = Thread.currentThread().getContextClassLoader().getResource("META-INF/openfact-server.json");
                if (resource != null) {
                    logger.info("Loading openfact-server.json config from " + resource);
                    node = new ObjectMapper().readTree(resource);
                }
            }

            if (node != null) {
                Properties properties = new SystemEnvProperties();
                Config.init(new JsonConfigProvider(node, properties));
            } else {
                throw new RuntimeException("Openfact config not found.");
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config", e);
        }
    }

    private String loadDmrConfig() {
        String dmrConfig = System.getProperty(OPENFACT_CONFIG_PARAM_NAME);
        if (dmrConfig == null) {
            return null;
        }

        ModelNode dmrConfigNode = ModelNode.fromString(dmrConfig);
        if (dmrConfigNode.asPropertyList().isEmpty()) {
            return null;
        }

        // note that we need to resolve expressions BEFORE we convert to JSON
        return dmrConfigNode.resolve().toJSONString(true);
    }

}
