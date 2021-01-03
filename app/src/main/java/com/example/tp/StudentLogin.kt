package com.example.tp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class StudentLogin : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(R.layout.fragment_student, container, false)
        val logbutton: Button = view.findViewById(R.id.button_login_student)
        logbutton.setOnClickListener {
            val username: EditText = view.findViewById(R.id.email_placeholder_student)
            val password: EditText = view.findViewById(R.id.password_placeholder_student)
            if (username.text.toString().equals("abc")) {
                if (password.text.toString().equals("student")) {
                    Toast.makeText(context, "Login Successful", Toast.LENGTH_LONG).show()
                    println("hi")
                } else {
                    Toast.makeText(context, "Invalid Password ", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(context, "Invalid User Name", Toast.LENGTH_LONG).show()
            }
        }
        return view.rootView
    }
}