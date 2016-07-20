package org.openfact.connections.jpa.updater.liquibase.custom;

import liquibase.exception.CustomChangeException;

public class JpaUpdate1_1_0_Final extends CustomOpenfactTask {

	@Override
	protected void generateStatementsImpl() throws CustomChangeException {

	}

	@Override
	protected String getTaskId() {
		return "Update 1.1.0.Final";
	}
}
