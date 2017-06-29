package jp.trifort.globalsearchtest.model.db;

import android.app.SearchManager;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

import static jp.trifort.globalsearchtest.manager.VideoContract.BASE_CONTENT_URI;
import static jp.trifort.globalsearchtest.manager.VideoContract.CONTENT_AUTHORITY;
import static jp.trifort.globalsearchtest.manager.VideoContract.PATH_VIDEO;

/**
 * Created by j.lee on 2017/06/29.
 */

public final class VideoEntry implements BaseColumns {

    public static final Uri CONTENT_URI =
            BASE_CONTENT_URI.buildUpon().appendPath(PATH_VIDEO).build();

    public static final String CONTENT_TYPE =
            ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "." + PATH_VIDEO;

    public static final String TAG_GOOGLE_VIDEOS = "googlevideos";

    // Name of the video table.
    public static final String TABLE_NAME = "video";

    // Name of the video.
    public static final String COLUMN_ID = "episode_id";

    // Name of the video.
    public static final String COLUMN_TITLE =  SearchManager.SUGGEST_COLUMN_TEXT_1;

    // Column with the foreign key into the category table.
    public static final String COLUMN_STUDIO = SearchManager.SUGGEST_COLUMN_TEXT_2;

    // The card image for the video.
    public static final String COLUMN_CARD_IMG = SearchManager.SUGGEST_COLUMN_RESULT_CARD_IMAGE;

    // The action intent for the result.
    public static final String COLUMN_ACTION = SearchManager.SUGGEST_COLUMN_INTENT_ACTION;

    // Returns the Uri referencing a video with the specified id.
    public static Uri buildVideoUri(long id) {
        return ContentUris.withAppendedId(CONTENT_URI, id);
    }
}
