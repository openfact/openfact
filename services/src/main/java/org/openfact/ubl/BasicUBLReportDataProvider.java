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

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.openfact.models.*;
import org.openfact.report.*;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class BasicUBLReportDataProvider implements UBLReportDataProvider {

    public enum PARAMETERS {
        OF_ORGANIZATION
    }

    protected  OpenfactSession session;

    public BasicUBLReportDataProvider(OpenfactSession session) {
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
            public Map<String, Object> getParameters(OrganizationModel organization, InvoiceModel invoiceModel) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put(PARAMETERS.OF_ORGANIZATION.toString(), organization.getName());
                return parameters;
            }

            @Override
            public void close() {
            }
        };
    }

    @Override
    public ReportDataProvider<CreditNoteModel> creditNote() {
        return null;
    }

    @Override
    public ReportDataProvider<DebitNoteModel> debitNote() {
        return null;
    }

    @Override
    public void close() {
    }
}
