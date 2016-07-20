package org.openfact.models.utils;

import com.google.api.client.googleapis.media.MediaHttpDownloader;
import com.google.api.client.googleapis.media.MediaHttpDownloaderProgressListener;

/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 14/07/2016.
 */
public class DownloadProgressListener implements MediaHttpDownloaderProgressListener {

    @Override
    public void progressChanged(MediaHttpDownloader downloader) {
        switch (downloader.getDownloadState()) {
            case MEDIA_IN_PROGRESS:
                System.out.println("Download is in progress: " + downloader.getProgress());
                break;
            case MEDIA_COMPLETE:
                System.out.println("Download is Complete!");
                break;
        }
    }
}
