package com.roomwordsample;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "word_table")
public class Word {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "userid")
    public int userid;

    @NonNull
    @ColumnInfo(name = "name")
    private String name;

    @NonNull
    @ColumnInfo(name = "mail")
    private String mail;

    @NonNull
    @ColumnInfo(name = "pass")
    private String pass;

    public Word( @NonNull String name, @NonNull String mail, @NonNull String pass) {
        this.name = name;
        this.mail = mail;
        this.pass = pass;
    }




    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public String getMail() {
        return mail;
    }

    @NonNull
    public String getPass() {
        return pass;
    }

    public String toString() {
        return new StringBuilder(name).append("\n").append(mail).append("\n").append(pass).toString();
    }
}
