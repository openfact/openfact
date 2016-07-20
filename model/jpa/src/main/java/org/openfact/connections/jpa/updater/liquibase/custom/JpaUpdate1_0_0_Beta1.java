package org.openfact.connections.jpa.updater.liquibase.custom;

import liquibase.exception.CustomChangeException;

public class JpaUpdate1_0_0_Beta1 extends CustomRepeidTask {

	@Override
	protected void generateStatementsImpl() throws CustomChangeException {

	}

	@Override
	protected String getTaskId() {
		return "Update 1.0.0.Beta1";
	}
}
