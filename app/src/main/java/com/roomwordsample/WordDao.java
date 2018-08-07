package com.roomwordsample;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface WordDao {

    @Insert
    void insert(Word word);

    @Query("DELETE FROM word_table")
    void deleteAll();

    @Query("SELECT * from word_table ORDER BY userid ASC")
    LiveData<List<Word>> getAllWords();

    @Query("SELECT pass from word_table WHERE mail = :email")
    String getPassword(String email);

    @Query("SELECT userid from word_table WHERE mail = :email")
    int getUserid(String email);

}
