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
package org.openfact.models.jpa.ubl;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.AbstractHibernateStorage;
import org.openfact.models.jpa.OrganizationAdapter;
import org.openfact.models.jpa.entities.ubl.JobReportEntity;
import org.openfact.models.ubl.JobReportModel;
import org.openfact.models.ubl.provider.JobReportProvider;

public class JpaJobReportProvider extends AbstractHibernateStorage implements JobReportProvider {

	protected static final Logger logger = Logger.getLogger(JpaJobReportProvider.class);

	private final OpenfactSession session;
	protected EntityManager em;

	public JpaJobReportProvider(OpenfactSession session, EntityManager em) {
		this.session = session;
		this.em = em;
	}

	@Override
	public void close() {
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	@Override
	public JobReportModel createJobReport(OrganizationModel organization, String jobName) {
		JobReportEntity jobReport = new JobReportEntity();
		jobReport.setJobName(jobName);
		jobReport.setOrganization(OrganizationAdapter.toEntity(organization, em));
		em.persist(jobReport);
		em.flush();

		final JobReportModel adapter = new JobReportAdapter(session, organization, em, jobReport);
		return adapter;
	}

	@Override
	public JobReportModel createJobReport(OrganizationModel organization, String jobName, String documentType) {
		JobReportEntity jobReport = new JobReportEntity();
		jobReport.setJobName(jobName);
		jobReport.setDocumentType(documentType);
		jobReport.setOrganization(OrganizationAdapter.toEntity(organization, em));
		em.persist(jobReport);
		em.flush();

		final JobReportModel adapter = new JobReportAdapter(session, organization, em, jobReport);
		return adapter;
	}

}
