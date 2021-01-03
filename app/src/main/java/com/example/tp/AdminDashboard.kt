package com.example.tp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class AdminDashboard : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_admin_dashboard, container, false)
        //view student list
        val viewStudentList = view.findViewById<Button>(R.id.button_view_student_list)
        viewStudentList.setOnClickListener {
            //nav graph command
            view.findNavController().navigate(R.id.action_adminDashboard_to_adminViewStudentList)
        }

        //add company
        val addCompany = view.findViewById<Button>(R.id.button_add_company)
        addCompany.setOnClickListener {
            //nav graph command
            view.findNavController().navigate(R.id.action_adminDashboard_to_adminAddCompany)
        }

        //delete company
        val deleteCompany = view.findViewById<Button>(R.id.button_delete_company)
        deleteCompany.setOnClickListener {
            //nav graph command
            view.findNavController().navigate(R.id.action_adminDashboard_to_adminDeleteCompany)
        }

        return view.rootView
    }
}
