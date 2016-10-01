package org.openfact.models.jpa.catalog;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.catalog.provider.ConditionCatalogProvider;
import org.openfact.models.catalog.provider.InstructionIdCatalogProvider;

public class JpaInstructionIdCatalogProvider implements InstructionIdCatalogProvider {
	protected static final Logger logger = Logger.getLogger(JpaInstructionIdCatalogProvider.class);
	private final OpenfactSession session;
	protected EntityManager em;

	public JpaInstructionIdCatalogProvider(OpenfactSession session, EntityManager em) {
		this.session = session;
		this.em = em;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

}
