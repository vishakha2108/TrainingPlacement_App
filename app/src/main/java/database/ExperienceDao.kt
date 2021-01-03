package database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ExperienceDao
{
    @Insert
    suspend fun addExperience(company : CompanyDetails)

    //@Query("Select * from experience")
    //suspend fun getExperience():List<Experience>

}