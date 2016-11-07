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

package org.openfact.report;

import org.openfact.Config;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;

import java.io.File;

/**
 * @author <a href="mailto:carlosthe19916@sistcoop.com">Carlos Feria</a>
 */
public class FolderReportProviderFactory implements ReportThemeProviderFactory {

    private FolderReportProvider reportProvider;

    @Override
    public ReportThemeProvider create(OpenfactSession sessions) {
        return reportProvider;
    }

    @Override
    public void init(Config.Scope config) {
        String d = config.get("dir");
        File rootDir = null;
        if (d != null) {
            rootDir = new File(d);
        }
        reportProvider = new FolderReportProvider(rootDir);
    }

    @Override
    public void postInit(OpenfactSessionFactory factory) {

    }

    @Override
    public void close() {

    }

    @Override
    public String getId() {
        return "folder";
    }
}
