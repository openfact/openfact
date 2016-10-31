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

import org.jboss.as.controller.Extension;
import org.jboss.as.controller.ExtensionContext;
import org.jboss.as.controller.ModelVersion;
import org.jboss.as.controller.PathElement;
import org.jboss.as.controller.ResourceDefinition;
import org.jboss.as.controller.SubsystemRegistration;
import org.jboss.as.controller.descriptions.StandardResourceDescriptionResolver;
import org.jboss.as.controller.parsing.ExtensionParsingContext;
import org.jboss.as.controller.registry.ManagementResourceRegistration;

import static org.jboss.as.controller.descriptions.ModelDescriptionConstants.SUBSYSTEM;
import static org.openfact.subsystem.server.logging.OpenfactLogger.ROOT_LOGGER;


/**
 * Main Extension class for the subsystem.
 *
 * @author Stan Silvert ssilvert@redhat.com (C) 2013 Red Hat Inc.
 */
public class OpenfactExtension implements Extension {

    static final String SUBSYSTEM_NAME = "openfact-server";
    static final String NAMESPACE = "urn:jboss:domain:openfact-server:1.1";
    static final PathElement PATH_SUBSYSTEM = PathElement.pathElement(SUBSYSTEM, SUBSYSTEM_NAME);

    private static final String RESOURCE_NAME = OpenfactExtension.class.getPackage().getName() + ".LocalDescriptions";
    private static final ResourceDefinition OPENFACT_SUBSYSTEM_RESOURCE = new OpenfactSubsystemDefinition();
    private static final OpenfactSubsystemParser PARSER = new OpenfactSubsystemParser();
    private static final ModelVersion MGMT_API_VERSION = ModelVersion.create(1,1,0);
    
    static final ThemeResourceDefinition THEME_DEFINITION = new ThemeResourceDefinition();
    static final SpiResourceDefinition SPI_DEFINITION = new SpiResourceDefinition();
    static final ProviderResourceDefinition PROVIDER_DEFINITION = new ProviderResourceDefinition();

    static StandardResourceDescriptionResolver getResourceDescriptionResolver(final String... keyPrefix) {
        StringBuilder prefix = new StringBuilder(SUBSYSTEM_NAME);
        for (String kp : keyPrefix) {
            prefix.append('.').append(kp);
        }
        return new StandardResourceDescriptionResolver(prefix.toString(), RESOURCE_NAME, OpenfactExtension.class.getClassLoader(), true, false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initializeParsers(final ExtensionParsingContext context) {
        context.setSubsystemXmlMapping(SUBSYSTEM_NAME, NAMESPACE, PARSER);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initialize(final ExtensionContext context) {
        ROOT_LOGGER.debug("Activating Openfact Extension");
        final SubsystemRegistration subsystem = context.registerSubsystem(SUBSYSTEM_NAME, MGMT_API_VERSION);

        ManagementResourceRegistration subsystemRegistration = subsystem.registerSubsystemModel(OPENFACT_SUBSYSTEM_RESOURCE);
        subsystemRegistration.registerSubModel(THEME_DEFINITION);
        ManagementResourceRegistration spiRegistration = subsystemRegistration.registerSubModel(SPI_DEFINITION);
        spiRegistration.registerSubModel(PROVIDER_DEFINITION);
        
        subsystem.registerXMLElementWriter(PARSER);
    }
}
