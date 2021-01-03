package com.example.tp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import database.AppDatabase
import database.Experience
import kotlinx.coroutines.launch

class StudentExperience : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_student_experience, container, false)
        val buttonS = view.findViewById<Button>(R.id.button_save)
        buttonS.setOnClickListener {
            val cName = view.findViewById<EditText>(R.id.company_name).text.toString().trim()
            val exp = view.findViewById<EditText>(R.id.input_share_experience).text.toString().trim()
            //
            //val sName = view.findViewById<EditText>(R.id.student_name).text.toString().trim()
            //val rollNo = view.findViewById<EditText>(R.id.roll_no).text.toString().trim()
            //validation
            if(cName!=""&&exp!="")//&&sName!=""&&rollNo!="")
            {
                launch {
                    //val obj : Experience = Experience(cName,rollNo.toInt(),sName,exp)
                    //AppDatabase(requireActivity()).getExperienceDao().addExperience(obj)
                    Toast.makeText(context,"Experience added. Thank you",Toast.LENGTH_SHORT)
                }
            }
            else
            {
                Toast.makeText(context,"Invalid Company Name",Toast.LENGTH_SHORT)
            }
        }
        val cancelButton = view.findViewById<Button>(R.id.button_cancel)
        cancelButton.setOnClickListener {
            //nav graph command
        }
        return view
    }
}