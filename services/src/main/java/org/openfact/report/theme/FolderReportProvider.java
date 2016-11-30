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

package org.openfact.report.theme;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.openfact.report.ReportTheme;
import org.openfact.report.ReportThemeProvider;
import org.openfact.report.ReportTheme.Type;

/**
 * @author <a href="mailto:carlosthe19916@sistcoop.com">Carlos Feria</a>
 */
public class FolderReportProvider implements ReportThemeProvider {

    private File templatesDir;

    public FolderReportProvider(File templatesDir) {
        this.templatesDir = templatesDir;
    }

    @Override
    public int getProviderPriority() {
        return 100;
    }

    @Override
    public ReportTheme getReportTheme(String name, ReportTheme.Type type) throws IOException {
        File templateDir = getTemplateDir(name, type);
        return templateDir.isDirectory() ? new FolderReport(templateDir, name, type) : null;
    }

    @Override
    public Set<String> nameSet(ReportTheme.Type type) {
        final String typeName = type.name().toLowerCase();
        File[] templateDirs = templatesDir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory() && new File(pathname, typeName).isDirectory();
            }
        });
        if (templateDirs != null) {
            Set<String> names = new HashSet<String>();
            for (File templateDir : templateDirs) {
                names.add(templateDir.getName());
            }
            return names;
        } else {
            return Collections.emptySet();
        }
    }

    @Override
    public boolean hasReportTheme(String name, ReportTheme.Type type) {
        return getTemplateDir(name, type).isDirectory();
    }

    @Override
    public void close() {
    }

    private File getTemplateDir(String name, ReportTheme.Type type) {
        return new File(templatesDir, name + File.separator + type.name().toLowerCase());
    }

}
