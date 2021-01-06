package com.example.tp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import database.AppDatabase
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
                view.findViewById<RecyclerView>(R.id.companies_list_view).adapter =
                    ListAdapter(item = companies)
            }

        }

        //back button
        val backButton = view.findViewById<Button>(R.id.button_back)
        backButton.setOnClickListener {
            //nav graph command
            view.findNavController().navigate(R.id.action_studentViewCompany_to_studentDashboard)
        }

        return view
    }
}