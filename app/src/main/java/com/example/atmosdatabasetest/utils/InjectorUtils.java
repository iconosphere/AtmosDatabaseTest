package com.example.atmosdatabasetest.utils;

import android.content.Context;

import com.example.atmosdatabasetest.data.BlendRepository;
import com.example.atmosdatabasetest.data.BlendRoomDatabase;
import com.example.atmosdatabasetest.data.SavedBlendRepository;
import com.example.atmosdatabasetest.view_models.BlendDetailViewModelFactory;

public class InjectorUtils {

    private static BlendRepository getBlendRepository(Context context) {
        return BlendRepository.getInstance(BlendRoomDatabase.getDatabase(context).blendDao());
    }

    private static SavedBlendRepository getSavedBlendRepository(Context context) {
        return SavedBlendRepository.getInstance(BlendRoomDatabase.getDatabase(context).savedBlendDao());
    }

    public static BlendDetailViewModelFactory provideBlendDetailViewModelFactory(Context context, String blendId) {
        return new BlendDetailViewModelFactory(getBlendRepository(context), getSavedBlendRepository(context), blendId);
    }
}
