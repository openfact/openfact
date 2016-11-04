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

/**
 * <p>A {@link OrganizationResourceProvider} creates JAX-RS <emphasis>sub-resource</emphasis> instances for paths relative
 * to Organization's RESTful API that could not be resolved by the server.
 *
 * @author <a href="mailto:psilva@sistcoop.com">Pedro Igor</a>
 */
public interface OrganizationResourceProvider extends Provider {

    /**
     * <p>Returns a JAX-RS resource instance.
     *
     * @return a JAX-RS sub-resource instance
     */
    Object getResource();

}
