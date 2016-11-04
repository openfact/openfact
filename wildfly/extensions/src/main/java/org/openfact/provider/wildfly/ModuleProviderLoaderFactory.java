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

package org.openfact.provider.wildfly;

import org.jboss.modules.Module;
import org.jboss.modules.ModuleClassLoader;
import org.jboss.modules.ModuleIdentifier;
import org.openfact.provider.DefaultProviderLoader;
import org.openfact.provider.ProviderLoader;
import org.openfact.provider.ProviderLoaderFactory;

/**
 * @author <a href="mailto:carlosthe19916@sistcoop.com">Carlos Feria</a>
 */
public class ModuleProviderLoaderFactory implements ProviderLoaderFactory {

    @Override
    public boolean supports(String type) {
        return "module".equals(type);
    }

    @Override
    public ProviderLoader create(ClassLoader baseClassLoader, String resource) {
        try {
            Module module = Module.getContextModuleLoader().loadModule(ModuleIdentifier.fromString(resource));
            ModuleClassLoader classLoader = module.getClassLoader();
            return new DefaultProviderLoader(classLoader);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}