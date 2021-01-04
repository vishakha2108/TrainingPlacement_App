package com.example.tp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class StudentEdit : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_student_edit, container, false)

        //cancel
        val cancel = view.findViewById<Button>(R.id.button_cancel)
        cancel.setOnClickListener {
            Toast.makeText(context, "Changes unsaved", Toast.LENGTH_LONG).show()

            //nav graph command
            view.findNavController().navigate(R.id.action_studentEdit_to_studentDashboard)

        }

        //save
        val save = view.findViewById<Button>(R.id.button_save)
        save.setOnClickListener {
            Toast.makeText(context, "Changes saved successfully", Toast.LENGTH_LONG).show()
            //nav graph command
            view.findNavController().navigate(R.id.action_studentEdit_to_studentDashboard)
        }

        return view.rootView
    }
}