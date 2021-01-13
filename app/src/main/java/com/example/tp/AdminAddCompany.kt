package com.example.tp

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context.NOTIFICATION_SERVICE
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.navigation.findNavController
import database.CompanyDetails

class AdminAddCompany : BaseFragment() {

    private var notificationId = 0
    private val CHANNEL_ID = "Add_company_notification"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_admin_add_company, container, false)

        //save button
        val s_button: Button = view.findViewById(R.id.button_save_add)
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
            var notes = view.findViewById<EditText>(R.id.input_additional_info).text.toString()

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
                ref.child("Companies").child(companyName).setValue(obj).addOnCompleteListener()
                {
                    Toast.makeText(context, "Insert Successful", Toast.LENGTH_SHORT).show()
                    Notify()
                }
            } else {
                Toast.makeText(context, "Enter Company Name", Toast.LENGTH_SHORT).show()
            }
        }

        //cancel button
        val cancelButton = view.findViewById<Button>(R.id.button_cancel_add)
        cancelButton.setOnClickListener {
            Toast.makeText(context, "Changes not saved", Toast.LENGTH_LONG).show()
            createNotificationChannel()
            Notify()

            //nav graph command
            view.findNavController().navigate(R.id.action_adminAddCompany_to_adminDashboard)
        }

        //back button
        val backButton = view.findViewById<Button>(R.id.button_back)
        backButton.setOnClickListener {
            //nav graph command
            view.findNavController().navigate(R.id.action_adminAddCompany_to_adminDashboard)
        }

        return view
    }

    fun Notify() {
        var builder =
            context?.let {
                NotificationCompat.Builder(it, CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_next_button)
                    .setContentTitle("New Company Added")
                    .setContentText("Check your eligibility and apply now!!")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            }
        with(context?.let { NotificationManagerCompat.from(it) }) {
            if (builder != null) {
                this?.notify(notificationId, builder.build())
            }
        }
    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "New Company Added"
            val descriptionText = "Check your eligibility and apply now!!"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                context?.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}