package com.example.tp

import android.content.Context
import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import database.AppDatabase
import database.CompanyDetails
import kotlinx.coroutines.launch
import java.util.stream.Stream

class AdminAddCompany : BaseFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_admin_add_company, container, false)
        val s_button :Button= view.findViewById(R.id.button_save)
        println("b")
        s_button.setOnClickListener {
            println("h1")
            val companyName = view.findViewById<EditText>(R.id.company_name).text.toString()
            val minCgpa = view.findViewById<EditText>(R.id.input_min_cgpa).text.toString().toFloat()
            val maxBacklogs = view.findViewById<EditText>(R.id.input_max_backlogs).text.toString().toInt()
            val stream = view.findViewById<EditText>(R.id.input_streams).text.toString()
            val jD = view.findViewById<EditText>(R.id.input_job_desc).text.toString()
            val location = view.findViewById<EditText>(R.id.input_location).text.toString()
            val stipend = view.findViewById<EditText>(R.id.input_stipend).text.toString().toInt()
            val notes = view.findViewById<EditText>(R.id.input_additional_info).toString()
            //validation
            if(companyName!=null)
            {
                val obj = CompanyDetails(companyName,minCgpa,maxBacklogs,stream,jD, location,stipend,notes)
                launch {
                    context?.let()
                    {
                        println("h2")
                        AppDatabase(requireActivity()).getCompanyDetailsDao().addCompanyDetails(obj)
                        println("h3")
                        Toast.makeText(it,"Insert Successful",Toast.LENGTH_SHORT).show()

                    }

                }
            }
            else
            {
                Toast.makeText(context,"Enter Company Name",Toast.LENGTH_SHORT).show()
            }


        }
        return view


    }




}