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

package org.openfact.ubl.template;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Locale;
import java.util.Properties;

/**
 * @author <a href="mailto:carlosthe19916@sistcoop.com">Carlos Feria</a>
 */
public interface Template {

    public String getName();


    public String getParentName();

    public String getImportName();

    public Type getType();

    public URL getTemplate(String name) throws IOException;

    public InputStream getTemplateAsStream(String name) throws IOException;

    public URL getResource(String path) throws IOException;

    public InputStream getResourceAsStream(String path) throws IOException;

    /**
     * Same as getMessages(baseBundlename, locale), but uses a default baseBundlename
     * such as "messages".
     *
     * @param locale The locale of the desired message bundle.
     * @return The localized messages from the bundle.
     * @throws IOException If bundle can not be read.
     */
    public Properties getMessages(Locale locale) throws IOException;

    /**
     * Retrieve localized messages from a message bundle.
     *
     * @param baseBundlename The base name of the bundle, such as "messages" in
     *                       messages_en.properties.
     * @param locale         The locale of the desired message bundle.
     * @return The localized messages from the bundle.
     * @throws IOException If bundle can not be read.
     */
    public Properties getMessages(String baseBundlename, Locale locale) throws IOException;

    public Properties getProperties() throws IOException;

    public enum Type {INVOICE, CREDIT_NOTE, DEBIT_NOTE}

}
