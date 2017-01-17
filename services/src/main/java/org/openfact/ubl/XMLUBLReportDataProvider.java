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
package org.openfact.ubl;

import org.jboss.logging.Logger;
import org.openfact.models.*;
import org.openfact.report.*;

public class XMLUBLReportDataProvider implements UBLReportDataProvider {

    private static final Logger logger = Logger.getLogger(XMLUBLReportDataProvider.class);

    protected OpenfactSession session;

    public XMLUBLReportDataProvider(OpenfactSession session) {
        this.session = session;
    }

    @Override
    public int getProviderPriority() {
        return 0;
    }

    @Override
    public ReportDataProvider<InvoiceModel> invoice() {
        return new ReportDataProvider<InvoiceModel>() {

            @Override
            public Object getFieldValue(InvoiceModel invoice, String fieldName) {
                XMLSupportedAttribute attribute = XMLSupportedAttribute.fromString(fieldName.toUpperCase());
                if (attribute != null) {
                    return attribute.asObject(invoice.getXmlAsJSONObject());
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
            public Object getFieldValue(CreditNoteModel creditNote, String fieldName) {
                XMLSupportedAttribute attribute = XMLSupportedAttribute.fromString(fieldName);
                if (attribute != null) {
                    return attribute.asObject(creditNote.getXmlAsJSONObject());
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
            public Object getFieldValue(DebitNoteModel debitNote, String fieldName) {
                XMLSupportedAttribute attribute = XMLSupportedAttribute.fromString(fieldName);
                if (attribute != null) {
                    return attribute.asObject(debitNote.getXmlAsJSONObject());
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
