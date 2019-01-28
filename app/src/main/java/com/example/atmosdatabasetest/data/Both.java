package com.example.atmosdatabasetest.data;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.ArrayList;
import java.util.List;

public class Both {

    @Embedded
    Blend blend;

    @Relation(parentColumn = "id", entityColumn = "blend_id")
    List<SavedBlend> savedBlends = new ArrayList<>();

    public Blend getBlend() {
        return blend;
    }

    public List<SavedBlend> getSavedBlends() {
        return savedBlends;
    }
}
