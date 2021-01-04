package database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CompanyDetailsDao {
    @Insert
    suspend fun addCompanyDetails(company: CompanyDetails)

    @Query("delete from company_details where CompanyName = :cname")
    suspend fun delete(cname: String)

    @Query("Select *from company_details")
    suspend fun getAllCompanies(): List<CompanyDetails>

}