package com.laboontech.kotlinworkoutlist.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.laboontech.kotlinworkoutlist.R
import com.laboontech.kotlinworkoutlist.data.db.entities.WorkoutItem
import com.laboontech.kotlinworkoutlist.ui.viewmodel.WorkoutViewModel
import kotlinx.android.synthetic.main.item_workout.view.*

class WorkoutItemAdapter(var items: List<WorkoutItem>, private val viewModel: WorkoutViewModel) :
    RecyclerView.Adapter<WorkoutItemAdapter.WorkoutViewHolder>() {

    inner class WorkoutViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_workout, parent, false)
        return WorkoutViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: WorkoutViewHolder, position: Int) {
        val data = items[position]
        holder.itemView.tvWorkoutName.text=data.name
        holder.itemView.tvSets.text="Sets : ${data.sets}"

        holder.itemView.delete.setOnClickListener {
            viewModel.delete(data)
        }

        holder.itemView.add.setOnClickListener {
            data.sets++
            viewModel.upsert(data)
        }

        holder.itemView.minus.setOnClickListener {
            if (data.sets>0){
                data.sets--
                viewModel.upsert(data)
            }
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }
}