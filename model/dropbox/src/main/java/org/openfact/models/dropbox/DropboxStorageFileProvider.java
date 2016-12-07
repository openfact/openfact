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

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import org.jboss.logging.Logger;
import org.openfact.models.*;
import org.openfact.models.utils.OpenfactModelUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DropboxStorageFileProvider implements StorageFileProvider {

    protected static final Logger logger = Logger.getLogger(DropboxStorageFileProvider.class);

    private static final String FILE_NAME = "fileName";

    private final OpenfactSession session;
    protected DbxClientV2 client;

    public DropboxStorageFileProvider(OpenfactSession session, DbxClientV2 client) {
        this.session = session;
        this.client = client;
    }

    @Override
    public void close() {
    }

    @Override
    public StorageFileModel createFile(OrganizationModel organization, String fileName, byte[] file) {
        InputStream is = new ByteArrayInputStream(file);
        FileMetadata fileMetadata;
        try {
           fileMetadata = client.files().upload(OpenfactModelUtils.generateCodeSecret()).uploadAndFinish(is);
        } catch (DbxException e) {
            throw new ModelException("Could not create file", e);
        } catch (IOException e) {
            throw new ModelException("Could not create file", e);
        }
        return new StorageFileAdapter(session, client, fileMetadata);
    }

    @Override
    public StorageFileModel getFileById(OrganizationModel organization, String id) {
        return null;
    }

    @Override
    public List<StorageFileModel> getFiles(OrganizationModel organization) {
        return null;
    }

    @Override
    public List<StorageFileModel> getFiles(OrganizationModel organization, Integer firstResult, Integer maxResults) {
        return null;
    }

    @Override
    public boolean removeFile(OrganizationModel organization, String id) {
        return false;
    }

    @Override
    public boolean removeFile(OrganizationModel organization, StorageFileModel file) {
        return false;
    }
}
