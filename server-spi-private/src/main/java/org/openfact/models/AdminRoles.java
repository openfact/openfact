package org.openfact.models;

public class AdminRoles {

    public static String ADMIN = "admin";

    public static String VIEW_ORGANIZATION = "view-organization";
    public static String VIEW_INVOICES = "view-documents";
    public static String VIEW_CREDIT_NOTES = "view-credit-notes";
    public static String VIEW_DEBIT_NOTES = "view-debit-notes";
    public static String VIEW_EVENTS = "view-events";

    public static String MANAGE_ORGANIZATION = "manage-organization";
    public static String MANAGE_INVOICES = "manage-documents";
    public static String MANAGE_CREDIT_NOTES = "manage-credit-notes";
    public static String MANAGE_DEBIT_NOTES = "manage-debit-notes";
    public static String MANAGE_EVENTS = "manage-events";

    public static String[] ALL_ORGANIZATION_ROLES = {
            /**
             * */
            VIEW_ORGANIZATION, VIEW_INVOICES, VIEW_CREDIT_NOTES, VIEW_DEBIT_NOTES, VIEW_EVENTS,

            /**
             * */
            MANAGE_ORGANIZATION, MANAGE_INVOICES, MANAGE_CREDIT_NOTES, MANAGE_DEBIT_NOTES, MANAGE_EVENTS};

}
