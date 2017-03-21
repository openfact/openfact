package org.openfact.services.security.resolvers;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.KeycloakDeployment;
import org.keycloak.adapters.KeycloakDeploymentBuilder;
import org.keycloak.adapters.OIDCHttpFacade;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class JbossHomeKeycloakConfigResolver implements KeycloakConfigResolver {

    private final static String configFileName = "keycloak.json";

    private KeycloakDeployment keycloakDeployment;

    @Override
    public KeycloakDeployment resolve(OIDCHttpFacade.Request request) {
        if (keycloakDeployment == null) {
            try {
                URL url = getKeycloakConfigFile();
                if (url == null) {
                    url = getClass().getResource(configFileName);
                }
                if (url == null) {
                    throw new IllegalStateException("Not able to find the file keycloak.json");
                }

                InputStream is = getKeycloakConfigFile().openStream();
                this.keycloakDeployment = KeycloakDeploymentBuilder.build(is);
            } catch (IOException e) {
                throw new IllegalStateException("Not able to open the file keycloak.json");
            }
        }
        return keycloakDeployment;
    }

    public static URL getKeycloakConfigFile() {
        URL rval = null;

        // Wildfly/EAP
        ///////////////////////////////////
        String jbossConfigDir = System.getProperty("jboss.server.config.dir"); //$NON-NLS-1$
        String jbossConfigUrl = System.getProperty("jboss.server.config.url"); //$NON-NLS-1$
        if (jbossConfigDir != null) {
            File dirFile = new File(jbossConfigDir);
            rval = findConfigUrlInDirectory(dirFile, configFileName);
            if (rval != null) {
                return rval;
            }
        }
        if (jbossConfigUrl != null) {
            File dirFile = new File(jbossConfigUrl);
            rval = findConfigUrlInDirectory(dirFile, configFileName);
            if (rval != null) {
                return rval;
            }
        }

        return rval;
    }

    /**
     * Returns a URL to a file with the given name inside the given directory.
     */
    protected static URL findConfigUrlInDirectory(File directory, String configName) {
        if (directory.isDirectory()) {
            File cfile = new File(directory, configName);
            if (cfile.isFile()) {
                try {
                    return cfile.toURI().toURL();
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return null;
    }

}