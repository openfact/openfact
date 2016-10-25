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
