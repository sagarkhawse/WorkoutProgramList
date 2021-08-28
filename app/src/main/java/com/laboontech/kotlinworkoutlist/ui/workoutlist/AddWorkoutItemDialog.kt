package com.laboontech.kotlinworkoutlist.ui.workoutlist

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatDialog
import com.laboontech.kotlinworkoutlist.R
import com.laboontech.kotlinworkoutlist.data.db.entities.WorkoutItem
import kotlinx.android.synthetic.main.dialog_add_item.*

class AddWorkoutItemDialog(context: Context, var addItemDialogListener: AddItemDialogListener) : AppCompatDialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_item)
        add.setOnClickListener {
            val name = etWorkoutName.text.toString().trim()
            val sets = etSets.text.toString().trim()

            when {
                name.isEmpty() -> {
                    etWorkoutName.error="Workout name required"
                    etWorkoutName.requestFocus()
                }
                sets.isEmpty() -> {
                    etSets.error="Sets required"
                    etSets.requestFocus()
                }
                else -> {
                    val item = WorkoutItem(name,sets.toInt())
                    addItemDialogListener.onAddClicked(item)
                    dismiss()
                }
            }



        }

        cancel.setOnClickListener { cancel() }
    }
}