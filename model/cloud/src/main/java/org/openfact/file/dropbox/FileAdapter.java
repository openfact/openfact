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

import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import org.jboss.logging.Logger;
import org.openfact.file.FileModel;
import org.openfact.models.ModelReadOnlyException;
import org.openfact.models.OpenfactSession;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class FileAdapter implements FileModel {

    protected static final Logger logger = Logger.getLogger(FileAdapter.class);

    protected FileMetadata file;
    protected DbxClientV2 client;
    protected OpenfactSession session;

    public FileAdapter(OpenfactSession session, DbxClientV2 client, FileMetadata file) {
        this.session = session;
        this.client = client;
        this.file = file;
    }

    @Override
    public String getId() {
        return file.getName();
    }

    @Override
    public String getFileName() {
        return file.getName();
    }

    @Override
    public void setFileName(String fileName) {
        throw new ModelReadOnlyException("Is not posible to change the name");
    }

    @Override
    public byte[] getFile() {
        ByteArrayOutputStream os = null;
        try {
            DbxDownloader<FileMetadata> dbxDownloader = client.files().download(file.getPathLower());
            os = new ByteArrayOutputStream();
            dbxDownloader.download(os);
        } catch (DbxException e) {
            e.printStackTrace();
        } catch (IOException e) {

        }
        return os.toByteArray();
    }

}
