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
public class CreateInvoicesWorker implements Worker {

    private static final Logger log = LoggingManager.getLoggerForClass();

    private static final int NUMBER_OF_INVOICES_IN_EACH_REPORT = 5000;

    // Total number of invoices created during whole test
    private static AtomicInteger totalInvoiceCounter = new AtomicInteger();

    // Adding invoices will always start from 1. Each worker thread needs to add invoices to single organization, which is dedicated just for this worker
    private int invoiceCounterInOrganization = 0;
    private String organizationId;

    private int organizationsOffset;
    private boolean addBasicInvoiceAttributes;

    @Override
    public void setup(int workerId, OpenfactSession session) {
        organizationsOffset = PerfTestUtils.readSystemProperty("openfact.perf.createInvoices.organizations.offset", Integer.class);
        addBasicInvoiceAttributes = PerfTestUtils.readSystemProperty("openfact.perf.createInvoices.addBasicInvoiceAttributes", Boolean.class);

        int organizationNumber = organizationsOffset + workerId;
        organizationId = PerfTestUtils.getOrganizationName(organizationNumber);

        StringBuilder logBuilder = new StringBuilder("Read setup: ")
                .append("organizationsOffset=" + organizationsOffset)
                .append(", addBasicInvoiceAttributes=" + addBasicInvoiceAttributes)
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

        int invoiceNumber = ++invoiceCounterInOrganization;
        int totalInvoiceNumber = totalInvoiceCounter.incrementAndGet();

        String invoicename = PerfTestUtils.getInvoiceDocumentId(invoiceNumber);

        InvoiceModel invoice = session.invoices().addInvoice(organization, invoicename);

        // Add basic invoice attributes (NOTE: Actually backend is automatically upgraded during each setter call)
        if (addBasicInvoiceAttributes) {
            invoice.setDocumentCurrencyCode("PEN");
            invoice.setCustomerRegistrationName(invoicename + "CUSTOMER NAME");
            invoice.setCustomerElectronicMail(invoicename + "@email.com");
        }

        log.info("Finished creation of invoice " + invoicename + " in organization: " + organization.getId());

        int labelC = ((totalInvoiceNumber - 1) / NUMBER_OF_INVOICES_IN_EACH_REPORT) * NUMBER_OF_INVOICES_IN_EACH_REPORT;
        result.setSampleLabel("CreateInvoices " + (labelC + 1) + "-" + (labelC + NUMBER_OF_INVOICES_IN_EACH_REPORT));
    }

    @Override
    public void tearDown() {
    }
}
