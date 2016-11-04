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
package org.openfact.subsystem.server.logging;

import org.jboss.logging.BasicLogger;
import org.jboss.logging.Logger;
import org.jboss.logging.annotations.MessageLogger;

/**
 * This interface to be fleshed out later when error messages are fully externalized.
 *
 * @author Stan Silvert ssilvert@sistcoop.com (C) 2013 Red Hat Inc.
 */
@MessageLogger(projectCode = "OPENFACT")
public interface OpenfactLogger extends BasicLogger {

    /**
     * A logger with a category of the package name.
     */
    OpenfactLogger ROOT_LOGGER = Logger.getMessageLogger(OpenfactLogger.class, "org.jboss.openfact");
}
