package com.laboontech.kotlinworkoutlist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.laboontech.kotlinworkoutlist.data.db.entities.WorkoutItem
import kotlinx.android.synthetic.*
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized
import org.kodein.di.Volatile

@Database(entities = [WorkoutItem::class], version = 1)
abstract class WorkoutDatabase: RoomDatabase(){
    abstract  fun getWorkoutDao() : WorkoutDao

    companion object{
        @Volatile
        private var instance: WorkoutDatabase? = null
        private val LOCK = Any()

        @InternalCoroutinesApi
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
            WorkoutDatabase::class.java,"WorkoutDB.db").build()

    }

}