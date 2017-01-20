/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates
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
 */

package org.openfact.testsuite.performance;

import org.apache.jmeter.samplers.SampleResult;
import org.apache.jorphan.logging.LoggingManager;
import org.apache.log.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.InvoiceModel;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author <a href="mailto:mposolda@redhat.com">Marek Posolda</a>
 */
public class ReadInvoicesWorker implements Worker {

    private static final Logger log = LoggingManager.getLoggerForClass();

    private static final int NUMBER_OF_ITERATIONS_IN_EACH_REPORT = 5000;

    // Total number of iterations read during whole test
    private static AtomicInteger totalIterationCounter = new AtomicInteger();

    // Reading invoices will always start from 1. Each worker thread needs to read invoices to single organization, which is dedicated just for this worker
    private int invoiceCounterInOrganization = 0;

    private int organizationsOffset;
    private int readInvoicesPerIteration;
    private int countOfInvoicesPerOrganization;

    private String organizationId;
    private int iterationNumber;

    @Override
    public void setup(int workerId, OpenfactSession session) {
        organizationsOffset = PerfTestUtils.readSystemProperty("openfact.perf.readInvoices.organizations.offset", Integer.class);
        readInvoicesPerIteration = PerfTestUtils.readSystemProperty("openfact.perf.readInvoices.readInvoicesPerIteration", Integer.class);
        countOfInvoicesPerOrganization = PerfTestUtils.readSystemProperty("openfact.perf.readInvoices.countOfInvoicesPerOrganization", Integer.class);

        int organizationNumber = organizationsOffset + workerId;
        organizationId = PerfTestUtils.getOrganizationName(organizationNumber);

        StringBuilder logBuilder = new StringBuilder("Read setup: ")
                .append("organizationsOffset=" + organizationsOffset)
                .append(", readInvoicesPerIteration=" + readInvoicesPerIteration)
                .append(", countOfInvoicesPerOrganization=" + countOfInvoicesPerOrganization)
                .append(", organizationId=" + organizationId);
        log.info(logBuilder.toString());
    }

    @Override
    public void run(SampleResult result, OpenfactSession session) {
        // We need to obtain organization first
        OrganizationModel organization = session.organizations().getOrganization(organizationId);
        if (organization == null) {
            throw new IllegalStateException("Organization '" + organizationId + "' not found");
        }

        int totalIterationNumber = totalIterationCounter.incrementAndGet();
        String lastInvoicename = null;

        for (int i=0 ; i<readInvoicesPerIteration ; i++) {
            ++invoiceCounterInOrganization;

            // Start reading invoices from 1
            if (invoiceCounterInOrganization > countOfInvoicesPerOrganization) {
                invoiceCounterInOrganization = 1;
            }

            String invoicename = PerfTestUtils.getInvoiceDocumentId(invoiceCounterInOrganization);
            lastInvoicename = invoicename;

            InvoiceModel invoice = session.invoices().getInvoiceByDocumentId(organization, invoicename);
        }

        log.info("Finished iteration " + ++iterationNumber + " in ReadInvoices test for " + organizationId + " worker. Last read invoice " + lastInvoicename  + " in organization: " + organizationId);

        int labelC = ((totalIterationNumber - 1) / NUMBER_OF_ITERATIONS_IN_EACH_REPORT) * NUMBER_OF_ITERATIONS_IN_EACH_REPORT;
        result.setSampleLabel("ReadInvoices " + (labelC + 1) + "-" + (labelC + NUMBER_OF_ITERATIONS_IN_EACH_REPORT));
    }

    @Override
    public void tearDown() {
    }
}
