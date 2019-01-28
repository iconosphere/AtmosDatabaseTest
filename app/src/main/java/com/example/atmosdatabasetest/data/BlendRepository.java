package com.example.atmosdatabasetest.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class BlendRepository {

    private BlendDao blendDao;
    private static volatile BlendRepository INSTANCE;

    BlendRepository(BlendDao blendDao) {
        this.blendDao = blendDao;
    }

    public LiveData<List<Blend>> getBlends() {
        return blendDao.getAllBlends();
    }

    public  LiveData<Blend> getBlend(String id) {
        return blendDao.getBlend(id);
    }

    public static BlendRepository getInstance(BlendDao blendDao) {
        if (INSTANCE == null) {
            synchronized (BlendRepository.class) {
                if (INSTANCE == null)
                    INSTANCE = new BlendRepository(blendDao);
            }
        }
        return INSTANCE;
    }


/*    private BlendDao mBlendDao;
    private LiveData<List<Blend>> mAllBlends;

    public BlendRepository(Application application) {
        BlendRoomDatabase db = BlendRoomDatabase.getDatabase(application);
        mBlendDao = db.blendDao();
        mAllBlends = mBlendDao.getAllBlends();
    }

    public LiveData<List<Blend>> getAllBlends() {
        return mAllBlends;
    }
}*/
}