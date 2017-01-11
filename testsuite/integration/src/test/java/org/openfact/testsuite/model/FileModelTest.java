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

package org.openfact.testsuite.model;

import com.google.common.collect.ImmutableMap;
import org.junit.Assert;
import org.junit.Test;
import org.openfact.file.FileModel;
import org.openfact.file.FileProvider;
import org.openfact.file.InternetMediaType;
import org.openfact.models.*;
import org.openfact.models.enums.DestinyType;
import org.openfact.models.enums.DocumentType;
import org.openfact.models.enums.RequiredAction;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

import static org.junit.Assert.assertNotNull;

/**
 * @author <a href="mailto:carlosthe19916@sistcoop.com">Carlos Feria</a>
 */
public class FileModelTest extends AbstractModelTest {

    @Test
    public void persistFile() {
        OrganizationModel organization = organizationManager.createOrganization("original");
        OpenfactSession session = organizationManager.getSession();
        FileModel file = session.getProvider(FileProvider.class).createFile(organization, "file1", new byte[]{1,2,3});
        String fileId = file.getId();

        Assert.assertNotNull(file);
        Assert.assertEquals(file.getExtension(), "");

        file.setFileName("file1.xml");
        commit();

        session = organizationManager.getSession();
        file = session.getProvider(FileProvider.class).getFileById(organization, fileId);

        Assert.assertEquals(file.getFileName(), "file1.xml");
        Assert.assertEquals(file.getExtension(), ".xml");
        assertNotNull(file.getFile());

        OrganizationModel searchOrganization = organizationManager.getOrganization(organization.getId());
        FileModel persisted = session.getProvider(FileProvider.class).getFileByFileName(searchOrganization, "file1.xml");

        Assert.assertNotNull(persisted);
        assertEquals(file, persisted);

        searchOrganization = organizationManager.getOrganization(organization.getId());
        FileModel persisted2 = session.getProvider(FileProvider.class).getFileById(searchOrganization, file.getId());
        assertEquals(file, persisted2);
    }

    public static void assertEquals(FileModel expected, FileModel actual) {
        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getFileName(), actual.getFileName());
        Assert.assertEquals(expected.getExtension(), actual.getExtension());
        Assert.assertEquals(expected.getFile(), actual.getFile());
    }

}
