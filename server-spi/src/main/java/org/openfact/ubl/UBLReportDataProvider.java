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

import org.omg.CORBA.Object;
import org.openfact.models.CreditNoteModel;
import org.openfact.models.DebitNoteModel;
import org.openfact.models.InvoiceModel;
import org.openfact.models.OrganizationModel;
import org.openfact.provider.Provider;
import org.openfact.report.ReportDataProvider;
import org.openfact.report.ReportTemplateProvider;

import java.util.List;
import java.util.Map;

public interface UBLReportDataProvider<T> extends Provider {

    int getProviderPriority();

    ReportDataProvider<InvoiceModel> invoice();

    ReportDataProvider<CreditNoteModel> creditNote();

    ReportDataProvider<DebitNoteModel> debitNote();

}
