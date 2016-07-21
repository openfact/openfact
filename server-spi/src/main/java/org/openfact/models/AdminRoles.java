package org.openfact.models;

public class AdminRoles {

    public static String APP_SUFFIX = "-organization";

    public static String ADMIN = "admin";

    // for admin client local to each organization
    public static String ORGANIZATION_ADMIN = "organization-admin";

    public static String CREATE_ORGANIZATION = "create-organization";
    public static String CREATE_CLIENT = "create-client";

    public static String VIEW_ORGANIZATION = "view-organization";
    public static String VIEW_DOCUMENTS = "view-users";

    public static String MANAGE_ORGANIZATION = "manage-organization";
    public static String MANAGE_DOCUMENTS = "manage-documents";    

    public static String[] ALL_ORGANIZATION_ROLES = {CREATE_CLIENT, VIEW_ORGANIZATION, VIEW_DOCUMENTS, MANAGE_ORGANIZATION, MANAGE_DOCUMENTS};

}
