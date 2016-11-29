/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
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
 *******************************************************************************/

package org.openfact.provider;

import org.openfact.Config;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;

/**
 * At boot time, openfact discovers all factories.  For each discovered factory, the init() method is called.  After
 * all factories have been initialized, the postInit() method is called.  close() is called when the server shuts down.
 *
 * Only one instance of a factory exists per server.
 *
 * @author <a href="mailto:sthorger@redhat.com">Stian Thorgersen</a>
 */
public interface ProviderFactory<T extends Provider> {

    public T create(OpenfactSession session);

    /**
     * Only called once when the factory is first created.  This config is pulled from openfact_server.json
     *
     * @param config
     */
    public void init(Config.Scope config);

    /**
     * Called after all provider factories have been initialized
     */
    public void postInit(OpenfactSessionFactory factory);

    /**
     * This is called when the server shuts down.
     *
     */
    public void close();

    public String getId();

}
