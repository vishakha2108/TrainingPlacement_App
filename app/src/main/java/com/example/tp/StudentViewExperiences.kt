package com.example.tp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import database.CompanyDetails
import database.Experience
import kotlinx.coroutines.launch

class StudentViewExperiences : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_student_view_experiences, container, false)
        val list_experiences = ArrayList<Experience>()
        val experiences = FirebaseDatabase.getInstance().getReference().child("Experiences")
        experiences.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                println(p0)

                if (p0.exists()) {
                    list_experiences.clear()
                    for (e in p0.children) {
                        println(e)
                        val element = e.getValue(Experience::class.java)
                        list_experiences.add(element!!)

                    }
                    view.findViewById<RecyclerView>(R.id.experiences_list_view).adapter =
                        ExperienceAdapter(experience_item = list_experiences)

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
            view.findNavController()
                .navigate(R.id.action_studentViewExperiences_to_studentDashboard)
        }

        return view

    }
}