import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.tp.BaseFragment
import com.example.tp.R
import database.StudentDetails
import kotlinx.coroutines.launch

class StudentRegistration : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_student_registration, container, false)

        //save button
        val sButton: Button = view.findViewById(R.id.button_save_register)
        sButton.setOnClickListener {

            val studentName = view.findViewById<EditText>(R.id.student_name).text.toString().trim()
            val rollNo = view.findViewById<EditText>(R.id.input_rno).text.toString().trim()
            val cgpa = view.findViewById<EditText>(R.id.input_cgpa).text.toString().trim()
            val backlogs = view.findViewById<EditText>(R.id.input_backlogs).text.toString().trim()
            val stream = view.findViewById<EditText>(R.id.input_stream).text.toString().trim()
            val password = view.findViewById<EditText>(R.id.input_password1).text.toString().trim()
            val phoneNo = view.findViewById<EditText>(R.id.input_contactno).text.toString().trim()

            //validation
            if (studentName != "" && rollNo != "" && cgpa != "" && backlogs != "" && stream != "" && phoneNo != "") {
                val obj = StudentDetails(
                    studentName,
                    rollNo.toInt(),
                    cgpa.toFloat(),
                    backlogs.toInt(),
                    stream,
                    phoneNo.toLong(),
                    password
                )

                ref.child("Students").child(rollNo).setValue(obj).addOnCompleteListener()
                {
                    Toast.makeText(context, "Sign up Successful", Toast.LENGTH_SHORT).show()
                    view.findNavController().navigate(R.id.action_studentRegistration_to_studentDashboard)
                }




            } else {
                Toast.makeText(context, "Details missing", Toast.LENGTH_SHORT).show()
            }
        }

        //cancel button
        val cancelButton = view.findViewById<Button>(R.id.button_cancel_register)
        cancelButton.setOnClickListener {
            //  nav graph command
            view.findNavController().navigate(R.id.action_studentRegistration_to_onboarding)
        }

        //back button
        val backButton = view.findViewById<Button>(R.id.button_back)
        backButton.setOnClickListener {
            //nav graph command
            view.findNavController().navigate(R.id.action_studentRegistration_to_onboarding)
        }
        return view.rootView
    }
}