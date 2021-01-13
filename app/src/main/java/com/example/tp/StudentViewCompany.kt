package com.example.tp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import database.CompanyDetails

class StudentViewCompany : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_student_view_companies, container, false)
        val  lc  = ArrayList<CompanyDetails>()
        val companies  = FirebaseDatabase.getInstance().getReference().child("Companies")
        companies.addValueEventListener(object :ValueEventListener
        {
            override fun onDataChange(p0: DataSnapshot) {
                println(p0)

                if(p0.exists())
                {
                    lc.clear()
                    for(e in p0.children)
                    {
                        println(e)
                        val element = e.getValue(CompanyDetails::class.java)
                        lc.add(element!!)
                        println(element.companyName)
                    }

                }
                println(lc.size)
                view.findViewById<RecyclerView>(R.id.companies_list_view).adapter =ListAdapter(item = lc)
                //Toast.makeText(context,"abc",Toast.LENGTH_SHORT).show()



            }

            override fun onCancelled(p0: DatabaseError) {
                TODO("Not yet implemented")
            }


        })













        //back button
        val backButton = view.findViewById<Button>(R.id.button_back)
        backButton.setOnClickListener {
            //nav graph command
            view.findNavController().navigate(R.id.action_studentViewCompany_to_studentDashboard)
        }

        return view
    }
}


