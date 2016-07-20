package org.openfact.models.pack;

import com.dropbox.core.*;
import com.dropbox.core.v1.DbxAccountInfo;
import com.dropbox.core.v1.DbxClientV1;
import com.dropbox.core.v1.DbxEntry;
import com.dropbox.core.v1.DbxWriteMode;

import java.io.*;
import java.util.Locale;

/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 14/07/2016.
 */
public class DropboxStorageFiles {
    private static final String DROP_BOX_APP_KEY = "bxsicd65ljq0ymh";
    private static final String DROP_BOX_APP_SECRET = "3t1lqvq1amaehb1";
    DbxClientV1 dbxClient;

/*    public static void main(String[] args) throws IOException, DbxException {
        DropboxStorageFiles dropbox = new DropboxStorageFiles();
        dropbox.authDropbox(DROP_BOX_APP_KEY, DROP_BOX_APP_SECRET);
        System.out.println("Dropbox Size: " + dropbox.getDropboxSize() + " GB");
        dropbox.uploadToDropbox("happy.png");
        dropbox.createFolder("Ahren");
        dropbox.listDropboxFolders("/");
        dropbox.downloadFromDropbox("happy.png");

    }*/

    public DbxClientV1 authDropbox(String dropBoxAppKey, String dropBoxAppSecret)
            throws IOException, DbxException {
        DbxAppInfo dbxAppInfo = new DbxAppInfo(dropBoxAppKey, dropBoxAppSecret);
        DbxRequestConfig dbxRequestConfig = new DbxRequestConfig(
                "JavaDropboxTutorial/1.0", Locale.getDefault().toString());
        DbxWebAuthNoRedirect dbxWebAuthNoRedirect = new DbxWebAuthNoRedirect(
                dbxRequestConfig, dbxAppInfo);
        String authorizeUrl = dbxWebAuthNoRedirect.start();
        System.out.println("1. Authorize: Go to URL and click Allow : "
                + authorizeUrl);
        System.out
                .println("2. Auth Code: Copy authorization code and input here ");
        String dropboxAuthCode = new BufferedReader(new InputStreamReader(
                System.in)).readLine().trim();
        DbxAuthFinish authFinish = dbxWebAuthNoRedirect.finish(dropboxAuthCode);
        String authAccessToken = authFinish.getAccessToken();
        dbxClient = new DbxClientV1(dbxRequestConfig, authAccessToken);
        System.out.println("Dropbox Account Name: "
                + dbxClient.getAccountInfo().displayName);

        return dbxClient;
    }

    /* returns Dropbox size in GB */
    public long getDropboxSize() throws DbxException {
        long dropboxSize = 0;
        DbxAccountInfo dbxAccountInfo = dbxClient.getAccountInfo();
        // in GB :)
        dropboxSize = dbxAccountInfo.quota.total / 1024 / 1024 / 1024;
        return dropboxSize;
    }

    public void uploadToDropbox(String fileName) throws DbxException,
            IOException {
        File inputFile = new File(fileName);
        FileInputStream fis = new FileInputStream(inputFile);
        try {
            DbxEntry.File uploadedFile = dbxClient.uploadFile("/" + fileName,
                    DbxWriteMode.add(), inputFile.length(), fis);
            String sharedUrl = dbxClient.createShareableUrl("/" + fileName);
            System.out.println("Uploaded: " + uploadedFile.toString() + " URL "
                    + sharedUrl);
        } finally {
            fis.close();
        }
    }

    public void createFolder(String folderName) throws DbxException {
        dbxClient.createFolder("/" + folderName);
    }

    public void listDropboxFolders(String folderPath) throws DbxException {
        DbxEntry.WithChildren listing = dbxClient
                .getMetadataWithChildren(folderPath);
        System.out.println("Files List:");
        for (DbxEntry child : listing.children) {
            System.out.println("	" + child.name + ": " + child.toString());
        }
    }

    public void downloadFromDropbox(String fileName) throws DbxException,
            IOException {
        FileOutputStream outputStream = new FileOutputStream(fileName);
        try {
            DbxEntry.File downloadedFile = dbxClient.getFile("/" + fileName,
                    null, outputStream);
            System.out.println("Metadata: " + downloadedFile.toString());
        } finally {
            outputStream.close();
        }
    }
}
