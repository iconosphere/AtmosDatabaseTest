package com.example.atmosdatabasetest.view_models;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.atmosdatabasetest.data.BlendRepository;
import com.example.atmosdatabasetest.data.SavedBlend;
import com.example.atmosdatabasetest.data.SavedBlendRepository;

public class BlendDetailViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private BlendRepository blendRepository;
    private SavedBlendRepository savedBlendRepository;
    private String blendId;

    public BlendDetailViewModelFactory(BlendRepository blendRepository,
                                       SavedBlendRepository savedBlendRepository,
                                       String blendId) {
        this.blendRepository = blendRepository;
        this.savedBlendRepository = savedBlendRepository;
        this.blendId = blendId;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new BlendDetailViewModel(blendRepository, savedBlendRepository, blendId);
    }
}
