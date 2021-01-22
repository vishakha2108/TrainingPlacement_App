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

class AdminLogin : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_admin_login, container, false)
        val logbutton: Button = view.findViewById(R.id.button_enter)
        logbutton.setOnClickListener {
            val username: EditText = view.findViewById(R.id.input_name)
            val password: EditText = view.findViewById(R.id.input_password)
            if (username.text.toString().equals("abc")) {
                if (password.text.toString().equals("admin")) {
                    Toast.makeText(context, "Login Successful", Toast.LENGTH_LONG).show()
                    view.findNavController().navigate(R.id.action_adminLogin_to_adminDashboard)

                } else {
                    Toast.makeText(context, "Invalid Password ", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(context, "Invalid User Name", Toast.LENGTH_LONG).show()
            }
        }

        //back button
        val backButton = view.findViewById<Button>(R.id.button_back)
        backButton.setOnClickListener {
            //nav graph command
            view.findNavController().navigate(R.id.action_adminLogin_to_onboarding)
        }

        return view.rootView
    }
}