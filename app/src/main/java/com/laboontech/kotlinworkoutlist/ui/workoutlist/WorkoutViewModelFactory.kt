package com.laboontech.kotlinworkoutlist.ui.workoutlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.laboontech.kotlinworkoutlist.data.repositories.WorkoutRepository

@Suppress("UNCHECKED_CAST")
class WorkoutViewModelFactory(private val repository: WorkoutRepository) : ViewModelProvider.NewInstanceFactory(){


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return WorkoutViewModel(repository) as T
    }
}