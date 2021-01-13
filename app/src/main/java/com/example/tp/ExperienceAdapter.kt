package com.example.tp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import database.Experience

class ExperienceAdapter(private val experience_item: List<Experience>) :
    RecyclerView.Adapter<ExperienceAdapter.ExperienceViewHolder>() {

    class ExperienceViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExperienceViewHolder {

        return ExperienceAdapter.ExperienceViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_list_experiences, parent, false)
        )
    }

    override fun getItemCount(): Int = experience_item.size

    override fun onBindViewHolder(holder: ExperienceViewHolder, position: Int) {

        holder.view.findViewById<TextView>(R.id.company_title_exp).text =
            experience_item[position].companyName
        holder.view.findViewById<TextView>(R.id.roll_no).text =
            experience_item[position].rollNo.toString()
        holder.view.findViewById<TextView>(R.id.student_name_exp).text =
            experience_item[position].studentName
        holder.view.findViewById<TextView>(R.id.experience).text = experience_item[position].exp
    }
}