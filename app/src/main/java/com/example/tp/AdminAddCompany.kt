package com.example.tp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class AdminAddCompany : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_admin_add_company, container, false)

        //cancel
        val cancel = view.findViewById<Button>(R.id.button_cancel)
        cancel.setOnClickListener {
            view.findNavController().navigate(R.id.action_adminAddCompany_to_adminDashboard)
            Toast.makeText(context, "Changes unsaved", Toast.LENGTH_LONG).show()
        }

        //save
        val save = view.findViewById<Button>(R.id.button_save)
        save.setOnClickListener {
            view.findNavController().navigate(R.id.action_adminAddCompany_to_adminDashboard)
            Toast.makeText(context, "Changes saved successfully", Toast.LENGTH_LONG).show()
        }

        return view.rootView
    }
}