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
