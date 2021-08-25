package com.laboontech.kotlinworkoutlist.data.repositories

import com.laboontech.kotlinworkoutlist.data.db.WorkoutDatabase
import com.laboontech.kotlinworkoutlist.data.db.entities.WorkoutItem

class WorkoutRepository(private var db: WorkoutDatabase) {

    suspend fun upsert(item: WorkoutItem) = db.getWorkoutDao().upsert(item)
    suspend fun delete(item: WorkoutItem) = db.getWorkoutDao().delete(item)
    fun getAllWorkoutItems() = db.getWorkoutDao().getAllWorkoutItems()
}