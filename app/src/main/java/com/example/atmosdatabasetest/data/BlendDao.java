package com.example.atmosdatabasetest.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BlendDao {

    @Insert
    void insertAll(Blend... blends);

    @Query("SELECT * FROM blend_table ORDER BY id ASC")
    LiveData<List<Blend>> getAllBlends();

    @Query("SELECT * FROM blend_table WHERE id  = :blendId")
    LiveData<Blend> getBlend(String blendId);

}
