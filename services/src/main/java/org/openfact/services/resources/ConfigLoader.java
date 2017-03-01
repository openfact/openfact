package org.openfact.services.resources;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;

import org.jboss.dmr.ModelNode;
import org.jboss.logging.Logger;
import org.openfact.Config;
import org.openfact.common.util.SystemEnvProperties;
import org.openfact.services.util.JsonConfigProvider;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Singleton
@Startup
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class ConfigLoader {

    protected static final Logger logger = Logger.getLogger(ConfigLoader.class);
    
    public static final String OPENFACT_CONFIG_PARAM_NAME = "org.openfact.server-subsystem.Config";

    @Context
    private ServletContext context;

    @PostConstruct
    private void init() {
        loadConfig();
    }

    private void loadConfig() {
        try {
            JsonNode node = null;

            String dmrConfig = loadDmrConfig(context);
            if (dmrConfig != null) {
                node = new ObjectMapper().readTree(dmrConfig);                
                logger.error("Error loading openfact-server.json config from standalone.xml or domain.xml");
            }

            String configDir = System.getProperty("jboss.server.config.dir");
            if (node == null && configDir != null) {
                File f = new File(configDir + File.separator + "openfact-server.json");
                if (f.isFile()) {                    
                    logger.error("Error loading openfact-server.json config from " + f.getAbsolutePath());
                    node = new ObjectMapper().readTree(f);
                }
            }

            if (node == null) {
                URL resource = Thread.currentThread().getContextClassLoader().getResource("META-INF/openfact-server.json");
                if (resource != null) {                    
                    logger.error("Error loading openfact-server.json config from " + resource);
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
    
    private String loadDmrConfig(ServletContext context) {
        String dmrConfig = context.getInitParameter(OPENFACT_CONFIG_PARAM_NAME);
        if (dmrConfig == null)
            return null;

        ModelNode dmrConfigNode = ModelNode.fromString(dmrConfig);
        if (dmrConfigNode.asPropertyList().isEmpty())
            return null;

        // note that we need to resolve expressions BEFORE we convert to JSON
        return dmrConfigNode.resolve().toJSONString(true);
    }

}
