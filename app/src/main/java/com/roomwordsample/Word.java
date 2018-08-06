package com.roomwordsample;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "word_table")
public class Word {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;

    @NonNull
    @ColumnInfo(name = "tit")
    private String tit;

    @NonNull
    @ColumnInfo(name = "desc")
    private String desc;

    @NonNull
    @ColumnInfo(name = "userid")
    private String userid;

    public Word( @NonNull String tit, @NonNull String desc, @NonNull String userid) {
        this.tit = tit;
        this.desc = desc;
        this.userid = userid;
    }




    @NonNull
    public String getTit() {
        return tit;
    }

    @NonNull
    public String getDesc() {
        return desc;
    }

    @NonNull
    public String getUserid() {
        return userid;
    }

    public String toString() {
        return new StringBuilder(tit).append("\n").append(desc).append("\n").append(userid).toString();
    }
}
