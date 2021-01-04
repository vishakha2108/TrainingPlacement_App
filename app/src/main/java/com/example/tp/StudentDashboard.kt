package com.example.tp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class StudentDashboard : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_student_dashboard, container, false)
        val shareExperience = view.findViewById<Button>(R.id.button_share_experience)
        shareExperience.setOnClickListener {
            //nav graph command
            view.findNavController().navigate(R.id.action_studentDashboard_to_studentExperience)
        }
        val viewExperience = view.findViewById<Button>(R.id.button_view_experience)
        viewExperience.setOnClickListener {
            //nav graph command
            view.findNavController()
                .navigate(R.id.action_studentDashboard_to_studentViewExperiences)
        }
        val viewCompany = view.findViewById<Button>(R.id.button_view_companies)
        viewCompany.setOnClickListener {
            //nav graph command
            view.findNavController().navigate(R.id.action_studentDashboard_to_studentViewCompany)
        }

        return view.rootView
    }
}