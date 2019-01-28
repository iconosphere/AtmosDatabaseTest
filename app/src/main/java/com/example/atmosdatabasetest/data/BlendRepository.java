package com.example.atmosdatabasetest.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class BlendRepository {

    private BlendDao mBlendDao;
    private LiveData<List<Blend>> mAllBlends;

    public BlendRepository(Application application) {
        BlendRoomDatabase db = BlendRoomDatabase.getDatabase(application);
        mBlendDao = db.blendDao();
        mAllBlends = mBlendDao.getAllBlends();
    }

    public LiveData<List<Blend>> getAllBlends() {
        return mAllBlends;
    }
}
