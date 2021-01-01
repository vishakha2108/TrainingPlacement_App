package database

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface LoginDao
{
    @Insert
    suspend fun addLogin(login:Login)
}
