package com.example.atmosdatabasetest.view_models;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.atmosdatabasetest.data.Blend;
import com.example.atmosdatabasetest.data.BlendRepository;

import java.util.List;

public class BlendViewModel extends ViewModel {

    private BlendRepository mRepository;
    private LiveData<List<Blend>> mAllBlends;

    public BlendViewModel(@NonNull Application application) {
        super(application);
        mRepository = new BlendRepository(application);
        mAllBlends = mRepository.getAllBlends();
    }

    public LiveData<List<Blend>> getAllBlends() {
        return mAllBlends;
    }

}

