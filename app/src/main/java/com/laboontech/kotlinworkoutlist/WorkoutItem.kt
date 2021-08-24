package com.laboontech.kotlinworkoutlist

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "workout_items")
data class WorkoutItem(@ColumnInfo(name = "item_name") var name: String, @ColumnInfo(name = "item_sets") var sets: Int) {

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}