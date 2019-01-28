package com.example.atmosdatabasetest.view_models;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.example.atmosdatabasetest.data.Blend;
import com.example.atmosdatabasetest.data.BlendRepository;

import java.util.List;

public class BlendViewModel extends ViewModel {

    private BlendRepository mRepository;
    private MediatorLiveData<List<Blend>> blendList = new MediatorLiveData<>();

    BlendViewModel(BlendRepository blendRepository) {
        this.mRepository = blendRepository;
        LiveData<List<Blend>> liveBlendList = blendRepository.getBlends();
        blendList.addSource(liveBlendList, blends -> blendList.setValue(blends));
    }

    public MediatorLiveData<List<Blend>> getAllBlends() {
        return blendList;
    }

}

