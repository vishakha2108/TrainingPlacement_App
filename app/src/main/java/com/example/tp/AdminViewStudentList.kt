package com.example.tp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import database.Experience

class AdminViewStudentList : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_admin_view_students, container, false)
        val ans = view.findViewById<TextView>(R.id.no_students)
        val experiences = FirebaseDatabase.getInstance().reference.child("Experiences")
        val listExperiences = ArrayList<Experience>()
        experiences.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                println(p0)

                if (p0.exists()) {
                    listExperiences.clear()
                    for (e in p0.children) {
                        println(e)
                        val element = e.getValue(Experience::class.java)
                        listExperiences.add(element!!)


                    }
                    ans.text = listExperiences.size.toString()

                }

            }

            override fun onCancelled(p0: DatabaseError) {
                TODO("Not yet implemented")
            }


        })




        //back button
        val backButton = view.findViewById<Button>(R.id.button_back)
        backButton.setOnClickListener {
            //nav graph command
            view.findNavController().navigate(R.id.action_adminViewStudentList_to_adminDashboard)
        }

        return view
    }
}