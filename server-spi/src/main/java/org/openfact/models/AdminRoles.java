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

package org.openfact.models;

/**
 * @author <a href="mailto:sthorger@redhat.com">Stian Thorgersen</a>
 */
public class AdminRoles {

    public static String APP_SUFFIX = "-organization";

    public static String ADMIN = "admin";

    // for admin each organization
    public static String ORGANIZATION_ADMIN = "organization-admin";

    public static String CREATE_ORGANIZATION = "create-organization";

    public static String VIEW_ORGANIZATION = "view-organization";
    public static String VIEW_INVOICES = "view-invoices";
    public static String VIEW_CREDIT_NOTES = "view-credit-notes";
    public static String VIEW_DEBIT_NOTES = "view-debit-notes";
    public static String VIEW_EVENTS = "view-events";

    public static String MANAGE_ORGANIZATION = "manage-organization";
    public static String MANAGE_INVOICES = "manage-invoices";
    public static String MANAGE_CREDIT_NOTES = "manage-credit-notes";
    public static String MANAGE_DEBIT_NOTES = "manage-debit-notes";
    public static String MANAGE_EVENTS = "manage-events";

    public static String[] ALL_ORGANIZATION_ROLES = {
            /**
             * */
            VIEW_EVENTS, VIEW_INVOICES, VIEW_CREDIT_NOTES, VIEW_DEBIT_NOTES,

            /**
             * */
            MANAGE_ORGANIZATION, MANAGE_INVOICES, MANAGE_CREDIT_NOTES, MANAGE_DEBIT_NOTES, MANAGE_EVENTS };

}
