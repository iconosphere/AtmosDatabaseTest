package com.example.atmosdatabasetest.view_models;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.atmosdatabasetest.data.SavedBlendRepository;

public class SavedBlendViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    SavedBlendRepository savedBlendRepository;

    public SavedBlendViewModelFactory(SavedBlendRepository repository) {
        this.savedBlendRepository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new SavedBlendViewModel(savedBlendRepository);
    }
}
