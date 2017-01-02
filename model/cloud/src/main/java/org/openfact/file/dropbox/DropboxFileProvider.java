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
import org.openfact.file.*;
import org.openfact.file.FileModel;
import org.openfact.models.*;
import org.openfact.models.utils.OpenfactModelUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class DropboxFileProvider implements FileProvider {

    protected static final Logger log = Logger.getLogger(DropboxFileProvider.class);

    private static final String FILE_NAME = "fileName";

    protected final OpenfactSession session;
    protected final DbxClientV2 client;
    protected final DropboxOpenfactTransaction tx;

    public DropboxFileProvider(OpenfactSession session, DbxClientV2 client) {
        this.session = session;
        this.client = client;
        this.tx = new DropboxOpenfactTransaction();

        session.getTransactionManager().enlist(tx);
    }

    private String buildFileName(OrganizationModel organizationModel, String fileName) {
        return "/" + organizationModel.getId() + "/" + fileName;
    }

    @Override
    public void close() {
    }

    @Override
    public FileModel createFile(OrganizationModel organization, String fileName, byte[] bytes) {
        InputStream is = new ByteArrayInputStream(bytes);
        FileMetadata fileMetadata;
        try {
            String pathName = buildFileName(organization, fileName);
            fileMetadata = client.files().uploadBuilder(pathName).uploadAndFinish(is);
            tx.put(fileMetadata);
        } catch (DbxException e) {
            throw new ModelException("Could not upload file", e);
        } catch (IOException e) {
            throw new ModelException("Could not create file", e);
        }
        return new FileAdapter(session, client, fileMetadata);
    }

    @Override
    public FileModel getFileById(OrganizationModel organization, String id) {
        return getFileByFileName(organization, id);
    }

    @Override
    public FileModel getFileByFileName(OrganizationModel organization, String fileName) {
        FileMetadata fileMetadata;
        try {
            DbxDownloader<FileMetadata> dbxDownloader = client.files().download(buildFileName(organization, fileName));
            fileMetadata = dbxDownloader.getResult();
        } catch (DbxException e) {
            throw new ModelException("Could not read file from dropbox", e);
        }
        return new FileAdapter(session, client, fileMetadata);
    }

    @Override
    public boolean removeFile(OrganizationModel organization, FileModel file) {
        try {
            FileMetadata fileMetadata = (FileMetadata) client.files().delete(buildFileName(organization, file.getFileName()));
            tx.remove(fileMetadata);
        } catch (DbxException e) {
            throw new ModelException("Could not delete file", e);
        }
        return true;
    }

    class DropboxOpenfactTransaction implements OpenfactTransaction {

        private boolean active;
        private boolean rollback;
        private Map<Object, FileTask> tasks = new HashMap<>();

        @Override
        public void begin() {
            active = true;
        }

        @Override
        public void commit() {
            if (rollback) {
                throw new RuntimeException("Rollback only!");
            }

            for (FileTask task : tasks.values()) {
                task.execute();
            }
        }

        @Override
        public void rollback() {
            try {
                for (FileTask task : tasks.values()) {
                    task.executeRollback();
                }
            } catch (DbxException e) {
                throw new RuntimeException("Rollback exception!", e);
            }
            tasks.clear();
        }

        @Override
        public void setRollbackOnly() {
            rollback = true;
        }

        @Override
        public boolean getRollbackOnly() {
            return rollback;
        }

        @Override
        public boolean isActive() {
            return active;
        }

        public void put(FileMetadata fileMetadata) {
            log.tracev("Adding file operation: {0} on {1}", FileOperation.ADD, fileMetadata.getName());

            Object taskKey = getTaskKey(fileMetadata);
            if (tasks.containsKey(taskKey)) {
                throw new IllegalStateException("Can't add session: task in progress for session");
            } else {
                tasks.put(taskKey, new FileTask(fileMetadata, FileOperation.ADD));
            }
        }

        public void remove(FileMetadata fileMetadata) {
            log.tracev("Adding file operation: {0} on {1}", FileOperation.REMOVE, fileMetadata.getName());

            Object taskKey = getTaskKey(fileMetadata);
            tasks.put(taskKey, new FileTask(fileMetadata, FileOperation.REMOVE));
        }

        private Object getTaskKey(FileMetadata fileMetadata) {
            return fileMetadata.getId();
        }

        public class FileTask {
            private FileMetadata file;
            private FileOperation operation;

            public FileTask(FileMetadata file, FileOperation operation) {
                this.file = file;
                this.operation = operation;
            }

            public void execute() {
                log.tracev("Executing file operation: {0} on {1}", operation, file.getName());
            }

            public void executeRollback() throws DbxException {
                log.tracev("Executing file operation: {0} on {1}", operation, file.getName());

                switch (operation) {
                    case ADD:
                        client.files().delete(file.getPathLower());
                        break;
                    case REMOVE:
                        client.files().restore(file.getName(), file.getRev());
                        break;
                }
            }
        }
    }

    public enum FileOperation {
        ADD, REMOVE
    }

}
