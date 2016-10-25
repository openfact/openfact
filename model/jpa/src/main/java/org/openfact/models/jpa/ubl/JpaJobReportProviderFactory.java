package org.openfact.models.jpa.ubl;

import javax.persistence.EntityManager;

import org.openfact.Config.Scope;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.models.ubl.provider.JobReportProvider;
import org.openfact.models.ubl.provider.JobReportProviderFactory;

public class JpaJobReportProviderFactory implements JobReportProviderFactory {

	@Override
	public JobReportProvider create(OpenfactSession session) {
		EntityManager em = session.getProvider(JpaJobReportProvider.class).getEntityManager();
		return new JpaJobReportProvider(session, em);
	}

	@Override
	public void init(Scope config) {
	}

	@Override
	public void postInit(OpenfactSessionFactory factory) {
	}

	@Override
	public void close() {
	}

	@Override
	public String getId() {
		return "jpa";
	}

}
