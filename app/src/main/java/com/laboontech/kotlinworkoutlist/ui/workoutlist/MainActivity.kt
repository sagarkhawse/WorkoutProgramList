package com.laboontech.kotlinworkoutlist.ui.workoutlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.laboontech.kotlinworkoutlist.R
import com.laboontech.kotlinworkoutlist.data.db.entities.WorkoutItem
import com.laboontech.kotlinworkoutlist.adapters.WorkoutItemAdapter
import com.laboontech.kotlinworkoutlist.ui.interfaces.AddItemDialogListener
import com.laboontech.kotlinworkoutlist.ui.viewmodel.WorkoutViewModel
import com.laboontech.kotlinworkoutlist.ui.viewmodel.WorkoutViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.InternalCoroutinesApi

import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(), KodeinAware {
    override val kodein by kodein()
    private val factory : WorkoutViewModelFactory by instance()


    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this,factory).get(WorkoutViewModel::class.java)

        val adapter = WorkoutItemAdapter(listOf(),viewModel)

        rvWorkout.adapter = adapter

        viewModel.getAllWorkoutItems().observe(this, Observer {
            adapter.items=it
            adapter.notifyDataSetChanged()
        })

        floatingActionButton.setOnClickListener {
            AddWorkoutItemDialog(this,object: AddItemDialogListener {
                override fun onAddClicked(item: WorkoutItem) {
                    viewModel.upsert(item)
                }
            }).show()
        }
    }


}