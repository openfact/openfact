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
package org.openfact.services.scheduled;

import org.openfact.Config.Scope;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.models.OrganizationScheduleTaskProvider;
import org.openfact.models.OrganizationScheduleTaskProviderFactory;

public class SendToThridPartyOrganizationScheduleTaskProviderFactory implements OrganizationScheduleTaskProviderFactory {

    protected boolean isActive;

    @Override
    public OrganizationScheduleTaskProvider create(OpenfactSession session) {
        return new SendToThridPartyOrganizationScheduleTaskProvider(isActive);
    }

    @Override
    public void init(Scope config) {
        isActive = config.getBoolean("active", true);
    }

    @Override
    public void postInit(OpenfactSessionFactory factory) {
    }

    @Override
    public void close() {
    }

    @Override
    public String getId() {
        return "sendToThridParty";
    }
}
