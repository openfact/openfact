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

import org.jboss.as.ee.component.EEModuleDescription;
import org.jboss.as.server.deployment.DeploymentPhaseContext;
import org.jboss.as.server.deployment.DeploymentUnit;
import org.jboss.as.server.deployment.DeploymentUnitProcessingException;
import org.jboss.as.server.deployment.DeploymentUnitProcessor;
import org.jboss.as.web.common.WarMetaData;
import org.jboss.metadata.javaee.spec.ParamValueMetaData;
import org.jboss.metadata.web.jboss.JBossWebMetaData;
import org.jboss.msc.service.ServiceName;
import org.jboss.msc.service.ServiceTarget;

import java.util.ArrayList;
import java.util.List;

/**
 * DUP responsible for setting the web context of a Openfact auth server and
 * passing the Openfact configuration to the Openfact server.
 *
 * @author Stan Silvert ssilvert@redhat.com (C) 2014 Red Hat Inc.
 */
public class OpenfactServerDeploymentProcessor implements DeploymentUnitProcessor {

    // This param name is defined again in Openfact Services class
    // org.openfact.services.resources.OpenfactApplication.  We have this value in
    // two places to avoid dependency between Openfact Subsystem and Keyclaok Services module.
    public static final String OPENFACT_CONFIG_PARAM_NAME = "org.openfact.server-subsystem.Config";

    @Override
    public void deploy(DeploymentPhaseContext phaseContext) throws DeploymentUnitProcessingException {
        DeploymentUnit deploymentUnit = phaseContext.getDeploymentUnit();
        OpenfactAdapterConfigService configService = OpenfactAdapterConfigService.INSTANCE;
        String deploymentName = deploymentUnit.getName();

        if (!configService.isOpenfactServerDeployment(deploymentName)) {
            return;
        }

        final EEModuleDescription description = deploymentUnit.getAttachment(org.jboss.as.ee.component.Attachments.EE_MODULE_DESCRIPTION);
        String webContext = configService.getWebContext();
        if (webContext == null) {
            throw new DeploymentUnitProcessingException("Can't determine web context/module for Openfact Server");
        }
        description.setModuleName(webContext);

        addConfiguration(deploymentUnit, configService);
    }
    
    private void addConfiguration(DeploymentUnit deploymentUnit, OpenfactAdapterConfigService configService) throws DeploymentUnitProcessingException {
        WarMetaData warMetaData = deploymentUnit.getAttachment(WarMetaData.ATTACHMENT_KEY);
        if (warMetaData == null) {
            throw new DeploymentUnitProcessingException("WarMetaData not found for OpenfactServer.");
        }
        
        JBossWebMetaData webMetaData = warMetaData.getMergedJBossWebMetaData();
        if (webMetaData == null) {
            webMetaData = new JBossWebMetaData();
            warMetaData.setMergedJBossWebMetaData(webMetaData);
        }

        List<ParamValueMetaData> contextParams = webMetaData.getContextParams();
        if (contextParams == null) {
            contextParams = new ArrayList<ParamValueMetaData>();
        }

        ParamValueMetaData param = new ParamValueMetaData();
        param.setParamName(OPENFACT_CONFIG_PARAM_NAME);
        param.setParamValue(configService.getConfig().toString());
        contextParams.add(param);

        webMetaData.setContextParams(contextParams);
    }

    @Override
    public void undeploy(DeploymentUnit du) {
    }
}
