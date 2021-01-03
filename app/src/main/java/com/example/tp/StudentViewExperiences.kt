package com.example.tp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import database.AppDatabase
import kotlinx.coroutines.launch

class StudentViewExperiences : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_student_view_experiences, container, false)
        launch {
            context?.let {
                val experiences = AppDatabase(it).getExperienceDao().getAllExperiences()
            }

        }
        return view

    }
}