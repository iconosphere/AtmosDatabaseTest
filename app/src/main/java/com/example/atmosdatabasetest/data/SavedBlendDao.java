package com.example.atmosdatabasetest.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface SavedBlendDao {

    @Insert
    long insertSavedBlend(SavedBlend savedBlend);

    @Transaction
    @Query("SELECT * FROM blend_table")
    LiveData<List<Both>> getBoth();

    @Query("SELECT * FROM saved_blends WHERE id = :savedBlendId")
    LiveData<SavedBlend> getSavedBlend(long savedBlendId);

    @Query("SELECT * FROM saved_blends")
    LiveData<List<SavedBlend>> getSavedBlends();

    @Query("SELECT * FROM saved_blends WHERE blend_id = :blendId")
    LiveData<SavedBlend> getSavedBlendForBlend(String blendId);
}
