package org.openfact.models.pack;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.googleapis.media.MediaHttpDownloader;
import com.google.api.client.googleapis.media.MediaHttpUploader;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.Drive.Files;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import org.openfact.models.utils.DownloadProgressListener;
import org.openfact.models.utils.UploadProgressListener;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 14/07/2016.
 */
public class GoogleDriveStorageFiles {
    /**
     * Be sure to specify the name of your application. If the application name is {@code null} or
     * blank, the application will log a warning. Suggested format is "MyCompany-ProductName/1.0".
     */
    private static final String APPLICATION_NAME = "";
    private static final String UPLOAD_FILE_PATH = "Enter File Path";
    private static final String DIR_FOR_DOWNLOADS = "Enter Download Directory";
    private static final java.io.File UPLOAD_FILE = new java.io.File(UPLOAD_FILE_PATH);
    /**
     * Directory to store user credentials.
     */
    private static final java.io.File DATA_STORE_DIR = new java.io.File(System.getProperty("user.home"), ".store/drive_sample");
    /**
     * Global instance of the JSON factory.
     */
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    /**
     * Global instance of the {@link com.google.api.client.util.store.DataStoreFactory}. The best practice is to make it a single
     * globally shared instance across your application.
     */
    private static FileDataStoreFactory dataStoreFactory;
    /**
     * Global instance of the HTTP transport.
     */
    private static HttpTransport httpTransport;
    /**
     * Global Drive API client.
     */
    private static Drive drive;
    JsonFactory jsonFactory;
    GoogleAuthorizationCodeFlow flow;
    Drive service;
    private String redirectURI;

    /**
     * Initialize initials attributes.
     *
     * @param String basic configuration parameters.
     */
    public GoogleDriveStorageFiles(String CLIENT_ID, String CLIENT_SECRET, String REDIRECT_URI) {
        this.redirectURI = REDIRECT_URI;
        httpTransport = new NetHttpTransport();
        jsonFactory = new JacksonFactory();
        flow = new GoogleAuthorizationCodeFlow.Builder(
                httpTransport, jsonFactory,
                CLIENT_ID, CLIENT_SECRET,
                Arrays.asList(DriveScopes.DRIVE))
                .setAccessType("online")
                .setApprovalPrompt("auto").build();
    }

    /**
     * Build and return an authorized Drive client service.
     *
     * @return an authorized Drive client service
     * @throws IOException
     */
   /* public static Drive getDriveService() throws IOException {
        Credential credential = authorize();
        return new Drive.Builder(
                httpTransport, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }*/

    /**
     * Authorizes the installed application to access user's protected data.
     */
    /*private static Credential authorize() throws Exception {
        // load client secrets
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY,
                new InputStreamReader(GoogleDriveStorageFiles.class.getResourceAsStream("/META-INF/client_secrets.json")));
        if (clientSecrets.getDetails().getClientId().startsWith("Enter") || clientSecrets.getDetails().getClientSecret().startsWith("Enter ")) {
            System.out.println("Enter Client ID and Secret from https://code.google.com/apis/console/?api=drive "
                    + "into org.openfact.models/src/main/resources/client_secrets.json");
            System.exit(1);
        }
        // set up authorization code flow
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                httpTransport, JSON_FACTORY, clientSecrets,
                Collections.singleton(DriveScopes.DRIVE_FILE)).setDataStoreFactory(dataStoreFactory)
                .build();
        // authorize
        return new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
    }*/

    /**
     * Uploads a file using either resumable or direct media upload.
     */
    private static File uploadFile(boolean useDirectUpload) throws IOException {
        File fileMetadata = new File();
        fileMetadata.setTitle(UPLOAD_FILE.getName());

        FileContent mediaContent = new FileContent("image/jpeg", UPLOAD_FILE);

        Files.Insert insert = drive.files().insert(fileMetadata, mediaContent);
        MediaHttpUploader uploader = insert.getMediaHttpUploader();
        uploader.setDirectUploadEnabled(useDirectUpload);
        uploader.setProgressListener(new UploadProgressListener());
        return insert.execute();
    }

    /**
     * Updates the name of the uploaded file to have a "drivetest-" prefix.
     */
    private static File updateFileWithTestSuffix(String id) throws IOException {
        File fileMetadata = new File();
        fileMetadata.setTitle("drivetest-" + UPLOAD_FILE.getName());

        Drive.Files.Update update = drive.files().update(id, fileMetadata);
        return update.execute();
    }

/*    public static void main(String[] args) {
        Preconditions.checkArgument(
                !UPLOAD_FILE_PATH.startsWith("Enter ") && !DIR_FOR_DOWNLOADS.startsWith("Enter "),
                "Please enter the upload file path and download directory in %s", GoogleDriveStorageFiles.class);

        try {
            httpTransport = GoogleNetHttpTransport.newTrustedTransport();
            dataStoreFactory = new FileDataStoreFactory(DATA_STORE_DIR);
            // authorization
            Credential credential = authorize();
            // set up the global Drive instance
            drive = new Drive.Builder(httpTransport, JSON_FACTORY, credential).setApplicationName(
                    APPLICATION_NAME).build();

            // run commands
            return;
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (Throwable t) {
            t.printStackTrace();
        }
        System.exit(1);
    }*/

    /**
     * Downloads a file using either resumable or direct media download.
     */
    private static void downloadFile(boolean useDirectDownload, File uploadedFile)
            throws IOException {
        // create parent directory (if necessary)
        java.io.File parentDir = new java.io.File(DIR_FOR_DOWNLOADS);
        if (!parentDir.exists() && !parentDir.mkdirs()) {
            throw new IOException("Unable to create parent directory");
        }
        OutputStream out = new FileOutputStream(new java.io.File(parentDir, uploadedFile.getTitle()));

        MediaHttpDownloader downloader =
                new MediaHttpDownloader(httpTransport, drive.getRequestFactory().getInitializer());
        downloader.setDirectDownloadEnabled(useDirectDownload);
        downloader.setProgressListener(new DownloadProgressListener());
        downloader.download(new GenericUrl(uploadedFile.getDownloadUrl()), out);
    }

    /**
     * Get the authorization URL for authorize the application.
     *
     * @return String URL for authorize the application.
     */
    public String getURL() {
        String url = flow.newAuthorizationUrl().setRedirectUri(redirectURI).build();
        return url;
    }

    /**
     * Set the authorization code and create the service.
     *
     * @param String authorization code.
     */
    public void setCode(String code) throws IOException {
        GoogleTokenResponse response = flow.newTokenRequest(code).setRedirectUri(redirectURI).execute();
        GoogleCredential credential = new GoogleCredential().setFromTokenResponse(response);

        //Create a new authorized API client
        service = new Drive.Builder(httpTransport, jsonFactory, credential).build();
    }


}
