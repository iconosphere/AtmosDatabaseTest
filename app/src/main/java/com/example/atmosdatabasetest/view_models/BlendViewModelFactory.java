package com.example.atmosdatabasetest.view_models;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.atmosdatabasetest.data.BlendRepository;

public class BlendViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private BlendRepository blendRepository;

    public BlendViewModelFactory(BlendRepository blendRepository) {
        this.blendRepository = blendRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        BlendViewModel blendViewModel = new BlendViewModel(blendRepository);
        return (T) blendViewModel;
    }
}
