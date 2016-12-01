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

package org.openfact.exportimport.dir;

import org.openfact.exportimport.util.MultipleStepsExportProvider;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.util.JsonSerialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author <a href="mailto:mposolda@sistcoop.com">Marek Posolda</a>
 */
public class DirExportProvider extends MultipleStepsExportProvider {

    private final File rootDirectory;

    public DirExportProvider() {
        // Determine system tmp directory
        String tempDir = System.getProperty("java.io.tmpdir");

        this.rootDirectory = new File(tempDir + "/openfact-export");
        this.rootDirectory.mkdirs();

        logger.infof("Exporting into directory %s", this.rootDirectory.getAbsolutePath());
    }

    public DirExportProvider(File rootDirectory) {
        this.rootDirectory = rootDirectory;
        this.rootDirectory.mkdirs();

        logger.infof("Exporting into directory %s", this.rootDirectory.getAbsolutePath());
    }

    public static boolean recursiveDeleteDir(File dirPath) {
        if (dirPath.exists()) {
            File[] files = dirPath.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    recursiveDeleteDir(files[i]);
                } else {
                    files[i].delete();
                }
            }
        }
        if (dirPath.exists())
            return dirPath.delete();
        else
            return true;
    }

    @Override
    public void writeOrganization(String fileName, OrganizationRepresentation rep) throws IOException {
        File file = new File(this.rootDirectory, fileName);
        FileOutputStream stream = new FileOutputStream(file);
        JsonSerialization.prettyMapper.writeValue(stream, rep);
    }

    @Override
    public void close() {
    }

}
