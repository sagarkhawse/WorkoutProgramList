package com.laboontech.kotlinworkoutlist.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.laboontech.kotlinworkoutlist.data.db.entities.WorkoutItem
import com.laboontech.kotlinworkoutlist.data.repositories.WorkoutRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WorkoutViewModel(private val repository: WorkoutRepository) : ViewModel() {
    fun upsert(item: WorkoutItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete(item: WorkoutItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllWorkoutItems() = repository.getAllWorkoutItems()
}