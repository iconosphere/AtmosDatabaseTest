package com.example.atmosdatabasetest.view_models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.atmosdatabasetest.data.Blend;
import com.example.atmosdatabasetest.data.BlendRepository;
import com.example.atmosdatabasetest.data.SavedBlend;
import com.example.atmosdatabasetest.data.SavedBlendRepository;

public class BlendDetailViewModel extends ViewModel {
    private final LiveData<SavedBlend> savedBlendForBlend;
    SavedBlendRepository savedBlendRepository;
    LiveData<Boolean> isSaved;
    public LiveData<Blend> blend;
    String blendId;


    public BlendDetailViewModel(BlendRepository blendRepository,
                                SavedBlendRepository savedBlendRepository,
                                String blendId) {
        this.blendId = blendId;
        this.blend = blendRepository.getBlend(blendId);
        this.savedBlendRepository = savedBlendRepository;
        savedBlendForBlend = savedBlendRepository.getSavedBlend(blendId);
    }

    public void saveBlend() {
        savedBlendRepository.createSavedBlend(blendId);
    }

    public LiveData<Blend> getBlend() {
        return blend;
    }
}
