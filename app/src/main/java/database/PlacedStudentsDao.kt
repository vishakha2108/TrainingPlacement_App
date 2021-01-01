package database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PlacedStudentsDao
{
    @Insert
    suspend fun addPlacedStudentDetails(pstud:PlacedStudents)

    @Query("Select count(*) from placed_students ")
    suspend fun getCount(collname:String):List<PlacedStudents>



}
