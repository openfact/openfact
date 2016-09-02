package org.openfact.models;

public class AdminRoles {

    public static String APP_SUFFIX = "-organization";

    public static String ADMIN = "admin";

    // for admin client local to each organization
    public static String ORGANIZATION_ADMIN = "organization-admin";

    public static String CREATE_ORGANIZATION = "create-organization";
    public static String CREATE_DOCUMENT = "create-document";
    public static String CREATE_INVOICE = "create-invoice";

    public static String VIEW_ORGANIZATION = "view-organization";
    public static String VIEW_DOCUMENTS = "view-document";
    public static String VIEW_INVOICE = "view-invoice";

    public static String MANAGE_ORGANIZATION = "manage-organization";
    public static String MANAGE_DOCUMENT = "manage-document";
    public static String MANAGE_INVOICE = "manage-invoice";

    public static String CREATE_CERTIFIED = "create-certified";
    public static String VIEW_CERTIFIED = "view-certified";

    public static String[] ALL_ORGANIZATION_ROLES = { CREATE_ORGANIZATION, CREATE_DOCUMENT, CREATE_INVOICE,
            VIEW_ORGANIZATION, VIEW_DOCUMENTS, VIEW_INVOICE, MANAGE_ORGANIZATION, MANAGE_DOCUMENT,
            MANAGE_INVOICE };

}
