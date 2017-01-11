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
import com.dropbox.core.v2.files.Metadata;
import org.jboss.logging.Logger;
import org.openfact.file.FileModel;
import org.openfact.models.ModelException;
import org.openfact.models.ModelReadOnlyException;
import org.openfact.models.OpenfactSession;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class FileAdapter implements FileModel {

    protected static final Logger logger = Logger.getLogger(FileAdapter.class);

    protected FileMetadata file;
    protected DbxClientV2 client;
    protected OpenfactSession session;
    protected DropboxFileProvider provider;

    public FileAdapter(OpenfactSession session, DropboxFileProvider provider, DbxClientV2 client, FileMetadata file) {
        this.session = session;
        this.client = client;
        this.file = file;
        this.provider = provider;
    }

    @Override
    public String getId() {
        return file.getPathLower();
    }

    @Override
    public String getFileName() {
        return file.getName();
    }

    @Override
    public void setFileName(String fileName) {
        String newPath = file.getPathLower().substring(0, file.getPathLower().indexOf("/")) + fileName;
        try {
            FileMetadata fileMetadata = (FileMetadata) client.files().move(file.getPathLower(), newPath);
            file = fileMetadata;
            provider.getTx().remove(fileMetadata);
        } catch (DbxException e) {
            throw new ModelException("Could not change name file", e);
        }
    }

    @Override
    public byte[] getFile() {
        ByteArrayOutputStream os = null;
        try {
            DbxDownloader<FileMetadata> dbxDownloader = client.files().download(file.getPathLower());
            os = new ByteArrayOutputStream();
            dbxDownloader.download(os);
        } catch (DbxException e) {
            throw new ModelException("Could read file from dropbox", e);
        } catch (IOException e) {
            throw new ModelException("Could not load file", e);
        }
        return os.toByteArray();
    }

    @Override
    public String getExtension() {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1) {
            return fileName.substring(fileName.lastIndexOf("."), fileName.length());
        } else {
            return "";
        }
    }

}
