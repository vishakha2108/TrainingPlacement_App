package com.example.tp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import database.AppDatabase
import database.CompanyDetails
import kotlinx.coroutines.launch

class StudentViewCompany : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_student_view_companies, container, false)
        launch {
            context?.let {
                //val students = AppDatabase(it).getStudentDetailsDao().getStudents()
                val companies = AppDatabase(it).getCompanyDetailsDao().getAllCompanies()
                view.findViewById<RecyclerView>(R.id.companies_list_view).adapter = ListAdapter(item = companies)
            }

        }
        return view
    }
}