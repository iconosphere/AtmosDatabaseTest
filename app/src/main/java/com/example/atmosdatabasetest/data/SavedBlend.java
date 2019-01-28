package com.example.atmosdatabasetest.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Calendar;

@Entity(
        tableName = "saved_blends",
        foreignKeys = {@ForeignKey(entity = Blend.class, parentColumns = {"id"}, childColumns = {"blend_id"})},
        indices = {@Index("blend_id")}
)
public class SavedBlend {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public long savedBlendId = 0;

    @ColumnInfo(name = "blend_id")
    public String blendId;

    @ColumnInfo(name = "save_date")
    public Calendar saveDate = Calendar.getInstance();

    public SavedBlend(String blendId) {
        this.blendId = blendId;
    }
}
