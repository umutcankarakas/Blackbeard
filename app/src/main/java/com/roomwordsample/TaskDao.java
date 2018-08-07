package com.roomwordsample;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface TaskDao {

    @Insert
    void insert(Task task);

    @Query("DELETE FROM task_table")
    void deleteAll();

    @Query("SELECT * from task_table ORDER BY userid ASC")
    LiveData<List<Task>> getAllTasks();

    @Query("SELECT * from task_table WHERE userid = :id " )
    LiveData<List<Task>> getAllTasksById(String id);
}
