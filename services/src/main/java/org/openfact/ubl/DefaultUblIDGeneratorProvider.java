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
package org.openfact.ubl;

import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.utils.OpenfactModelUtils;

public class DefaultUblIDGeneratorProvider implements UblIDGeneratorProvider {

    protected OpenfactSession session;

    public DefaultUblIDGeneratorProvider(OpenfactSession session) {
        this.session = session;
    }

    @Override
    public void close() {
    }

    @Override
    public String generateInvoiceID(OrganizationModel organization, String invoiceCodeType) {
        return OpenfactModelUtils.generateId();
    }

    @Override
    public String generateCreditNoteID(OrganizationModel organization, String... referencesID) {
        return OpenfactModelUtils.generateId();
    }

    @Override
    public String generateDebitNoteID(OrganizationModel organization, String... referencesID) {
        return OpenfactModelUtils.generateId();
    }

}
