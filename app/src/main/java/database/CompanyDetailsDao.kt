package database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert

@Dao
interface CompanyDetailsDao
{
    @Insert
    suspend fun addCompanyDetails(company : CompanyDetails)

    //@Delete

}

