package com.example.atmosdatabasetest.data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.Executors;

@Database(entities = {Blend.class}, version = 1, exportSchema = false)
public abstract class BlendRoomDatabase extends RoomDatabase {

    public abstract BlendDao blendDao();

    private static BlendRoomDatabase INSTANCE;

    public static BlendRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (BlendRoomDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here
                    INSTANCE = buildDatabase(context);
                }
            }
        }
        return INSTANCE;
    }

    private static BlendRoomDatabase buildDatabase(final Context context) {
        return Room.databaseBuilder(context.getApplicationContext(),
                BlendRoomDatabase.class,
                "blend_database")
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                            @Override
                            public void run() {
                                getDatabase(context).blendDao().insertAll(Blend.populateData());
                            }
                        });
                    }
                })
                .build();
    }
}