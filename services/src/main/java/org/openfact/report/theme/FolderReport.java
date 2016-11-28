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

package org.openfact.report.theme;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Properties;

import org.openfact.report.ReportTheme;
import org.openfact.report.ReportTheme.Type;

/**
 * @author <a href="mailto:carlosthe19916@sistcoop.com">Carlos Feria</a>
 */
public class FolderReport implements ReportTheme {

    private final Properties properties;
    private File templateDir;
    private File resourcesDir;
    private String name;
    private Type type;

    public FolderReport(File templateDir, String name, Type type) throws IOException {
        this.templateDir = templateDir;
        this.name = name;
        this.type = type;
        this.properties = new Properties();

        resourcesDir = new File(templateDir, "resources");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public URL getTemplate(String name) throws IOException {
        File file = new File(templateDir, name);
        return file.isFile() ? file.toURI().toURL() : null;
    }

    @Override
    public InputStream getTemplateAsStream(String name) throws IOException {
        URL url = getTemplate(name);
        return url != null ? url.openStream() : null;
    }

    @Override
    public URL getResource(String path) throws IOException {
        if (File.separatorChar != '/') {
            path = path.replace('/', File.separatorChar);
        }

        File file = new File(resourcesDir, path);
        if (!file.isFile() || !file.getCanonicalPath().startsWith(resourcesDir.getCanonicalPath())) {
            return null;
        } else {
            return file.toURI().toURL();
        }
    }

    @Override
    public InputStream getResourceAsStream(String path) throws IOException {
        URL url = getResource(path);
        return url != null ? url.openStream() : null;
    }

    @Override
    public Properties getMessages(Locale locale) throws IOException {
        return getMessages("messages", locale);
    }

    @Override
    public Properties getMessages(String baseBundlename, Locale locale) throws IOException {
        if (locale == null) {
            return null;
        }

        Properties m = new Properties();

        File file = new File(templateDir, "messages" + File.separator + baseBundlename + "_" + locale.toString() + ".properties");
        if (file.isFile()) {
            Charset encoding = PropertiesUtil.detectEncoding(new FileInputStream(file));
            try (Reader reader = new InputStreamReader(new FileInputStream(file), encoding)) {
                m.load(reader);
            }
        }
        return m;
    }

    @Override
    public Properties getProperties() {
        return properties;
    }
}