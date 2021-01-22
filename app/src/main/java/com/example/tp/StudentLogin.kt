package com.example.tp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import database.StudentDetails

class StudentLogin : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_student_login, container, false)
        val logbutton: Button = view.findViewById(R.id.button_enter)
        logbutton.setOnClickListener {
            val username: EditText = view.findViewById(R.id.input_name)
            val password: EditText = view.findViewById(R.id.input_password)
            var flag = 1
            val students = FirebaseDatabase.getInstance().reference.child("Students")
            students.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(p0: DataSnapshot) {
                    if (p0.exists()) {

                        for (e in p0.children) {
                            println(e)
                            val element = e.getValue(StudentDetails::class.java)
                            if (username.text.toString().equals(element!!.fullName)) {
                                if (password.text.toString().equals(element.password)) {
                                    Toast.makeText(context, "Login Successful", Toast.LENGTH_LONG)
                                        .show()
                                    view.findNavController()
                                        .navigate(R.id.action_studentLogin_to_studentDashboard)

                                } else {
                                    Toast.makeText(context, "Invalid Password ", Toast.LENGTH_LONG)
                                        .show()
                                }
                                flag = 1
                                break
                            }
                        }
                        if (flag == 0) {
                            Toast.makeText(context, "Sign Up First ", Toast.LENGTH_LONG).show()

                        }
                    }


                }

                override fun onCancelled(p0: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })


        }

        //back button
        val backButton = view.findViewById<Button>(R.id.button_back)
        backButton.setOnClickListener {
            //nav graph command
            view.findNavController().navigate(R.id.action_studentLogin_to_onboarding)
        }

        return view.rootView
    }
}