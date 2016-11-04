/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

package org.openfact.services.resource;

import org.openfact.provider.Provider;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.Spi;

/**
 * <p>A {@link Spi} to plug additional sub-resources to Organizations' RESTful API.
 * <p>
 * <p>Implementors can use this {@link Spi} to provide additional services to the mentioned API and extend Openfact capabilities by
 * creating JAX-RS sub-resources for paths not known by the server.
 *
 * @author <a href="mailto:psilva@sistcoop.com">Pedro Igor</a>
 */
public class OrganizationResourceSPI implements Spi {

    @Override
    public boolean isInternal() {
        return true;
    }

    @Override
    public String getName() {
        return "organization-restapi-extension";
    }

    @Override
    public Class<? extends Provider> getProviderClass() {
        return OrganizationResourceProvider.class;
    }

    @Override
    public Class<? extends ProviderFactory> getProviderFactoryClass() {
        return OrganizationResourceProviderFactory.class;
    }
}
