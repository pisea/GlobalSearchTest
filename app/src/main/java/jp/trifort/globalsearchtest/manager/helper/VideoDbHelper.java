/*
 * Copyright (c) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jp.trifort.globalsearchtest.manager.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import jp.trifort.globalsearchtest.model.db.VideoEntry;

public class VideoDbHelper extends SQLiteOpenHelper {

    // Change this when you change the database schema.
    private static final int DATABASE_VERSION = 1;

    // The name of our database.
    private static final String DATABASE_NAME = "vod_video.db";

    // Name of the video table.
    public static final String TABLE_NAME = "video";

    public VideoDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a table to hold videos.
        final String SQL_CREATE_VIDEO_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
                VideoEntry._ID + " INTEGER PRIMARY KEY," +
                VideoEntry.COLUMN_ID + " TEXT NOT NULL, " +
                VideoEntry.COLUMN_TITLE + " TEXT NOT NULL, " +
                VideoEntry.COLUMN_STUDIO + " TEXT NOT NULL, " +
                VideoEntry.COLUMN_CARD_IMG + " TEXT NOT NULL, " +
                VideoEntry.COLUMN_ACTION + " TEXT NOT NULL " +
                " );";

        // Do the creating of the databases.
        db.execSQL(SQL_CREATE_VIDEO_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Simply discard all old data and start over when upgrading.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Do the same thing as upgrading...
        onUpgrade(db, oldVersion, newVersion);
    }
}
