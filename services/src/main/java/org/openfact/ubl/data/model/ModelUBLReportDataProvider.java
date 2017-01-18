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
package org.openfact.ubl.data.model;

import org.jboss.logging.Logger;
import org.openfact.models.CreditNoteModel;
import org.openfact.models.DebitNoteModel;
import org.openfact.models.InvoiceModel;
import org.openfact.models.OpenfactSession;
import org.openfact.report.ReportDataProvider;
import org.openfact.ubl.UBLReportDataProvider;

public class ModelUBLReportDataProvider implements UBLReportDataProvider {

    private static final Logger logger = Logger.getLogger(ModelUBLReportDataProvider.class);

    protected OpenfactSession session;

    public ModelUBLReportDataProvider(OpenfactSession session) {
        this.session = session;
    }

    @Override
    public int getProviderPriority() {
        return 100;
    }

    @Override
    public ReportDataProvider<InvoiceModel> invoice() {
        return new ReportDataProvider<InvoiceModel>() {

            @Override
            public Object getFieldValue(InvoiceModel model, String fieldName) {
                ModelSupportedAttribute attribute = ModelSupportedAttribute.fromString(fieldName.toUpperCase());
                if (attribute != null) {
                    switch (attribute) {
                        case OF_DOCUMENT_ID: return model.getDocumentId();
                    }
                }
                return null;
            }

            @Override
            public void close() {
            }

        };
    }

    @Override
    public ReportDataProvider<CreditNoteModel> creditNote() {
        return new ReportDataProvider<CreditNoteModel>() {

            @Override
            public Object getFieldValue(CreditNoteModel model, String fieldName) {
                ModelSupportedAttribute attribute = ModelSupportedAttribute.fromString(fieldName.toUpperCase());
                if (attribute != null) {
                    switch (attribute) {
                        case OF_DOCUMENT_ID: return model.getDocumentId();
                    }
                }
                return null;
            }

            @Override
            public void close() {
            }

        };
    }

    @Override
    public ReportDataProvider<DebitNoteModel> debitNote() {
        return new ReportDataProvider<DebitNoteModel>() {

            @Override
            public Object getFieldValue(DebitNoteModel model, String fieldName) {
                ModelSupportedAttribute attribute = ModelSupportedAttribute.fromString(fieldName.toUpperCase());
                if (attribute != null) {
                    switch (attribute) {
                        case OF_DOCUMENT_ID: return model.getDocumentId();
                    }
                }
                return null;
            }

            @Override
            public void close() {
            }

        };
    }

    @Override
    public void close() {
    }
}
