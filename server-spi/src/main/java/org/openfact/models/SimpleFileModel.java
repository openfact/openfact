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
package org.openfact.models;

public class SimpleFileModel implements FileModel{

    protected String fileName;
    protected String mimeType;
    protected byte[] file;

    public SimpleFileModel() {

    }

    public SimpleFileModel(String fileName, byte[] file) {
        this(fileName, file, null);
    }

    public SimpleFileModel(String fileName, byte[] file, String mimeType) {
        this.fileName = fileName;
        this.file = file;
        this.mimeType = mimeType;
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String getMimeType() {
        return mimeType;
    }

    @Override
    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    @Override
    public byte[] getFile() {
        return file;
    }

    @Override
    public void setFile(byte[] file) {
        this.file = file;
    }

}
