package database

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface StudentDetailsDao
{
    @Insert
    suspend fun addStudentDetails(stud:StudentDetails)


}
