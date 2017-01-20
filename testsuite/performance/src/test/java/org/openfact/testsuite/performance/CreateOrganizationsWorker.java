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
import org.openfact.services.managers.OrganizationManager;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author <a href="mailto:mposolda@redhat.com">Marek Posolda</a>
 */
public class CreateOrganizationsWorker implements Worker {

    private static final Logger log = LoggingManager.getLoggerForClass();

    private static final int NUMBER_OF_ORGANIZATIONS_IN_EACH_REPORT = 100;

    private static AtomicInteger organizationCounter = new AtomicInteger(0);

    private int offset;
    private boolean createRequiredCredentials;

    @Override
    public void setup(int workerId, OpenfactSession session) {
        offset = PerfTestUtils.readSystemProperty("openfact.perf.createOrganizations.organizations.offset", Integer.class);
        createRequiredCredentials = PerfTestUtils.readSystemProperty("openfact.perf.createOrganizations.createRequiredCredentials", Boolean.class);

        organizationCounter.compareAndSet(0, offset);

        StringBuilder logBuilder = new StringBuilder("Read setup: ")
                .append("offset=" + offset)
                .append(", createRequiredCredentials=" + createRequiredCredentials);
        log.info(logBuilder.toString());
    }

    @Override
    public void run(SampleResult result, OpenfactSession session) {
        int organizationNumber = organizationCounter.getAndIncrement();
        String organizationName = PerfTestUtils.getOrganizationName(organizationNumber);
        OrganizationManager organizationManager = new OrganizationManager(session);
        OrganizationModel organization = organizationManager.createOrganization(organizationName, organizationName);

        log.info("Finished creation of organization " + organizationName);

        int labelC = ((organizationNumber - 1) / NUMBER_OF_ORGANIZATIONS_IN_EACH_REPORT) * NUMBER_OF_ORGANIZATIONS_IN_EACH_REPORT;
        result.setSampleLabel("CreateOrganizations " + (labelC + 1) + "-" + (labelC + NUMBER_OF_ORGANIZATIONS_IN_EACH_REPORT));
    }

    @Override
    public void tearDown() {
    }

}
