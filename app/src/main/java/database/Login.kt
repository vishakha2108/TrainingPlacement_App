package database

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "login")
data class Login
    (
    @ColumnInfo(name = "admin_pass")
    val AdminPass :String,
    @ColumnInfo(name = "student_pass")
    val StudentPass:String
)