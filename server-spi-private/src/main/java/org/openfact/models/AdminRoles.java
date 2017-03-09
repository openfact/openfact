package org.openfact.models;

import org.openfact.services.resource.security.Resource;

public class AdminRoles {

    public static final String ADMIN = "admin";

    public static final String CREATE_ORGANIZATION = "create-organization";

    public static final String VIEW_ORGANIZATION = "view-organization";
    public static final String VIEW_DOCUMENTS = "view-documents";
    public static final String VIEW_EVENTS = "view-events";
    public static final String VIEW_FILES = "view-files";
    public static final String VIEW_REPORTS = "view-reports";

    public static final String MANAGE_ORGANIZATION = "manage-organization";
    public static final String MANAGE_DOCUMENTS = "manage-documents";
    public static final String MANAGE_EVENTS = "manage-events";
    public static final String MANAGE_FILES = "manage-files";
    public static final String MANAGE_REPORTS = "manage-reports";

    public static final String[] ALL_ORGANIZATION_ROLES = {
            /**
             * */
            VIEW_ORGANIZATION, VIEW_DOCUMENTS, VIEW_EVENTS, VIEW_FILES, VIEW_REPORTS,

            /**
             * */
            MANAGE_ORGANIZATION, MANAGE_DOCUMENTS, MANAGE_EVENTS, MANAGE_FILES, MANAGE_REPORTS
    };

    public static String getViewRole(Resource resource) {
        switch (resource) {
            case ORGANIZATION:
                return AdminRoles.VIEW_ORGANIZATION;
            case DOCUMENT:
                return AdminRoles.VIEW_DOCUMENTS;
            case EVENTS:
                return AdminRoles.VIEW_EVENTS;
            case FILES:
                return AdminRoles.VIEW_FILES;
            case REPORTS:
                return AdminRoles.VIEW_REPORTS;
            default:
                throw new IllegalStateException();
        }
    }

    public static String getManageRole(Resource resource) {
        switch (resource) {
            case ORGANIZATION:
                return AdminRoles.MANAGE_ORGANIZATION;
            case DOCUMENT:
                return AdminRoles.MANAGE_DOCUMENTS;
            case EVENTS:
                return AdminRoles.MANAGE_EVENTS;
            case FILES:
                return AdminRoles.MANAGE_FILES;
            case REPORTS:
                return AdminRoles.MANAGE_REPORTS;
            default:
                throw new IllegalStateException();
        }
    }

}
