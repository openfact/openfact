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

package org.openfact.services.util;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

/**
 * @author <a href="mailto:carlosthe19916@sistcoop.com">Carlos Feria</a>
 * @version $Revision: 1 $
 */
public class ResolveRelative {
    public static String resolveRelativeUri(URI requestUri, String rootUrl, String url) {
        if (url == null || !url.startsWith("/")) return url;
        if (rootUrl != null) {
            return rootUrl + url;
        } else {
            UriBuilder builder = UriBuilder.fromPath(url).host(requestUri.getHost());
            builder.scheme(requestUri.getScheme());
            if (requestUri.getPort() != -1) {
                builder.port(requestUri.getPort());
            }
            return builder.build().toString();
        }
    }
}
