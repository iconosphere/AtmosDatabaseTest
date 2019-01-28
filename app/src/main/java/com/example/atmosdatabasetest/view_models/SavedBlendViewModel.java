package com.example.atmosdatabasetest.view_models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.atmosdatabasetest.data.Both;
import com.example.atmosdatabasetest.data.SavedBlend;
import com.example.atmosdatabasetest.data.SavedBlendRepository;

import java.util.ArrayList;
import java.util.List;

public class SavedBlendViewModel extends ViewModel {

    public LiveData<List<Both>> both;
    public LiveData<List<SavedBlend>> savedBlends;

    public SavedBlendViewModel(SavedBlendRepository savedBlendRepository) {
        savedBlends = savedBlendRepository.getSavedBlends();
        both = Transformations.map(savedBlendRepository.getBoth(), input -> {
            List<Both> bothListNew = new ArrayList<>();
            for (int i = 0; i < input.size(); i++) {
                if (input.get(i).getSavedBlends() != null && !input.get(i).getSavedBlends().isEmpty()) {
                    bothListNew.add(input.get(i));
                }
            }
            return bothListNew;
        });
    }
}
