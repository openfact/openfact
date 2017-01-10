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
package org.openfact.file.dropbox;

import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import org.openfact.Config;
import org.openfact.file.FileProvider;
import org.openfact.file.FileProviderFactory;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;

public class DropboxFileProviderFactory implements FileProviderFactory {

    protected DbxClientV2 dbxClient;

    @Override
    public FileProvider create(OpenfactSession session) {
        return new DropboxFileProvider(session, dbxClient);
    }

    @Override
    public void init(Config.Scope config) {
        DbxRequestConfig dbxConfig = DbxRequestConfig.newBuilder("openfact").build();
        dbxClient = new DbxClientV2(dbxConfig, config.get("accessToken"));
    }

    @Override
    public void postInit(OpenfactSessionFactory factory) {
    }

    @Override
    public void close() {
        dbxClient = null;
    }

    @Override
    public String getId() {
        return "dropbox";
    }

}
