/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openfact.security;

import org.jboss.logging.Logger;

import javax.servlet.http.HttpServletRequest;

public abstract class AbstractSecurityContext implements SecurityContextProvider {

    public static final ThreadLocal<HttpServletRequest> servletRequest = new ThreadLocal<>();
    private static Logger logger = Logger.getLogger(AbstractSecurityContext.class);

    /**
     * Called to set the current context http servlet request.
     *
     * @param request
     */
    public static void setServletRequest(HttpServletRequest request) {
        servletRequest.set(request);
    }

    /**
     * Called to clear the context http servlet request.
     */
    public static void clearServletRequest() {
        servletRequest.remove();
    }

    @Override
    public String getRequestHeader(String headerName) {
        return servletRequest.get().getHeader(headerName);
    }
}
