package org.openfact.models;

import org.openfact.services.resource.security.Resource;

public class AdminRoles {

    public static final String ADMIN = "admin";

    public static final String CREATE_ORGANIZATION = "create-organization";

    public static final String VIEW_ORGANIZATION = "view-organization";
    public static final String VIEW_DOCUMENTS = "view-documents";
    public static final String VIEW_EVENTS = "view-events";

    public static final String MANAGE_ORGANIZATION = "manage-organization";
    public static final String MANAGE_DOCUMENTS = "manage-documents";
    public static final String MANAGE_EVENTS = "manage-events";

    public static final String[] ALL_ORGANIZATION_ROLES = {
            /*
             * */
            CREATE_ORGANIZATION,

            /*
             * */
            VIEW_ORGANIZATION, VIEW_DOCUMENTS, VIEW_EVENTS,

            /*
             * */
            MANAGE_ORGANIZATION, MANAGE_DOCUMENTS, MANAGE_EVENTS,
    };

    public static String getViewRole(Resource resource) {
        switch (resource) {
            case ORGANIZATION:
                return AdminRoles.VIEW_ORGANIZATION;
            case DOCUMENT:
                return AdminRoles.VIEW_DOCUMENTS;
            case EVENTS:
                return AdminRoles.VIEW_EVENTS;
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
            default:
                throw new IllegalStateException();
        }
    }

}
