package com.example.tp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class Onboarding : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_onboarding, container, false)
        val logAsStudent = view.findViewById<Button>(R.id.button_student_login)
        logAsStudent.setOnClickListener {
            //nav graph command
            view.findNavController().navigate(R.id.action_onboarding_to_studentLogin)
        }
        val logAsAdmin = view.findViewById<Button>(R.id.button_admin_login)
        logAsAdmin.setOnClickListener {
            //nav graph command
            view.findNavController().navigate(R.id.action_onboarding_to_adminLogin)
        }
        return view.rootView
    }
}