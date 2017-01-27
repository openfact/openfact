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

/**
 * @author <a href="mailto:carlosthe19916@sistcoop.com">Carlos Feria</a>
 */
public class AdminRoles {

    public static String APP_SUFFIX = "-organization";

    public static String ADMIN = "admin";

    public static String VIEW_ORGANIZATION = "view-organization";
    public static String VIEW_DOCUMENTS = "view-documents";
    public static String VIEW_EVENTS = "view-events";
    public static String VIEW_FILES = "view-files";
    public static String VIEW_REPORTS = "view-reports";

    public static String MANAGE_ORGANIZATION = "manage-organization";
    public static String MANAGE_DOCUMENTS = "manage-documents";
    public static String MANAGE_EVENTS = "manage-events";
    public static String MANAGE_FILES = "manage-files";
    public static String MANAGE_REPORTS = "manage-reports";

    public static String[] ALL_ORGANIZATION_ROLES = {
            /**
             * */
            VIEW_ORGANIZATION, VIEW_DOCUMENTS, VIEW_EVENTS, VIEW_FILES, VIEW_REPORTS,

            /**
             * */
            MANAGE_ORGANIZATION, MANAGE_DOCUMENTS, MANAGE_EVENTS, MANAGE_FILES, MANAGE_REPORTS};

}
