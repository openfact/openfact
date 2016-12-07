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
package org.openfact.models.dropbox;

import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.StorageFileModel;
import org.openfact.models.jpa.entities.*;

import javax.persistence.EntityManager;

public class StorageFileAdapter implements StorageFileModel {

    protected static final Logger logger = Logger.getLogger(StorageFileAdapter.class);

    protected FileMetadata file;
    protected DbxClientV2 client;
    protected OpenfactSession session;

    public StorageFileAdapter(OpenfactSession session, DbxClientV2 client, FileMetadata file) {
        this.session = session;
        this.client = client;
        this.file = file;
    }

    @Override
    public String getId() {
        return file.getId();
    }

    @Override
    public String getFileName() {
        return file.getName();
    }

    @Override
    public void setFileName(String fileName) {

    }

    @Override
    public String getMimeType() {
        return null;
    }

    @Override
    public void setMimeType(String mimeType) {

    }

    @Override
    public byte[] getFile() {
        return new byte[0];
    }

    @Override
    public void setFile(byte[] file) {

    }

}
