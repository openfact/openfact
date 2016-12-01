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

package org.openfact.exportimport.util;

import org.openfact.common.Version;
import org.openfact.common.util.MultivaluedHashMap;
import org.openfact.component.ComponentModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.representations.idm.ComponentExportRepresentation;
import org.openfact.representations.idm.OrganizationRepresentation;

import java.util.List;

/**
 * @author <a href="mailto:mposolda@sistcoop.com">Marek Posolda</a>
 */
public class ExportUtils {

    public static OrganizationRepresentation exportOrganization(OpenfactSession session, OrganizationModel organization, boolean includeUsers) {
        OrganizationRepresentation rep = ModelToRepresentation.toRepresentation(organization, true);

        // Project/product version
        rep.setOpenfactVersion(Version.VERSION);

        // components
        MultivaluedHashMap<String, ComponentExportRepresentation> components = exportComponents(organization, organization.getId());
        rep.setComponents(components);

        return rep;
    }

    public static MultivaluedHashMap<String, ComponentExportRepresentation> exportComponents(OrganizationModel organization, String parentId) {
        List<ComponentModel> componentList = organization.getComponents(parentId);
        MultivaluedHashMap<String, ComponentExportRepresentation> components = new MultivaluedHashMap<>();
        for (ComponentModel component : componentList) {
            ComponentExportRepresentation compRep = new ComponentExportRepresentation();
            compRep.setId(component.getId());
            compRep.setProviderId(component.getProviderId());
            compRep.setConfig(component.getConfig());
            compRep.setName(component.getName());
            compRep.setSubType(component.getSubType());
            compRep.setSubComponents(exportComponents(organization, component.getId()));
            components.add(component.getProviderType(), compRep);
        }
        return components;
    }

}
