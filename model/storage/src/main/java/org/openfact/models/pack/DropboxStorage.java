package org.openfact.models.pack;

import com.dropbox.core.DbxAppInfo;
import com.dropbox.core.DbxAuthFinish;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxWebAuthNoRedirect;
import com.dropbox.core.v1.DbxAccountInfo;
import com.dropbox.core.v1.DbxClientV1;
import com.dropbox.core.v1.DbxEntry;
import com.dropbox.core.v1.DbxWriteMode;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.util.List;
import java.util.Locale;
/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 27/07/2016.
 */
public class DropboxStorage {
    private static final String DROP_BOX_APP_KEY = "bxsicd65ljq0ymh";
    private static final String DROP_BOX_APP_SECRET = "3t1lqvq1amaehb1";
    DbxClientV1 dbxClient;

    public DbxClientV1 authDropbox(String dropBoxAppKey, String dropBoxAppSecret) throws IOException, DbxException {
        DbxAppInfo dbxAppInfo = new DbxAppInfo(dropBoxAppKey, dropBoxAppSecret);
        DbxRequestConfig dbxRequestConfig = new DbxRequestConfig("OpenFact/1.0", Locale.getDefault().toString());
        DbxWebAuthNoRedirect dbxWebAuthNoRedirect = new DbxWebAuthNoRedirect(dbxRequestConfig, dbxAppInfo);
        String authorizeUrl = dbxWebAuthNoRedirect.start();
        System.out.println("1. Authorize: Go to URL and click Allow : " + authorizeUrl);
        System.out.println("2. Auth Code: Copy authorization code and input here ");
        String dropboxAuthCode = new BufferedReader(new InputStreamReader(System.in)).readLine().trim();
        DbxAuthFinish authFinish = dbxWebAuthNoRedirect.finish(dropboxAuthCode);
        String authAccessToken = authFinish.getAccessToken();
        this.dbxClient = new DbxClientV1(dbxRequestConfig, authAccessToken);
        System.out.println("Dropbox Account Name: " + this.dbxClient.getAccountInfo().displayName);
        return this.dbxClient;
    }

    public long getDropboxSize() throws DbxException {
        long dropboxSize = 0;
        DbxAccountInfo dbxAccountInfo = this.dbxClient.getAccountInfo();
        dropboxSize = dbxAccountInfo.quota.total / 1024 / 1024 / 1024;
        return dropboxSize;
    }

    public void uploadToDropbox(String fileName) throws DbxException, IOException {
        File inputFile = new File(fileName);
        FileInputStream fis = new FileInputStream(inputFile);
        try {
            DbxEntry.File uploadedFile = this.dbxClient.uploadFile("/" + fileName, DbxWriteMode.add(), inputFile.length(), (InputStream)fis);
            String sharedUrl = this.dbxClient.createShareableUrl("/" + fileName);
            System.out.println("Uploaded: " + uploadedFile.toString() + " URL " + sharedUrl);
        }
        finally {
            fis.close();
        }
    }

    public void createFolder(String folderName) throws DbxException {
        this.dbxClient.createFolder("/" + folderName);
    }

    public void listDropboxFolders(String folderPath) throws DbxException {
        DbxEntry.WithChildren listing = this.dbxClient.getMetadataWithChildren(folderPath);
        System.out.println("Files List:");
        for (DbxEntry child : listing.children) {
            System.out.println("\t" + child.name + ": " + child.toString());
        }
    }

    public void downloadFromDropbox(String fileName) throws DbxException, IOException {
        FileOutputStream outputStream = new FileOutputStream(fileName);
        try {
            DbxEntry.File downloadedFile = this.dbxClient.getFile("/" + fileName, null, (OutputStream)outputStream);
            System.out.println("Metadata: " + downloadedFile.toString());
        }
        finally {
            outputStream.close();
        }
    }
}
