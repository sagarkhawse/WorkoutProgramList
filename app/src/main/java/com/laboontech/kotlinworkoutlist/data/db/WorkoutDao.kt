package com.laboontech.kotlinworkoutlist.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.laboontech.kotlinworkoutlist.data.db.entities.WorkoutItem

@Dao
interface WorkoutDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: WorkoutItem)

    @Delete
    suspend fun delete(item: WorkoutItem)

    @Query("SELECT * FROM workout_items")
    fun getAllWorkoutItems() : LiveData<List<WorkoutItem>>
}