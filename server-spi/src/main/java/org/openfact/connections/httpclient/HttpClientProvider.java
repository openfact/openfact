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

package org.openfact.connections.httpclient;

import org.apache.http.client.HttpClient;
import org.openfact.provider.Provider;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author <a href="mailto:carlosthe19916@sistcoop.com">Carlos Feria</a>
 */
public interface HttpClientProvider extends Provider {
    HttpClient getHttpClient();

    /**
     * Helper method
     *
     * @param uri
     * @param text
     * @return http response status
     * @throws IOException
     */
    public int postText(String uri, String text) throws IOException;

    /**
     * Helper method
     *
     * @param uri
     * @return response stream, you must close this stream or leaks will happen
     * @throws IOException
     */
    public InputStream get(String uri) throws IOException;
}
