package com.example.tp

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Context.*
import android.location.Location
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
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import database.AppDatabase
import database.CompanyDetails
import kotlinx.coroutines.launch
import java.util.stream.Stream

class AdminAddCompany : BaseFragment() {
    private var notificationId = 0;
    private val CHANNEL_ID = "Add_company_notification"

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
        s_button.setOnClickListener {
            val companyName = view.findViewById<EditText>(R.id.company_name).text.toString().trim()
            var minCgpa = view.findViewById<EditText>(R.id.input_min_cgpa).text.toString().trim().toFloatOrNull()
            if(minCgpa==null)
            {
                minCgpa= 0.0f
            }
            var maxBacklogs = view.findViewById<EditText>(R.id.input_max_backlogs).text.toString().trim().toIntOrNull()
            if(maxBacklogs== null)
            {
                maxBacklogs = 0
            }
            var stream = view.findViewById<EditText>(R.id.input_streams).text.toString()
            if(stream== "")
            {
                stream = "Any"
            }
            var jD = view.findViewById<EditText>(R.id.input_job_desc).text.toString()
            var location = view.findViewById<EditText>(R.id.input_location).text.toString()
            if(location== "")
            {
                location = "will be informed later"
            }
            var stipend = view.findViewById<EditText>(R.id.input_stipend).text.toString()
            if(stipend== "")
            {
                stipend = "will be informed later"
            }
            var notes = view.findViewById<EditText>(R.id.input_additional_info).toString()
            //validation
            if(companyName!="")
            {
                val obj = CompanyDetails(companyName,minCgpa,maxBacklogs,stream,jD, location,stipend,notes)
                launch {
                    context?.let()
                    {

                        AppDatabase(requireActivity()).getCompanyDetailsDao().addCompanyDetails(obj)
                        Toast.makeText(it,"Insert Successful",Toast.LENGTH_SHORT).show()
                        createNotificationChannel()
                        Notify()

                    }

                }
            }
            else
            {
                Toast.makeText(context,"Enter Company Name",Toast.LENGTH_SHORT).show()
            }


        }

        val cancelButton = view.findViewById<Button>(R.id.button_cancel)
        cancelButton.setOnClickListener {
            //nav graph command
        }

        return view


    }
    fun Notify()
    {
        var builder =
            context?.let {
                NotificationCompat.Builder(it,CHANNEL_ID)
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
            val name ="New Company Added"
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




