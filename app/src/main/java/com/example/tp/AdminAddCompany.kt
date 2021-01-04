package com.example.tp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.findNavController
import database.AppDatabase
import database.CompanyDetails
import kotlinx.coroutines.launch

class AdminAddCompany : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_admin_add_company, container, false)

        //save button
        val s_button: Button = view.findViewById(R.id.button_save)
        s_button.setOnClickListener {
            //company name
            val companyName = view.findViewById<EditText>(R.id.company_name).text.toString().trim()

            //cgpa
            var minCgpa = view.findViewById<EditText>(R.id.input_min_cgpa).text.toString().trim()
                .toFloatOrNull()
            if (minCgpa == null) {
                minCgpa = 0.0f
            }

            //backlogs
            var maxBacklogs =
                view.findViewById<EditText>(R.id.input_max_backlogs).text.toString().trim()
                    .toIntOrNull()
            if (maxBacklogs == null) {
                maxBacklogs = 0
            }

            //stream
            var stream = view.findViewById<EditText>(R.id.input_streams).text.toString()
            if (stream == "") {
                stream = "Any"
            }

            //job description
            var jD = view.findViewById<EditText>(R.id.input_job_desc).text.toString()

            //location
            var location = view.findViewById<EditText>(R.id.input_location).text.toString()
            if (location == "") {
                location = "will be informed later"
            }

            //stipend
            var stipend = view.findViewById<EditText>(R.id.input_stipend).text.toString()
            if (stipend == "") {
                stipend = "will be informed later"
            }

            //additional info
            var notes = view.findViewById<EditText>(R.id.input_additional_info).toString()

            //validation
            if (companyName != "") {
                val obj = CompanyDetails(
                    companyName,
                    minCgpa,
                    maxBacklogs,
                    stream,
                    jD,
                    location,
                    stipend,
                    notes
                )
                launch {
                    context?.let()
                    {

                        AppDatabase(requireActivity()).getCompanyDetailsDao().addCompanyDetails(obj)
                        Toast.makeText(it, "Insert Successful", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(context, "Enter Company Name", Toast.LENGTH_SHORT).show()
            }
        }

        //cancel button
        val cancelButton = view.findViewById<Button>(R.id.button_cancel)
        cancelButton.setOnClickListener {
            Toast.makeText(context, "Changes unsaved", Toast.LENGTH_LONG).show()

            //nav graph command
            view.findNavController().navigate(R.id.action_adminAddCompany_to_adminDashboard)
        }
        return view
    }
}
