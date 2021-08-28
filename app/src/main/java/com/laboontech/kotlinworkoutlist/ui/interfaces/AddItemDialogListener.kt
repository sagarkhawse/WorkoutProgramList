package com.laboontech.kotlinworkoutlist.ui.interfaces

import com.laboontech.kotlinworkoutlist.data.db.entities.WorkoutItem

interface AddItemDialogListener {
    fun onAddClicked(item: WorkoutItem)
}