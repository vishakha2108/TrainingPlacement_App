package database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDetailsDao
{
    @Insert
    suspend fun addStudentDetails(stud:StudentDetails)
    @Query("Select*from student_details")
    suspend fun getStudents():List<StudentDetails>


}
