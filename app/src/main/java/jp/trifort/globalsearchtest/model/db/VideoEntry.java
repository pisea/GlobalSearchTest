package jp.trifort.globalsearchtest.model.db;

import android.app.SearchManager;
import android.provider.BaseColumns;

/**
 * Created by j.lee on 2017/06/29.
 */

public final class VideoEntry implements BaseColumns {

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

}
