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

package org.openfact.report;

import org.openfact.Config;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Stateless
@ReportThemeManagerSelector
@ReportProviderType(type = ReportProviderType.ProviderType.FOLDER)
public class FolderReportThemeProvider implements ReportThemeProvider {

    private File themesDir;

    @PostConstruct
    public void init() {
        String d = Config.scope("report", "folder").get("dir");
        File rootDir = null;
        if (d != null) {
            rootDir = new File(d);
        }
        this.themesDir = rootDir;
    }

    @Override
    public int getProviderPriority() {
        return 100;
    }

    @Override
    public ReportTheme getTheme(String name, ReportTheme.Type type) throws IOException {
        File themeDir = getThemeDir(name, type);
        return themeDir.isDirectory() ? new FolderReportTheme(themeDir, name, type) : null;
    }

    @Override
    public Set<String> nameSet(ReportTheme.Type type) {
        final String typeName = type.name().toLowerCase();
        File[] themeDirs = themesDir.listFiles(pathname -> pathname.isDirectory() && new File(pathname, typeName).isDirectory());
        if (themeDirs != null) {
            Set<String> names = new HashSet<String>();
            for (File themeDir : themeDirs) {
                names.add(themeDir.getName());
            }
            return names;
        } else {
            return Collections.emptySet();
        }
    }

    @Override
    public boolean hasTheme(String name, ReportTheme.Type type) {
        return getThemeDir(name, type).isDirectory();
    }

    private File getThemeDir(String name, ReportTheme.Type type) {
        return new File(themesDir, name + File.separator + type.name().toLowerCase());
    }

}
