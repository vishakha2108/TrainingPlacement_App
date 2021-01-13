package com.example.tp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.findNavController
import database.Experience
import kotlinx.coroutines.launch

class StudentExperience : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_student_experience, container, false)

        //save button
        val buttonS = view.findViewById<Button>(R.id.button_save_exp)
        buttonS.setOnClickListener {
            val cName = view.findViewById<EditText>(R.id.input_company_name).text.toString().trim()
            val exp =
                view.findViewById<EditText>(R.id.input_share_experience).text.toString().trim()

            val sName = view.findViewById<EditText>(R.id.input_student_name).text.toString().trim()
            val rollNo = view.findViewById<EditText>(R.id.input_student_rno).text.toString().trim()

            //validation
            if (cName != "" && exp != "" && sName != "" && rollNo != "") {
                    val obj: Experience = Experience(cName, rollNo.toInt(), sName, exp)

                ref.child("Experiences").child(rollNo).setValue(obj).addOnCompleteListener()
                {
                    Toast.makeText(context, "Experience added", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(context, "Invalid input", Toast.LENGTH_SHORT).show()
            }
        }

        //cancel button
        val cancelButton = view.findViewById<Button>(R.id.button_cancel_exp)
        cancelButton.setOnClickListener {
            Toast.makeText(context, "Changes not saved", Toast.LENGTH_LONG).show()
            //nav graph command
            view.findNavController().navigate(R.id.action_studentExperience_to_studentDashboard)
        }

        //back button
        val backButton = view.findViewById<Button>(R.id.button_back)
        backButton.setOnClickListener {
            //nav graph command
            view.findNavController().navigate(R.id.action_studentExperience_to_studentDashboard)
        }
        return view
    }
}