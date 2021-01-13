package com.example.tp

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.findNavController

class AdminDeleteCompany : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_admin_delete_company, container, false)

        //delete button
        val buttonDel = view.findViewById<Button>(R.id.button_delete_company)
        //println("h")
        buttonDel.setOnClickListener {
            val CName = view.findViewById<EditText>(R.id.company_name).text.toString().trim()
            if (CName != "") {
                AlertDialog.Builder(context).apply {
                    setTitle("Are you sure you want to delete this company's record")
                    setMessage("This operation cannot be undone")
                    setPositiveButton("Yes") { _, _ ->

                            ref.child("Companies").child(CName).removeValue().addOnCompleteListener(){
                            Toast.makeText(context, "Company Deleted", Toast.LENGTH_SHORT).show()}

                            //nav graph command
                            view.findNavController()
                                .navigate(R.id.action_adminDeleteCompany_to_adminDashboard)


                    }
                    setNegativeButton("No")
                    { _, _ ->

                    }

                }.show()
            } else {
                Toast.makeText(context, "Invalid Company Name", Toast.LENGTH_SHORT).show()
            }
        }

        //cancel button
        val cancelButton = view.findViewById<Button>(R.id.button_cancel_deletion)
        cancelButton.setOnClickListener {
            Toast.makeText(context, "Changes not saved", Toast.LENGTH_LONG).show()
            //nav graph command
            view.findNavController().navigate(R.id.action_adminDeleteCompany_to_adminDashboard)

        }

        //back button
        val backButton = view.findViewById<Button>(R.id.button_back)
        backButton.setOnClickListener {
            //nav graph command
            view.findNavController().navigate(R.id.action_adminDeleteCompany_to_adminDashboard)
        }

        return view
    }
}