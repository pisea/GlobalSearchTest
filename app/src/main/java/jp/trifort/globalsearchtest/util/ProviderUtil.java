package jp.trifort.globalsearchtest.util;

import android.app.Activity;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

import jp.trifort.globalsearchtest.R;
import jp.trifort.globalsearchtest.manager.VideoContract;
import jp.trifort.globalsearchtest.model.Movie;
import jp.trifort.globalsearchtest.model.db.VideoEntry;

/**
 * Created by j.lee on 2017/06/30.
 */

public class ProviderUtil {

    /**
     * Check if there is a global search intent. If there is, load that video.
     */
    public static boolean hasGlobalSearchIntent(Activity activity) {

        Intent intent = activity.getIntent();
        String intentAction = intent.getAction();
        String globalSearch = activity.getString(R.string.global_search);

        if (globalSearch.equalsIgnoreCase(intentAction)) {

            return true;
        }

        return false;
    }

    // Returns the Uri referencing a video with the specified id.
    public static Uri buildVideoUri(long id) {
        return ContentUris.withAppendedId(VideoContract.CONTENT_URI, id);
    }

    public static void saveContentProvide(Context context, Object item) {

        ContentValues videoValues = new ContentValues();

        if (item instanceof Movie) {

            Movie movie = (Movie) item;

            videoValues.put(VideoEntry.COLUMN_ID, movie.getId());
            videoValues.put(VideoEntry.COLUMN_TITLE, movie.getTitle());
            videoValues.put(VideoEntry.COLUMN_STUDIO, movie.getStudio());
            videoValues.put(VideoEntry.COLUMN_CARD_IMG, movie.getCardImageUrl());

        }

        videoValues.put(VideoEntry.COLUMN_ACTION,
                context.getResources().getString(R.string.global_search));

        List<ContentValues> contentValuesList = new ArrayList<>();
        contentValuesList.add(videoValues);

        ContentValues[] downloadedVideoContentValues = contentValuesList.toArray(new ContentValues[contentValuesList.size()]);
        context.getContentResolver().bulkInsert(VideoContract.CONTENT_URI, downloadedVideoContentValues);

    }
}
