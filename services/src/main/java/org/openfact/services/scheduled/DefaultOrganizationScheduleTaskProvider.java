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

import org.easybatch.core.filter.HeaderRecordFilter;
import org.easybatch.core.job.*;
import org.easybatch.core.listener.BatchListener;
import org.easybatch.core.processor.RecordProcessor;
import org.easybatch.core.reader.IterableRecordReader;
import org.easybatch.core.reader.RecordReader;
import org.easybatch.core.reader.RetryableRecordReader;
import org.easybatch.core.record.GenericRecord;
import org.easybatch.core.record.Header;
import org.easybatch.core.record.Record;
import org.easybatch.core.retry.RetryPolicy;
import org.easybatch.tools.reporting.HtmlJobReportFormatter;
import org.openfact.models.*;
import org.openfact.models.enums.RequiredAction;
import org.openfact.services.managers.CreditNoteManager;
import org.openfact.services.managers.DebitNoteManager;
import org.openfact.services.managers.InvoiceManager;
import org.openfact.ubl.SendEventModel;
import org.openfact.ubl.SendException;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class DefaultOrganizationScheduleTaskProvider implements OrganizationScheduleTaskProvider {

    protected OpenfactSession session;

    public DefaultOrganizationScheduleTaskProvider(OpenfactSession session) {
        this.session = session;
    }

    @Override
    public void close() {
    }

    @Override
    public void run(OrganizationModel organization) {
        ScrollModel<InvoiceModel> invoices = session.invoices().getInvoicesScroll(organization, false, 100);
        Iterator<InvoiceModel> iterator = invoices.iterator();
        Iterable<InvoiceModel> iterable = () -> iterator;
        Stream<InvoiceModel> iteratorStream = StreamSupport.stream(iterable.spliterator(), true);

        while (iterator.hasNext()) {
            InvoiceModel invoice = iterator.next();
            InvoiceManager manager = new InvoiceManager(session);

            try {
                Set<String> requiredActions = invoice.getRequiredActions();
                if(requiredActions.contains(RequiredAction.SEND_TO_CUSTOMER.toString())) {
                    SendEventModel sendEvent = manager.sendToCustomerParty(organization, invoice);
                    if(sendEvent.getResult()) {
                        invoice.removeRequiredAction(RequiredAction.SEND_TO_CUSTOMER);
                    }
                }
            } catch (SendException e) {
                throw new JobException("error on execute job", e);
            }
        }
    }

    private void processJobReport(OrganizationModel organization, JobReport jobReport) {
        // Save Report
        JobReportModel jobReportModel = session.jobReports().createJobReport(organization, jobReport.getJobName());

        // Metrics
        JobMetrics metrics = jobReport.getMetrics();
        jobReportModel.setStartTime(metrics.getStartTime());
        jobReportModel.setEndTime(metrics.getEndTime());
        jobReportModel.setDuration(metrics.getDuration());
        jobReportModel.setReadCount(metrics.getReadCount());
        jobReportModel.setWriteCount(metrics.getWriteCount());
        jobReportModel.setErrorCount(metrics.getErrorCount());
    }

}
