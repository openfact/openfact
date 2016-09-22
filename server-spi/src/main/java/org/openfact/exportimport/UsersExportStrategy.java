/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates
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
 */

package org.openfact.exportimport;

/**
 * @author <a href="mailto:mposolda@redhat.com">Marek Posolda</a>
 */
public enum UsersExportStrategy {
    SKIP,            // Exporting of users will be skipped completely
    ORGANIZATION_FILE,      // All users will be exported to same file with organization (So file like "foo-organization.json" with both organization data and users)
    SAME_FILE,       // All users will be exported to same file but different than organization (So file like "foo-organization.json" with organization data and "foo-users.json" with users)
    DIFFERENT_FILES  // Users will be exported into more different files according to maximum number of users per file
}
