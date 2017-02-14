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

import org.jboss.logging.Logger;
import org.openfact.models.*;
import org.openfact.models.enums.DestinyType;
import org.openfact.models.enums.RequiredAction;
import org.openfact.models.enums.SendEventStatus;
import org.openfact.services.managers.DocumentManager;
import org.openfact.models.SendEventModel;
import org.openfact.models.SendException;

import java.util.*;

public class SendToCustomerOrganizationScheduleTaskProvider implements OrganizationScheduleTaskProvider {

    private static final Logger logger = Logger.getLogger(SendToCustomerOrganizationScheduleTaskProvider.class);

    public static final String JOB_NAME = SendToCustomerOrganizationScheduleTaskProvider.class.getSimpleName();

    protected int retries;
    protected boolean isActive;

    public SendToCustomerOrganizationScheduleTaskProvider(boolean isActive, int retries) {
        this.isActive = isActive;
        this.retries = retries;
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

        readCount += sendDocuments(session, organization);

        long endTime = System.currentTimeMillis();

        // Save Report
        JobReportModel jobReportModel = session.jobReports().createJobReport(organization, JOB_NAME);

        // Metrics
        jobReportModel.setStartTime(startTime);
        jobReportModel.setEndTime(endTime);
        jobReportModel.setDuration(endTime - startTime);
        jobReportModel.setReadCount(readCount);
    }

    private long sendDocuments(OpenfactSession session, OrganizationModel organization) {
        long readCount = 0;

        ScrollModel<List<DocumentModel>> scroll = session.documents().createQuery(organization)
                .requiredAction(RequiredAction.SEND_TO_CUSTOMER).enabled(true).customerSendEventFailures(retries, false)
                .entityQuery().resultScroll().getScrollResultList(100);

        Iterator<List<DocumentModel>> iterator = scroll.iterator();
        while (iterator.hasNext()) {
            List<DocumentModel> document = iterator.next();

            readCount += document.size();

            document.stream().forEach(c -> {
                DocumentManager manager = new DocumentManager(session);
                SendEventModel sendEvent = c.addSendEvent(DestinyType.CUSTOMER);
                try {
                    manager.sendToCustomerParty(organization, c, sendEvent);
                    if (sendEvent.getResult().equals(SendEventStatus.SUCCESS)) {
                        c.removeRequiredAction(RequiredAction.SEND_TO_CUSTOMER);
                    }
                } catch (ModelInsuficientData e) {
                    sendEvent.setResult(SendEventStatus.ERROR);
                    sendEvent.setDescription(e.getMessage());
                } catch (SendException e) {
                    sendEvent.setResult(SendEventStatus.ERROR);
                    sendEvent.setDescription("Internal Server Error");
                    logger.error("Internal server error", e);
                }
            });
        }
        return readCount;
    }

}
