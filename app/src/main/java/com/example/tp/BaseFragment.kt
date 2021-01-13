package com.example.tp


import androidx.fragment.app.Fragment
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.CoroutineScope


abstract class BaseFragment : Fragment() {

    val ref = FirebaseDatabase.getInstance().reference


}