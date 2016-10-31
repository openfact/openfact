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
package org.openfact.subsystem.server.extension;

import org.jboss.as.server.deployment.Attachments;
import org.jboss.as.server.deployment.DeploymentPhaseContext;
import org.jboss.as.server.deployment.DeploymentUnit;
import org.jboss.as.server.deployment.DeploymentUnitProcessingException;
import org.jboss.as.server.deployment.DeploymentUnitProcessor;
import org.jboss.as.server.deployment.module.ModuleDependency;
import org.jboss.as.server.deployment.module.ModuleSpecification;
import org.jboss.as.server.deployment.module.ResourceRoot;
import org.jboss.logging.Logger;
import org.jboss.modules.Module;
import org.jboss.modules.ModuleIdentifier;
import org.jboss.modules.ModuleLoader;
import org.jboss.vfs.VirtualFile;
import org.jboss.vfs.util.AbstractVirtualFileFilterWithAttributes;

import java.io.IOException;
import java.util.List;

/**
 * @author <a href="mailto:bill@burkecentral.com">Bill Burke</a>
 * @version $Revision: 1 $
 */
public class OpenfactProviderDependencyProcessor implements DeploymentUnitProcessor {
    private static final ModuleIdentifier OPENFACT_COMMON = ModuleIdentifier.create("org.openfact.openfact-common");
    private static final ModuleIdentifier OPENFACT_CORE = ModuleIdentifier.create("org.openfact.openfact-core");
    private static final ModuleIdentifier OPENFACT_SERVER_SPI = ModuleIdentifier.create("org.openfact.openfact-server-spi");
    private static final ModuleIdentifier OPENFACT_JPA = ModuleIdentifier.create("org.openfact.openfact-model-jpa");
    private static final ModuleIdentifier JAXRS = ModuleIdentifier.create("javax.ws.rs.api");
    private static final ModuleIdentifier RESTEASY = ModuleIdentifier.create("org.jboss.resteasy.resteasy-jaxrs");
    private static final ModuleIdentifier APACHE = ModuleIdentifier.create("org.apache.httpcomponents");

    private static final Logger logger = Logger.getLogger(OpenfactProviderDependencyProcessor.class);

    @Override
    public void deploy(DeploymentPhaseContext phaseContext) throws DeploymentUnitProcessingException {
        DeploymentUnit deploymentUnit = phaseContext.getDeploymentUnit();
        OpenfactAdapterConfigService config = OpenfactAdapterConfigService.INSTANCE;
        String deploymentName = deploymentUnit.getName();

        if (config.isOpenfactServerDeployment(deploymentName)) {
            return;
        }

        if (!isOpenfactProviderDeployment(deploymentUnit)) return;

        final ModuleSpecification moduleSpecification = deploymentUnit.getAttachment(Attachments.MODULE_SPECIFICATION);
        final ModuleLoader moduleLoader = Module.getBootModuleLoader();
        moduleSpecification.addSystemDependency(new ModuleDependency(moduleLoader, OPENFACT_COMMON, false, false, false, false));
        moduleSpecification.addSystemDependency(new ModuleDependency(moduleLoader, OPENFACT_CORE, false, false, false, false));
        moduleSpecification.addSystemDependency(new ModuleDependency(moduleLoader, OPENFACT_SERVER_SPI, false, false, false, false));
        moduleSpecification.addSystemDependency(new ModuleDependency(moduleLoader, JAXRS, false, false, false, false));
        moduleSpecification.addSystemDependency(new ModuleDependency(moduleLoader, RESTEASY, false, false, false, false));
        moduleSpecification.addSystemDependency(new ModuleDependency(moduleLoader, APACHE, false, false, false, false));
        moduleSpecification.addSystemDependency(new ModuleDependency(moduleLoader, OPENFACT_JPA, false, false, false, false));


    }

    public OpenfactProviderDependencyProcessor() {
        super();
    }

    public static boolean isOpenfactProviderDeployment(DeploymentUnit du) {
        final ResourceRoot resourceRoot = du.getAttachment(Attachments.DEPLOYMENT_ROOT);
        if (resourceRoot == null) {
            return false;
        }
        final VirtualFile deploymentRoot = resourceRoot.getRoot();
        if (deploymentRoot == null || !deploymentRoot.exists()) {
            return false;
        }
        VirtualFile services = deploymentRoot.getChild("META-INF/services");
        if (!services.exists()) return false;
        try {
            List<VirtualFile> archives = services.getChildren(new AbstractVirtualFileFilterWithAttributes(){
                @Override
                public boolean accepts(VirtualFile file) {
                    return file.getName().startsWith("org.openfact");
                }
            });
            return !archives.isEmpty();
        } catch (IOException e) {

        }
        return false;
    }

    @Override
    public void undeploy(DeploymentUnit context) {

    }
}
