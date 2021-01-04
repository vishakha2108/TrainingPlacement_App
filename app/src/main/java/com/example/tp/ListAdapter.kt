package com.example.tp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import database.CompanyDetails

class ListAdapter(private val item: List<CompanyDetails>) :
    RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    class ListViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ListViewHolder {
        return ListAdapter.ListViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_list_companies, parent, false)
        )
    }

    override fun getItemCount() = item.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        holder.view.findViewById<TextView>(R.id.company_title).text = item[position].CompanyName
        holder.view.findViewById<TextView>(R.id.min_cgpa).text = item[position].MinCgpa.toString()
        holder.view.findViewById<TextView>(R.id.max_backlog).text =
            item[position].MaxBacklogs.toString()
        holder.view.findViewById<TextView>(R.id.stream).text = item[position].Stream
        holder.view.findViewById<TextView>(R.id.job_description).text = item[position].JD
        holder.view.findViewById<TextView>(R.id.location).text = item[position].Location
        holder.view.findViewById<TextView>(R.id.stipend).text = item[position].Stipend
    }
}