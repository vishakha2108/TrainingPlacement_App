package database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "experience")
data class Experience (
    @ColumnInfo(name = "company_name")
    val CompanyName:String,
    @PrimaryKey
    val RollNo:Int,
    @ColumnInfo(name = "student_name")
    val StudentName:String,
    @ColumnInfo(name = "experience")
    val Exp:String

)