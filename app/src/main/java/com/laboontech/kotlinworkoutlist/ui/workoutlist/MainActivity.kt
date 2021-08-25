package com.laboontech.kotlinworkoutlist.ui.workoutlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.laboontech.kotlinworkoutlist.R
import com.laboontech.kotlinworkoutlist.data.db.WorkoutDatabase
import com.laboontech.kotlinworkoutlist.data.repositories.WorkoutRepository
import kotlinx.coroutines.InternalCoroutinesApi

class MainActivity : AppCompatActivity() {
    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = WorkoutDatabase(this)
        val repository = WorkoutRepository(database)
        val factory = WorkoutViewModelFactory(repository)
        val viewModel = ViewModelProviders.of(this,factory).get(WorkoutViewModel::class.java)
    }
}