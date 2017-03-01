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

import org.openfact.models.*;
import org.openfact.models.utils.OpenfactModelUtils;
import org.w3c.dom.Document;

import com.helger.ubl21.UBL21Reader;
import com.helger.ubl21.UBL21Writer;

import oasis.names.specification.ubl.schema.xsd.creditnote_21.CreditNoteType;

public class DefaultUBLCreditNoteProvider implements UBLCreditNoteProvider {

    @Override
    public UBLIDGenerator<CreditNoteType> idGenerator() {
        return new UBLIDGenerator<CreditNoteType>() {
            @Override
            public String generateID(OrganizationModel organization, CreditNoteType t) {
                return OpenfactModelUtils.generateId();
            }
        };
    }

    @Override
    public UBLReader<CreditNoteType> reader() {
        return new UBLReader<CreditNoteType>() {
            @Override
            public CreditNoteType read(Document document) {
                return UBL21Reader.creditNote().read(document);
            }

            @Override
            public CreditNoteType read(byte[] bytes) {
                return UBL21Reader.creditNote().read(bytes);
            }
        };
    }

    @Override
    public UBLWriter<CreditNoteType> writer() {
        return new UBLWriter<CreditNoteType>() {
            @Override
            public Document write(OrganizationModel organization, CreditNoteType t) {
                return UBL21Writer.creditNote().getAsDocument(t);
            }
        };
    }

    @Override
    public UBLSender<DocumentModel> sender() {
        //return new DefaultUBLSenderProvider(session);
        return null;
    }

}
