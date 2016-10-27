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

package org.openfact.services;

import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.openfact.common.ClientConnection;
import org.openfact.models.OpenfactContext;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.UserModel;
import org.openfact.models.utils.OrganizationImporter;
import org.openfact.services.managers.OrganizationManager;
import org.openfact.services.resources.OpenfactApplication;
import org.openfact.services.util.LocaleHelper;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.Locale;

/**
 * @author <a href="mailto:sthorger@redhat.com">Stian Thorgersen</a>
 */
public class DefaultOpenfactContext implements OpenfactContext {

    private OrganizationModel organization;

    private ClientConnection connection;

    private OpenfactSession session;

    public DefaultOpenfactContext(OpenfactSession session) {
        this.session = session;
    }

    @Override
    public URI getAuthServerUrl() {
        UriInfo uri = getUri();
        OpenfactApplication openfactApplication = getContextObject(OpenfactApplication.class);
        return openfactApplication.getBaseUri(uri);
    }

    @Override
    public String getContextPath() {
        OpenfactApplication app = getContextObject(OpenfactApplication.class);
        if (app == null) return null;
        return app.getContextPath();
    }

    @Override
    public UriInfo getUri() {
        return getContextObject(UriInfo.class);
    }

    @Override
    public HttpHeaders getRequestHeaders() {
        return getContextObject(HttpHeaders.class);
    }

    @Override
    public <T> T getContextObject(Class<T> clazz) {
        return ResteasyProviderFactory.getContextData(clazz);
    }

    @Override
    public OrganizationModel getOrganization() {
        return organization;
    }

    @Override
    public void setOrganization(OrganizationModel organization) {
        this.organization = organization;
    }

    @Override
    public ClientConnection getConnection() {
        return connection;
    }

    @Override
    public void setConnection(ClientConnection connection) {
        this.connection = connection;
    }

    @Override
    public OrganizationImporter getOrganizationManager() {
        OrganizationManager manager = new OrganizationManager(session);
        manager.setContextPath(getContextPath());
        return manager;
    }

    @Override
    public Locale resolveLocale(UserModel user) {
        return LocaleHelper.getLocale(session, organization, user);
    }
}