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
}
