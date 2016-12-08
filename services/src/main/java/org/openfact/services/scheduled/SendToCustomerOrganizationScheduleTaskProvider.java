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

public class SendToCustomerOrganizationScheduleTaskProvider implements OrganizationScheduleTaskProvider {

    public static final String JOB_NAME = "SENT_TO_CUSTOMER";

    protected boolean isActive;

    public SendToCustomerOrganizationScheduleTaskProvider(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public void close() {
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public void run(OpenfactSession session, OrganizationModel organization) {
        // Start Job
        long startTime = System.currentTimeMillis();
        long readCount = 0;

        ScrollModel<List<InvoiceModel>> scroll = session.invoices().getInvoicesScroll(organization, 100, RequiredAction.SEND_TO_CUSTOMER);
        Iterator<List<InvoiceModel>> iterator = scroll.iterator();

        readCount += sendInvoices(session, organization);
        readCount += sendCreditNotes(session, organization);
        readCount += sendDebitNotes(session, organization);

        long endTime = System.currentTimeMillis();

        // Save Report
        JobReportModel jobReportModel = session.jobReports().createJobReport(organization, JOB_NAME);

        // Metrics
        jobReportModel.setStartTime(startTime);
        jobReportModel.setEndTime(endTime);
        jobReportModel.setDuration(endTime - startTime);
        jobReportModel.setReadCount(readCount);
    }

    private long sendInvoices(OpenfactSession session, OrganizationModel organization) {
        long readCount = 0;

        ScrollModel<List<InvoiceModel>> scroll = session.invoices().getInvoicesScroll(organization, 100, RequiredAction.SEND_TO_CUSTOMER);
        Iterator<List<InvoiceModel>> iterator = scroll.iterator();

        while (iterator.hasNext()) {
            List<InvoiceModel> invoices = iterator.next();

            readCount += invoices.size();

            invoices.parallelStream()
                    .filter(p -> p.getRequiredActions().contains(RequiredAction.SEND_TO_CUSTOMER))
                    .forEach(c -> {
                        InvoiceManager manager = new InvoiceManager(session);
                        try {
                            SendEventModel sendEvent = manager.sendToCustomerParty(organization, c);
                            if (sendEvent.getResult()) {
                                c.removeRequiredAction(RequiredAction.SEND_TO_CUSTOMER);
                            }
                        } catch (SendException e) {
                            throw new JobException("error on execute job", e);
                        }
                    });
        }

        return readCount;
    }

    private long sendCreditNotes(OpenfactSession session, OrganizationModel organization) {
        long readCount = 0;

        ScrollModel<List<CreditNoteModel>> scroll = session.creditNotes().getCreditNotesScroll(organization, 100, RequiredAction.SEND_TO_CUSTOMER);
        Iterator<List<CreditNoteModel>> iterator = scroll.iterator();

        while (iterator.hasNext()) {
            List<CreditNoteModel> creditNotes = iterator.next();

            readCount += creditNotes.size();

            creditNotes.parallelStream()
                    .filter(p -> p.getRequiredActions().contains(RequiredAction.SEND_TO_CUSTOMER))
                    .forEach(c -> {
                        CreditNoteManager manager = new CreditNoteManager(session);
                        try {
                            SendEventModel sendEvent = manager.sendToCustomerParty(organization, c);
                            if (sendEvent.getResult()) {
                                c.removeRequiredAction(RequiredAction.SEND_TO_CUSTOMER);
                            }
                        } catch (SendException e) {
                            throw new JobException("error on execute job", e);
                        }
                    });
        }

        return readCount;
    }

    private long sendDebitNotes(OpenfactSession session, OrganizationModel organization) {
        long readCount = 0;

        ScrollModel<List<DebitNoteModel>> scroll = session.debitNotes().getDebitNotesScroll(organization, 100, RequiredAction.SEND_TO_CUSTOMER);
        Iterator<List<DebitNoteModel>> iterator = scroll.iterator();

        while (iterator.hasNext()) {
            List<DebitNoteModel> debitNotes = iterator.next();

            readCount += debitNotes.size();

            debitNotes.parallelStream()
                    .filter(p -> p.getRequiredActions().contains(RequiredAction.SEND_TO_CUSTOMER))
                    .forEach(c -> {
                        DebitNoteManager manager = new DebitNoteManager(session);
                        try {
                            SendEventModel sendEvent = manager.sendToCustomerParty(organization, c);
                            if (sendEvent.getResult()) {
                                c.removeRequiredAction(RequiredAction.SEND_TO_CUSTOMER);
                            }
                        } catch (SendException e) {
                            throw new JobException("error on execute job", e);
                        }
                    });
        }

        return readCount;
    }

}
