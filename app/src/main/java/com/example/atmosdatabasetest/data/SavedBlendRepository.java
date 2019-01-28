package com.example.atmosdatabasetest.data;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class SavedBlendRepository {

    static SavedBlendRepository INSTANCE;
    SavedBlendDao savedBlendDao;

    public SavedBlendRepository(SavedBlendDao savedBlendDao) {
        this.savedBlendDao = savedBlendDao;
    }

    public static SavedBlendRepository getInstance(SavedBlendDao savedBlendDao) {
        if (INSTANCE == null) {
            synchronized (SavedBlend.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SavedBlendRepository(savedBlendDao);
                }
            }
        }
        return INSTANCE;
    }

    public LiveData<SavedBlend> getSavedBlend(String blendId) {
        return savedBlendDao.getSavedBlendForBlend(blendId);
    }

    public LiveData<List<SavedBlend>> getSavedBlends() {
        return savedBlendDao.getSavedBlends();
    }

    public LiveData<List<Both>> getBoth() {
        return savedBlendDao.getBoth();
    }

    public void createSavedBlend(String blendId) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                SavedBlend savedBlend = new SavedBlend(blendId);
                savedBlendDao.insertSavedBlend(savedBlend);
            }
        });
    }
}
