package com.example.tp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import database.AppDatabase
import kotlinx.coroutines.launch

class StudentViewCompany : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        inflater.inflate(R.layout.fragment_student_view_companies, container, false)
        launch {
            context?.let {
                val students = AppDatabase(it).getStudentDetailsDao().getStudents()
            }

        }
        return view
    }
}