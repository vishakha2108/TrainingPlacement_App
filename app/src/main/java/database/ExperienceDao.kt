package database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ExperienceDao
{
    @Insert
    suspend fun addExperience(experience : Experience)

    @Query("Select count(*) from experience")
    suspend fun getNoOfStudents():Int
    @Query("Select * from experience")
    suspend fun getAllExperiences():List<Experience>


}