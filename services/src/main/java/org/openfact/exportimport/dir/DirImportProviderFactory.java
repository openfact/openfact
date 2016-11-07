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

package org.openfact.exportimport.dir;

import org.openfact.Config;
import org.openfact.exportimport.ExportImportConfig;
import org.openfact.exportimport.ImportProvider;
import org.openfact.exportimport.ImportProviderFactory;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;

import java.io.File;

/**
 * @author <a href="mailto:mposolda@sistcoop.com">Marek Posolda</a>
 */
public class DirImportProviderFactory implements ImportProviderFactory {

    @Override
    public ImportProvider create(OpenfactSession session) {
        String dir = ExportImportConfig.getDir();
        return dir != null ? new DirImportProvider(new File(dir)) : new DirImportProvider();
    }

    @Override
    public void init(Config.Scope config) {
    }

    @Override
    public void postInit(OpenfactSessionFactory factory) {

    }

    @Override
    public void close() {
    }

    @Override
    public String getId() {
        return DirExportProviderFactory.PROVIDER_ID;
    }
}
