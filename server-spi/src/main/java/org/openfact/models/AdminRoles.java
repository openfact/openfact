package org.openfact.models;

public class AdminRoles {

    public static String ADMIN = "admin";

    public static String CREATE_ORGANIZATION = "create-organization";

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
            MANAGE_ORGANIZATION, MANAGE_DOCUMENTS, MANAGE_EVENTS, MANAGE_FILES, MANAGE_REPORTS
    };

}
