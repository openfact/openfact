package org.openfact.services;

import org.openfact.common.Version;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

public class Urls {

    public static URI themeRoot(URI baseUri) {
        return themeBase(baseUri).path(Version.RESOURCES_VERSION).build();
    }

    private static UriBuilder themeBase(URI baseUri) {
        return UriBuilder.fromUri(baseUri).path(ThemeResource.class);
    }

}
