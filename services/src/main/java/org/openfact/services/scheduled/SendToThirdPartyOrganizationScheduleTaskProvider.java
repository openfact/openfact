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
import org.openfact.models.enums.SendResultType;
import org.openfact.services.managers.DocumentManager;
import org.openfact.models.SendEventModel;
import org.openfact.models.SendException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class SendToThirdPartyOrganizationScheduleTaskProvider implements OrganizationScheduleTaskProvider {

    private static final Logger logger = Logger.getLogger(SendToThirdPartyOrganizationScheduleTaskProvider.class);

    public static final String JOB_NAME = SendToThirdPartyOrganizationScheduleTaskProvider.class.getSimpleName();

    protected int retries;
    protected boolean isActive;

    public SendToThirdPartyOrganizationScheduleTaskProvider(boolean isActive, int retries) {
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

        ScrollModel<List<DocumentModel>> scroll = session.documents().getDocumentScroll(organization, 100, RequiredAction.SEND_TO_TRIRD_PARTY.toString());
        Iterator<List<DocumentModel>> iterator = scroll.iterator();

        while (iterator.hasNext()) {
            List<DocumentModel> invoices = iterator.next();

            readCount += invoices.size();

            invoices.stream()
                    .filter(p -> p.sendEventCount(new HashMap<String, String>() {{
                        put(DocumentModel.SEND_EVENT_DESTINY_TYPE, DestinyType.THIRD_PARTY.toString());
                    }}) < retries)
                    .forEach(c -> {
                        DocumentManager manager = new DocumentManager(session);
                        SendEventModel sendEvent = c.addSendEvent(DestinyType.THIRD_PARTY);
                        try {
                            manager.sendToThirdParty(organization, c, sendEvent);
                            if (sendEvent.getResult().equals(SendResultType.SUCCESS)) {
                                c.removeRequiredAction(RequiredAction.SEND_TO_TRIRD_PARTY);
                            }
                        } catch (ModelInsuficientData e) {
                            sendEvent.setResult(SendResultType.ERROR);
                            sendEvent.setDescription(e.getMessage());
                        } catch (SendException e) {
                            sendEvent.setResult(SendResultType.ERROR);
                            sendEvent.setDescription("Internal Server Error");
                            logger.error("Internal server error", e);
                        }
                    });
        }

        return readCount;
    }

}
